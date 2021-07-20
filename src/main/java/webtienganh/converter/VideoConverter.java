package webtienganh.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webtienganh.dto.SubtitleDTO;
import webtienganh.dto.VideoDTO;
import webtienganh.dto.VideoSummaryDTO;
import webtienganh.entity.Video;

@Component
public class VideoConverter {

	@Autowired
	private SubtitleConverter subtitleConverter;

	public VideoSummaryDTO toVideoSummaryDTO(Video video) {

		VideoSummaryDTO result = new VideoSummaryDTO();
		result.setId(video.getId());
		result.setName(video.getName());
		result.setSlug(video.getSlug());
		result.setImage(video.getImage());
		result.setDuration(video.getDuration());
		return result;
	}

	public VideoDTO toVideoDTO(Video video) {

		VideoDTO result = new VideoDTO();
		result.setId(video.getId());
		result.setName(video.getName());
		result.setSlug(video.getSlug());
		result.setImage(video.getImage());
		result.setDuration(video.getDuration());
		result.setUrl(video.getUrl());

		List<SubtitleDTO> subtitleDTOs = video.getSubtitles().stream()
				.map(subEle -> subtitleConverter.toSubtitleDTO(subEle)).collect(Collectors.toList());
		result.setSubtitles(subtitleDTOs);

		return result;
	}
}
