package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionResultDTO {

	private String choice;
	private QuestionDTO question;

	public boolean isCorrect() {

		return question.getResult().equalsIgnoreCase(choice);

	}

}
