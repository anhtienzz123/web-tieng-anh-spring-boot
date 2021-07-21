package webtienganh.service.impl;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.ExamConverter;
import webtienganh.dto.ExamQuestionDTO;
import webtienganh.dto.ExamResultDTO;
import webtienganh.entity.Exam;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.ExamRepository;
import webtienganh.service.ExamService;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private ExamConverter examConverter;

	@Override
	public ExamQuestionDTO getExamQuestionBySlug(String slug) {

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
}
