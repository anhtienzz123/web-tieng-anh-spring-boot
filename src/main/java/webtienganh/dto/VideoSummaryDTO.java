package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webtienganh.utils.CommonFuc;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoSummaryDTO {

	private Integer id;
	private String name;
	private String slug;
	private String image;
	private long duration;

	public String getDurationString() {

		return CommonFuc.getDurationString(this.duration);
	}
}
