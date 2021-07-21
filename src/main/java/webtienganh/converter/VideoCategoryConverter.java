package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.VideoCategoryDTO;
import webtienganh.entity.VideoCategory;

@Component
public class VideoCategoryConverter {

	public VideoCategoryDTO toVideoCategoryDTO(VideoCategory videoCategory) {

		VideoCategoryDTO result = new VideoCategoryDTO();
		result.setId(videoCategory.getId());
		result.setName(videoCategory.getName());
		result.setSlug(videoCategory.getSlug());

		return result;
	}
}
