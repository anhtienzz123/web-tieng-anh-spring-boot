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
		result.setExample(word.getExample());
		result.setImage(word.getImage());
		
		return result;
	}
	
	public Word toWord(WordDTO wordDTO) {

		Word result = new Word();
		result.setName(wordDTO.getName());
		result.setMean(wordDTO.getMean());
		result.setType(wordDTO.getType());
		result.setPronounce(wordDTO.getPronounce());
		result.setSound(wordDTO.getSound());
		result.setDefinition(wordDTO.getDefinition());
		result.setExample(wordDTO.getExample());
		result.setImage(wordDTO.getImage());
		
		return result;
	}
}
