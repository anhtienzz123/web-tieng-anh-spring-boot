package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webtienganh.converter.CourseConverter;
import webtienganh.dto.CourseSummaryDTO;
import webtienganh.dto.PaginationWrapper;
import webtienganh.entity.Course;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.CourseRepository;
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
	public PaginationWrapper<List<CourseSummaryDTO>> getCourseInfos(String name, String topicSlug, int page, int size) {

		if (name == null || topicSlug == null || page < 0 || size < 0)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Page<Course> coursePage = courseRepository.findAllByNameContainingAndTopicSlugContaining(name, topicSlug,
				PageRequest.of(page, size));
		
		PaginationWrapper<List<CourseSummaryDTO>> result = new PaginationWrapper<>();
		result.setPage(page);
		result.setSize(size);
		result.setTotalPages(coursePage.getTotalPages());

		List<CourseSummaryDTO> data = coursePage.toList().stream().map(c -> courseConverter.toCourseInfoRequest(c))
				.collect(Collectors.toList());
		result.setData(data);

		return result;
	}

	@Override
	public CourseSummaryDTO getBySlug(String slug) {

		if (slug == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Course course = courseRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.COURSE));

		return courseConverter.toCourseInfoRequest(course);

	}
}
