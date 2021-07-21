package webtienganh.service;

import java.util.List;

import webtienganh.dto.PaginationWrapper;
import webtienganh.dto.VideoDTO;
import webtienganh.dto.VideoSummaryDTO;

public interface VideoService {

	PaginationWrapper<List<VideoSummaryDTO>> getListSummaries(String categorySlug, long timeFrom, long timeTo, int page, int size);
	VideoDTO getOne(String slug);
}
