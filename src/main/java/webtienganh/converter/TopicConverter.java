package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.TopicDTO;
import webtienganh.entity.Topic;

@Component
public class TopicConverter {

	public TopicDTO toTopicDTO(Topic topic) {
		
		TopicDTO topicDTO = new TopicDTO();
		
		topicDTO.setName(topic.getName());
		topicDTO.setSlug(topic.getSlug());
		
		return topicDTO;
		
	}
}
