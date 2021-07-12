package webtienganh.service;

import webtienganh.response.CourseInfoResponse;
import webtienganh.response.CourseResponse;
import webtienganh.response.PaginationWrapper;

public interface CourseService {

	PaginationWrapper<CourseInfoResponse> getCourseInfos(String name, String topicSlug, int page, int size);
	
	CourseResponse getBySlug(String slug);
}
