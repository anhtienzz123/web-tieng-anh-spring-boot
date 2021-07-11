package webtienganh.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import webtienganh.dto.WordDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest extends CourseInfoRequest {

	private List<WordDTO> words;
}
