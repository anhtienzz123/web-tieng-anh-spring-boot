package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webtienganh.converter.BlogConverter;
import webtienganh.dto.BlogDTO;
import webtienganh.dto.BlogSummaryDTO;
import webtienganh.dto.PaginationWrapper;
import webtienganh.entity.Blog;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.BlogRepository;
import webtienganh.service.BlogService;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private BlogConverter blogConverter;

	@Override
	public PaginationWrapper<List<BlogSummaryDTO>> getListSummaries(String name, String categorySlug, int page,
			int size) {

		if (name == null || categorySlug == null || page < 0 || size <= 0)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Page<Blog> blogPage = blogRepository.findAllByNameContainingAndBlogCategorySlugContainingOrderByCreateDate(name,
				categorySlug, PageRequest.of(page, size));

		var result = new PaginationWrapper<List<BlogSummaryDTO>>();

		result.setPage(page);
		result.setSize(size);
		result.setTotalPages(blogPage.getTotalPages());

		List<BlogSummaryDTO> blogSummaryDTOs = blogPage.toList().stream()
				.map(blogEle -> blogConverter.toBlogSummaryDTO(blogEle)).collect(Collectors.toList());

		result.setData(blogSummaryDTOs);

		return result;
	}

	@Override
	public BlogDTO getOne(String slug) {

		if (slug == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Blog blog = blogRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.BLOG));

		return blogConverter.toBlogDTO(blog);
	}

	@Override
	public BlogDTO save(BlogDTO blogDTO) {

		Blog blogSave = blogRepository.save(blogConverter.toBlog(blogDTO));

		return blogConverter.toBlogDTO(blogSave);
	}
}
