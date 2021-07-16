package webtienganh.service;

import webtienganh.dto.PaginationWrapper;
import webtienganh.dto.WordDTO;

public interface CourseWordService {

	PaginationWrapper<WordDTO> getList(String courseSlug, int page, int size);
}
