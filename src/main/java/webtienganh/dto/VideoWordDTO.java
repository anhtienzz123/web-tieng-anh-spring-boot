package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VideoWordDTO {

	private Integer id;
	private String name;
	private String origin;
	private String sound;
	private int frequency; 
}
