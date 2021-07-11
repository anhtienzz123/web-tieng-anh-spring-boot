package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webtienganh.converter.CourseConverter;
import webtienganh.entity.Course;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.CourseRepository;
import webtienganh.request.CourseInfoRequest;
import webtienganh.request.CourseRequest;
import webtienganh.request.PaginationWrapper;
import webtienganh.service.CourseService;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private CourseConverter courseConverter;

	@Override
	public PaginationWrapper<CourseInfoRequest> getCourseInfos(String name, String topicSlug, int page, int size) {

		if (name == null || topicSlug == null || page < 0 || size < 0)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Page<Course> coursePage = courseRepository.findAllByNameContainingAndTopicSlugContaining(name, topicSlug,
				PageRequest.of(page, size));
		
		PaginationWrapper<CourseInfoRequest> result = new PaginationWrapper<>();
		result.setPage(page);
		result.setSize(size);
		result.setPageMax(coursePage.getTotalPages());

		List<CourseInfoRequest> data = coursePage.toList().stream().map(c -> courseConverter.toCourseInfoRequest(c))
				.collect(Collectors.toList());
		result.setData(data);

		return result;
	}

	@Override
	public CourseRequest getBySlug(String slug) {

		if (slug == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Course course = courseRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.KHOA_HOC));

		return courseConverter.toCourseRequest(course);

	}
}
