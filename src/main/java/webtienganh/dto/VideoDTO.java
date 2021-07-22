package webtienganh.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	private String description;
	private int level;
	private List<SubtitleDTO> subtitles;
	private List<VideoWordDTO> videoWords;

	@JsonProperty(access = Access.WRITE_ONLY)
	private Integer categoryId;
	private String categoryName;

}
