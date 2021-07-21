package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.SubtitleDTO;
import webtienganh.entity.Subtitle;
import webtienganh.entity.Video;

@Component
public class SubtitleConverter {

	public SubtitleDTO toSubtitleDTO(Subtitle subtitle) {

		SubtitleDTO result = new SubtitleDTO();
		result.setId(subtitle.getId());
		result.setStt(subtitle.getStt());
		result.setStart(subtitle.getStart());
		result.setEnd(subtitle.getEnd());
		result.setContent(subtitle.getContent());
		
		return result;
	}
	
	public Subtitle toSubtitle(SubtitleDTO subtitleDTO, Video video) {
		
		Subtitle result = new Subtitle();
		result.setId(subtitleDTO.getId());
		result.setStt(subtitleDTO.getStt());
		result.setContent(subtitleDTO.getContent());
		result.setStart(subtitleDTO.getStart());
		result.setEnd(subtitleDTO.getEnd());
		
		result.setVideo(video);
		
		return result;
		
	}
}
