package webtienganh.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTO extends VideoSummaryDTO {

	private String url;
	private List<SubtitleDTO> subtitles;

}
