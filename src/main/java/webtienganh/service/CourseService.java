package webtienganh.service;

import webtienganh.dto.CourseSummaryDTO;
import webtienganh.dto.PaginationWrapper;

public interface CourseService {

	PaginationWrapper<CourseSummaryDTO> getCourseInfos(String name, String topicSlug, int page, int size);
	
	CourseSummaryDTO getBySlug(String slug);

}
