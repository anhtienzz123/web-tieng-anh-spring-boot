package webtienganh.service;

import webtienganh.request.CourseInfoRequest;
import webtienganh.request.CourseRequest;
import webtienganh.request.PaginationWrapper;

public interface CourseService {

	PaginationWrapper<CourseInfoRequest> getCourseInfos(String name, String topicSlug, int page, int size);
	
	CourseRequest getBySlug(String slug);
}
