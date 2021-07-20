package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubtitleDTO {

	private Integer id;
	private int stt;
	private long start;
	private long end;
	private String content;
}
