package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.SubtitleDTO;
import webtienganh.entity.Subtitle;

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
}
