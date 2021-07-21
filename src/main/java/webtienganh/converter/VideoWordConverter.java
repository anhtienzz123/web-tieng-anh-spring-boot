package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.VideoWordDTO;
import webtienganh.entity.VideoWord;
import webtienganh.entity.VideoWordTempt;

@Component
public class VideoWordConverter {

	public VideoWordDTO toVideoWordDTO(VideoWordTempt VideoWordTempt) {

		VideoWordDTO result = new VideoWordDTO();

		VideoWord videoWord = VideoWordTempt.getVideoWord();
		result.setId(videoWord.getId());
		result.setName(videoWord.getName());
		result.setOrigin(videoWord.getOrigin());
		result.setSound(videoWord.getSound());
		result.setFrequency(VideoWordTempt.getFrequency());

		return result;
	}
}
