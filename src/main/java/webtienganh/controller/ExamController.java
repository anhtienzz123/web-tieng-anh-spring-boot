package webtienganh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webtienganh.dto.ExamQuestionDTO;
import webtienganh.dto.ExamResultDTO;
import webtienganh.service.ExamService;

@RestController
@RequestMapping(value = "/exams")
@CrossOrigin
public class ExamController {

	@Autowired
	private ExamService examService;

	@GetMapping("/{slug}")
	public ExamQuestionDTO getExamQuestionBySlug(@PathVariable("slug") String examSlug) {

		return examService.getExamQuestionBySlug(examSlug);
	}

	@PostMapping("/{slug}/result")
	public ExamResultDTO checkResult(@PathVariable("slug") String slug, @RequestBody Map<Integer, String> answers) {

		return examService.getExamResult(slug, answers);
	}

}
