package webtienganh.service;

import java.util.List;
import java.util.Map;

import webtienganh.dto.ExamQuestionDTO;
import webtienganh.dto.ExamResultDTO;
import webtienganh.dto.NameSlugDTO;

public interface ExamService {

	ExamQuestionDTO getExamQuestion(String slug);

	ExamResultDTO getExamResult(String slug, Map<Integer, String> answers);

	List<NameSlugDTO> getListNameSlugs();
	
	List<Object> getQuestionsOfPart(String slug, int type);
}
