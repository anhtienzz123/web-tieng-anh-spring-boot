package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.WordNoteCategoryDTO;
import webtienganh.entity.WordNoteCategory;
import webtienganh.utils.DateProcessor;

@Component
public class WordNoteCategoryConverter {

	public WordNoteCategoryDTO toWordNoteCategoryDTO(WordNoteCategory wordNoteCategory) {

		WordNoteCategoryDTO result = new WordNoteCategoryDTO();
		result.setId(wordNoteCategory.getId());
		result.setName(wordNoteCategory.getName());

		String createDateString = DateProcessor.toDateString(wordNoteCategory.getCreateDate());
		result.setCreateDate(createDateString);

		result.setWordNumber(wordNoteCategory.getWords().size());

		return result;
	}
}
