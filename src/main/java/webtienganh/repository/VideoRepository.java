package webtienganh.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import webtienganh.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {

	Page<Video> findAllByCategorySlugAndDurationBetween(String categorySlug, long timeForm, long timeTo,
			Pageable pageable);
	
	Optional<Video> findBySlug(String slug);
	
	boolean existsByName(String name);
}
