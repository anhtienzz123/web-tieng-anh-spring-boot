package webtienganh.converter;

import org.springframework.stereotype.Component;

import webtienganh.dto.WordDTO;
import webtienganh.entity.Word;

@Component
public class WordConverter {

	public WordDTO toWordDTO(Word word) {

		WordDTO result = new WordDTO();
		result.setId(word.getId());
		result.setName(word.getName());
		result.setMean(word.getMean());
		result.setType(word.getType());
		result.setPronounce(word.getPronounce());
		result.setSound(word.getSound());
		result.setDefinition(word.getDefinition());
		
		return result;
	}
}
