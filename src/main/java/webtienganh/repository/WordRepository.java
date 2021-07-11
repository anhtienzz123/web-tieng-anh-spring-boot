package webtienganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webtienganh.entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer> {

	
}
