package webtienganh.service;

import java.util.List;

import webtienganh.dto.WordNoteCategoryDTO;

public interface WordNoteCategoryService {

	List<WordNoteCategoryDTO> getAllCategoryInfos();

	WordNoteCategoryDTO add(String name);

	WordNoteCategoryDTO update(Integer id, String name);

	void delete(Integer id);
	
	void addWord(Integer id, Integer wordId);

}
