package webtienganh.service;

import java.util.Map;

import webtienganh.dto.ExamQuestionDTO;
import webtienganh.dto.ExamResultDTO;

public interface ExamService {

	ExamQuestionDTO getExamQuestionBySlug(String slug);
	
	ExamResultDTO getExamResult(String slug, Map<Integer, String> answers);
}
