package webtienganh.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSummaryDTO {

	private int stt;
	private String content;
	private String a;
	private String b;
	private String c;
	@Setter(AccessLevel.NONE)
	private String d;

	public void setD(String d) {

		if (d == null) {
			this.d = "";
			return;
		}

		this.d = d;
	}

}
