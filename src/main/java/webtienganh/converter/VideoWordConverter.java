package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.VideoWordDTO;
import webtienganh.entity.VideoWord;

@Component
public class VideoWordConverter {

	public VideoWordDTO toVideoWordDTO(VideoWord videoWord) {

		VideoWordDTO result = new VideoWordDTO();

		result.setId(videoWord.getId());
		result.setName(videoWord.getName());
		result.setOrigin(videoWord.getOrigin());
		result.setSound(videoWord.getSound());
		result.setFrequency(videoWord.getFrequency());

		return result;
	}
}
