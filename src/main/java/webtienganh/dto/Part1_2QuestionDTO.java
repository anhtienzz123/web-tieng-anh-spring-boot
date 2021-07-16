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
public class Part1_2QuestionDTO {

	private int stt;
	@Setter(AccessLevel.NONE)
	private String audio;
	private String content;

	public void setAudio(String audio) {

		if (audio == null) {

			this.audio = "";
			return;
		}

		this.audio = audio;
	}

}
