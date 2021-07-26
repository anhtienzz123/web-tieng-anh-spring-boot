package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.BlogDTO;
import webtienganh.dto.BlogSummaryDTO;
import webtienganh.entity.Blog;
import webtienganh.entity.BlogCategory;
import webtienganh.utils.DateProcessor;

@Component
public class BlogConverter {

	public BlogSummaryDTO toBlogSummaryDTO(Blog blog) {

		var result = new BlogSummaryDTO();
		result.setId(blog.getId());
		result.setName(blog.getName());
		result.setSlug(blog.getSlug());
		result.setImage(blog.getImage());
		result.setDescription(blog.getDescription());
		result.setCreateDate(DateProcessor.toDateString(blog.getCreateDate()));

		return result;
	}

	public BlogDTO toBlogDTO(Blog blog) {

		var result = new BlogDTO();
		result.setId(blog.getId());
		result.setName(blog.getName());
		result.setSlug(blog.getSlug());
		result.setImage(blog.getImage());
		result.setDescription(blog.getDescription());
		result.setCreateDate(DateProcessor.toDateString(blog.getCreateDate()));
		result.setContent(blog.getContent());

		BlogCategory blogCategory = blog.getBlogCategory();
		result.setCategoryId(blogCategory.getId());
		result.setCategoryName(blogCategory.getName());

		return result;
	}
}
