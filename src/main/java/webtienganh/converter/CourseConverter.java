package webtienganh.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webtienganh.dto.WordDTO;
import webtienganh.entity.Course;
import webtienganh.request.CourseInfoRequest;
import webtienganh.request.CourseRequest;

@Component
public class CourseConverter {

	@Autowired
	private WordConverter wordConverter;

	public CourseInfoRequest toCourseInfoRequest(Course course) {

		CourseInfoRequest result = new CourseInfoRequest();
		result.setName(course.getName());
		result.setSlug(course.getSlug());
		result.setImage(course.getImage());
		result.setDescription(course.getDescription());
		result.setWordNumber(course.getWords().size());
		result.setPersonNumber(course.getUsers().size());

		return result;
	}

	public CourseRequest toCourseRequest(Course course) {

		CourseRequest result = new CourseRequest();
		result.setName(course.getName());
		result.setSlug(course.getSlug());
		result.setImage(course.getImage());
		result.setDescription(course.getDescription());
		result.setWordNumber(course.getWords().size());
		result.setPersonNumber(course.getUsers().size());

		List<WordDTO> wordDTOs = new ArrayList<>();
		course.getWords().forEach(courseWord -> {

			WordDTO wordDTO = wordConverter.toWordDTO(courseWord.getWord());
			wordDTOs.add(wordDTO);
		});
		result.setWords(wordDTOs);

		return result;
	}

}
