package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WordDTO {

	private Integer id;
	private String name;
	private String mean;
	private String type;
	private String pronounce;
	private String sound;
	private String definition;
}
