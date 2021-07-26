package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.BlogCategoryConverter;
import webtienganh.dto.BlogCategoryDTO;
import webtienganh.repository.BlogCategoryRepository;
import webtienganh.service.BlogCategoryService;

@Service
@Transactional
public class BlogCategoryServiceImpl implements BlogCategoryService {

	@Autowired
	private BlogCategoryRepository blogCategoryRepository;

	@Autowired
	private BlogCategoryConverter blogCategoryConverter;

	@Override
	public List<BlogCategoryDTO> getList() {

		return blogCategoryRepository.findAll().stream()
				.map(blogCategoryEle -> blogCategoryConverter.toBlogCategoryDTO(blogCategoryEle))
				.collect(Collectors.toList());
	}

}
