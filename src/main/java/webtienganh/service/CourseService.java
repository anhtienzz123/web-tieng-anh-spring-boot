package webtienganh.service;

import java.util.List;

import webtienganh.dto.CourseSummaryDTO;
import webtienganh.dto.PaginationWrapper;

public interface CourseService {

	PaginationWrapper<List<CourseSummaryDTO>> getCourseInfos(String name, String topicSlug, int page, int size);
	
	CourseSummaryDTO getBySlug(String slug);

}
