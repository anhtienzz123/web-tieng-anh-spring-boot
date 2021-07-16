package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.QuestionDTO;
import webtienganh.dto.QuestionResultDTO;
import webtienganh.dto.QuestionSummaryDTO;
import webtienganh.entity.Audio;
import webtienganh.entity.Question;

@Component
public class QuestionConverter {

	public QuestionSummaryDTO toQuestionSummaryDTO(Question question) {

		QuestionSummaryDTO result = new QuestionSummaryDTO();

		result.setStt(question.getStt());
		result.setContent(question.getContent());
		result.setA(question.getA());
		result.setB(question.getB());
		result.setC(question.getC());
		result.setD(question.getD());

		return result;
	}

	public QuestionDTO toQuestionDTO(Question question) {

		QuestionDTO result = new QuestionDTO();
		result.setStt(question.getStt());
		result.setContent(question.getContent());
		result.setA(question.getA());
		result.setB(question.getB());
		result.setC(question.getC());
		result.setD(question.getD());

		Audio audio = question.getAudio();
		String audioName = audio != null ? audio.getName() : "";
		result.setAudio(audioName);

		result.setType(question.getType());
		result.setResult(question.getResult());
		result.setExtra(question.getExtra());

		return result;
	}

	public QuestionResultDTO toQuestionResultDTO(Question question, String choice) {

		QuestionResultDTO result = new QuestionResultDTO();

		result.setChoice(choice);
		result.setQuestion(toQuestionDTO(question));

		return result;

	}

}
