package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.BlogCategoryDTO;
import webtienganh.entity.BlogCategory;

@Component
public class BlogCategoryConverter {

	public BlogCategoryDTO toBlogCategoryDTO(BlogCategory blogCategory) {

		BlogCategoryDTO result = new BlogCategoryDTO();
		result.setId(blogCategory.getId());
		result.setName(blogCategory.getName());
		result.setSlug(blogCategory.getSlug());

		return result;
	}
}
