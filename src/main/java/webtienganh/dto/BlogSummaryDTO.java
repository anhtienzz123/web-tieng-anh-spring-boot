package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogSummaryDTO {

	private Integer id;
	private String name;
	private String slug;
	private String image;
	private String description;
	private String createDate;
}
