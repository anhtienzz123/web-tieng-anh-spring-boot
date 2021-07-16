package webtienganh.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webtienganh.entity.NameSlugOnly;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private String name;
	private String image;

	private List<NameSlugOnly> exams;

}
