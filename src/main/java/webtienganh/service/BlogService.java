package webtienganh.service;

import java.util.List;

import webtienganh.dto.BlogDTO;
import webtienganh.dto.BlogSummaryDTO;
import webtienganh.dto.PaginationWrapper;

public interface BlogService {

	PaginationWrapper<List<BlogSummaryDTO>> getListSummaries(String name, String categorySlug, int page, int size);
	
	BlogDTO getOne(String slug);
	
	BlogDTO save(BlogDTO blogDTO);
}
