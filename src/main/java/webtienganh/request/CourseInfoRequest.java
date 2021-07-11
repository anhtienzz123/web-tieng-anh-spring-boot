package webtienganh.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoRequest {

	private String name;
	private String slug;
	private String image;
	private String description;
	private int wordNumber;
	private int personNumber;
	
}
