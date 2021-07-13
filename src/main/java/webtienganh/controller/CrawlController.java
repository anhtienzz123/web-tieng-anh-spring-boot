package webtienganh.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webtienganh.converter.WordConverter;
import webtienganh.dto.WordDTO;
import webtienganh.entity.Course;
import webtienganh.entity.CourseWord;
import webtienganh.entity.CourseWord_PK;
import webtienganh.entity.Topic;
import webtienganh.entity.Word;
import webtienganh.repository.CourseRepository;
import webtienganh.repository.CourseWordRepository;
import webtienganh.repository.WordRepository;
import webtienganh.response.CourseResponse;
import webtienganh.utils.CommonFuc;

@RestController
@RequestMapping(value = "/crawl")
public class CrawlController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private WordRepository wordRepository;

	@Autowired
	private CourseWordRepository courseWordRepository;
	@Autowired
	private WordConverter wordConverter;

	@PostMapping("/courses")
	public void crawlCourse(@RequestBody CourseResponse courseReq, @RequestParam("topicId") Integer topicId) {

		System.out.println("size: " + courseReq.getWords().size());
		Integer courseId = saveCourse(courseReq, topicId);

		for (WordDTO word : courseReq.getWords()) {

			String name = word.getName();
			Optional<Word> wordOpt = wordRepository.findByName(name);

			Integer wordId = 0;
			if (wordOpt.isPresent()) {

				wordId = wordOpt.get().getId();
			} else {

				wordId = saveWord(word);
			}
			
			
			if (!courseWordRepository.existsById(new CourseWord_PK(courseId, wordId))) {

				CourseWord courseWord = new CourseWord(new Course(courseId), new Word(wordId));
				courseWordRepository.save(courseWord);
			}

		}

	}

	private Integer saveCourse(CourseResponse courseReq, Integer topicId) {

		String name = courseReq.getName();
		String slug = CommonFuc.toSlug(name);

		Optional<Course> courseOpt = courseRepository.findBySlug(slug);
		if (courseOpt.isPresent())
			return courseOpt.get().getId();

		Course course = new Course(name, slug, courseReq.getImage(), courseReq.getDescription(), new Topic(topicId));

		return courseRepository.save(course).getId();

	}

	private Integer saveWord(WordDTO wordDTO) {

		Word word = wordConverter.toWord(wordDTO);

		return wordRepository.save(word).getId();

	}
}
