package webtienganh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import webtienganh.entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {

	boolean existsByName(String name);
	Optional<Word> findByName(String name);
}
