package webtienganh.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.ExamConverter;
import webtienganh.converter.QuestionConverter;
import webtienganh.dto.ExamQuestionDTO;
import webtienganh.dto.ExamResultDTO;
import webtienganh.dto.NameSlugDTO;
import webtienganh.entity.Exam;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.ExamRepository;
import webtienganh.repository.ParagraphRepository;
import webtienganh.repository.QuestionRepository;
import webtienganh.service.ExamService;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;
	@Autowired
	private ExamConverter examConverter;

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private QuestionConverter questionConverter;

	@Autowired
	private ParagraphRepository paragraphRepository;

	@Override
	public ExamQuestionDTO getExamQuestion(String slug) {

		if (slug == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Exam exam = examRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.EXAM));

		return examConverter.toExamQuestionDTO(exam);
	}

	@Override
	public ExamResultDTO getExamResult(String slug, Map<Integer, String> answers) {

		if (slug == null || answers == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Exam exam = examRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.EXAM));

		return examConverter.toExamResultDTO(exam, answers);
	}

	@Override
	public List<NameSlugDTO> getListNameSlugs() {

		return examRepository.findAll().stream().map(examEle -> new NameSlugDTO(examEle.getName(), examEle.getSlug()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Object> getQuestionsOfPart(String slug, int type) {

		if (slug == null || type < 1 || type > 7)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Exam exam = examRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.EXAM));
		Integer examId = exam.getId();

		if (type == 1 || type == 2 || type == 5) {

			return questionRepository.findAllByTypeAndExamIdOrderByStt(type, examId).stream()
					.map(questionEle -> questionConverter.toQuestionDTO(questionEle)).collect(Collectors.toList());
		}

		return paragraphRepository.findAllByExamIdAndQuestionType(examId, type).stream()
				.map(paragraphEle -> examConverter.toPart3_4_6_7GroupDTO(paragraphEle)).collect(Collectors.toList());
	}

}
