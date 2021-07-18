package webtienganh.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Part3_4_6_7ResultGroupDTO {

	@Setter(AccessLevel.NONE)
	private String image;
	@Setter(AccessLevel.NONE)
	private String paragraph;
	@Setter(AccessLevel.NONE)
	private String transcript;
	private List<QuestionResultDTO> results = new ArrayList<>();

	public void setImage(String image) {

		if (image == null) {
			this.image = "";
			return;
		}

		this.image = image;
	}

	public void setParagraph(String paragraph) {

		if (paragraph == null) {
			this.paragraph = "";
			return;
		}

		this.paragraph = paragraph;
	}

	public void setTranscript(String transcript) {

		if (transcript == null) {
			this.transcript = "";
			return;
		}

		this.transcript = transcript;
	}

}
