package webtienganh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import webtienganh.dto.WordNoteCategoryDTO;
import webtienganh.request.WordNoteRequest;
import webtienganh.service.WordNoteCategoryService;
import webtienganh.utils.RestConstant;

@RestController
@RequestMapping("/user/word-note-categories")
@CrossOrigin
public class WordNoteCateogoryController {

	@Autowired
	private WordNoteCategoryService wordNoteCategoryService;

	@GetMapping("")
	public List<WordNoteCategoryDTO> getAllInfos() {

		return wordNoteCategoryService.getAllCategoryInfos();
	}

	@PostMapping(value = "", consumes = RestConstant.CONSUMES_JSON)
	@ResponseStatus(code = HttpStatus.CREATED)
	public WordNoteCategoryDTO createWordNoteCategory(@Valid @RequestBody WordNoteCategoryDTO wordNoteCategory) {

		return wordNoteCategoryService.add(wordNoteCategory.getName());
	}

	@PutMapping(value = "/{id}", consumes = RestConstant.CONSUMES_JSON)
	public WordNoteCategoryDTO updateWordNoteCategory(@PathVariable("id") Integer id,
			@Valid @RequestBody WordNoteCategoryDTO wordNoteCategory) {

		return wordNoteCategoryService.update(id, wordNoteCategory.getName());
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteWordNoteCategory(@PathVariable("id") Integer id) {

		wordNoteCategoryService.delete(id);
	}

	@PostMapping(value = "/add-word", consumes = RestConstant.CONSUMES_JSON)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addWordNote(@Valid @RequestBody WordNoteRequest wordNoteRequest) {

		Integer wordNoteCategoryId = wordNoteRequest.getWordNoteCategoryId();
		Integer wordId = wordNoteRequest.getWordId();

		wordNoteCategoryService.addWord(wordNoteCategoryId, wordId);
		;
	}

}
