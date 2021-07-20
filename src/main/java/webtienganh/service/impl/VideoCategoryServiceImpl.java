package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.VideoCategoryConverter;
import webtienganh.dto.VideoCategoryDTO;
import webtienganh.repository.VideoCategoryRepository;
import webtienganh.service.VideoCategoryService;

@Service
@Transactional
public class VideoCategoryServiceImpl implements VideoCategoryService {

	@Autowired
	private VideoCategoryRepository videoCategoryRepository;

	@Autowired
	private VideoCategoryConverter videoCategoryConverter;

	@Override
	public List<VideoCategoryDTO> getList() {

		return videoCategoryRepository.findAll().stream()
				.map(categoryEle -> videoCategoryConverter.toVideoCategoryDTO(categoryEle))
				.collect(Collectors.toList());
	}

}
