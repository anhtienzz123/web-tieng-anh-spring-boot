package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.TopicConverter;
import webtienganh.dto.TopicDTO;
import webtienganh.repository.TopicRepository;
import webtienganh.service.TopicService;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private TopicConverter topicConverter;

	@Override
	public List<TopicDTO> getAll() {

		return topicRepository.findAll().stream().map(tp -> topicConverter.toTopicDTO(tp)).collect(Collectors.toList());
	}
}
