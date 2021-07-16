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
public class Part3_4_6_7GroupDTO {

	@Setter(AccessLevel.NONE)
	private String image;
	@Setter(AccessLevel.NONE)
	private String pharagraph;
	private List<QuestionSummaryDTO> questions = new ArrayList<>();

	public void setImage(String image) {

		if (image == null) {
			this.image = "";
			return;
		}

		this.image = image;
	}

	public void setPharagraph(String pharagraph) {

		if (pharagraph == null) {
			this.pharagraph = "";
			return;
		}

		this.pharagraph = pharagraph;
	}

}
