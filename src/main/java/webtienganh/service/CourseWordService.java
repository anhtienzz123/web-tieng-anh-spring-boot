package webtienganh.service;

import webtienganh.dto.WordDTO;
import webtienganh.response.PaginationWrapper;

public interface CourseWordService {

	PaginationWrapper<WordDTO> getList(String courseSlug, int page, int size);
}
