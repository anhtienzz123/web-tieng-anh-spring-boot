package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDTO extends QuestionSummaryDTO {

	private int type;
	private String result;
	private String extra;
	private String audio;

}
