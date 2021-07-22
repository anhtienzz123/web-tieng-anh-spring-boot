package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import webtienganh.converter.VideoConverter;
import webtienganh.dto.PaginationWrapper;
import webtienganh.dto.VideoDTO;
import webtienganh.dto.VideoSummaryDTO;
import webtienganh.entity.Video;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.VideoRepository;
import webtienganh.service.VideoService;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private VideoConverter videoConverter;

	@Override
	public PaginationWrapper<List<VideoSummaryDTO>> getListSummaries(String categorySlug, long timeFrom, long timeTo,
			int level, int page, int size) {

		if (categorySlug == null || timeFrom < 0 || timeTo < 0 || level < 0 || level > 7
				|| (timeTo > 0 && timeFrom > timeTo) || page < 0 || size <= 0)
			throw MyExceptionHelper.throwIllegalArgumentException();

		PaginationWrapper<List<VideoSummaryDTO>> result = new PaginationWrapper<>();

		result.setPage(page);
		result.setSize(size);

		long timeToTempt = timeTo;

		if (timeTo == 0)
			timeToTempt = Long.MAX_VALUE;

		Page<Video> videosPage;

		if (level == 0) {
			
			videosPage = videoRepository.findAllByCategorySlugAndDurationBetween(categorySlug, timeFrom, timeToTempt,
					PageRequest.of(page, size));
		} else {

			videosPage = videoRepository.findAllByCategorySlugAndDurationBetweenAndLevel(categorySlug, timeFrom,
					timeToTempt, level, PageRequest.of(page, size));
		}

		List<VideoSummaryDTO> videoSummaryDTOs = videosPage.toList().stream()
				.map(video -> videoConverter.toVideoSummaryDTO(video)).collect(Collectors.toList());
		result.setData(videoSummaryDTOs);

		result.setTotalPages(videosPage.getTotalPages());

		return result;
	}

	@Override
	public VideoDTO getOne(String slug) {

		if (slug == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		Video video = videoRepository.findBySlug(slug)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.VIDEO));

		return videoConverter.toVideoDTO(video);
	}

}
