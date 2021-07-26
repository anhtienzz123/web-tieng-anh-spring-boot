package webtienganh.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO extends BlogSummaryDTO {

	private String content;
	private Integer categoryId;
	private String categoryName;
}
