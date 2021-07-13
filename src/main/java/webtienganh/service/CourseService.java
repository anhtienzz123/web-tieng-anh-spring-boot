package webtienganh.service;

import webtienganh.response.CourseInfoResponse;
import webtienganh.response.PaginationWrapper;

public interface CourseService {

	PaginationWrapper<CourseInfoResponse> getCourseInfos(String name, String topicSlug, int page, int size);
	
	CourseInfoResponse getBySlug(String slug);

}
