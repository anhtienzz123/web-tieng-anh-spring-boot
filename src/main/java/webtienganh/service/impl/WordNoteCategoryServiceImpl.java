package webtienganh.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.WordNoteCategoryConverter;
import webtienganh.dto.WordNoteCategoryDTO;
import webtienganh.entity.Word;
import webtienganh.entity.WordNote;
import webtienganh.entity.WordNoteCategory;
import webtienganh.entity.WordNote_PK;
import webtienganh.exception.MyExceptionHelper;
import webtienganh.repository.WordNoteCategoryRepository;
import webtienganh.repository.WordNoteRepository;
import webtienganh.repository.WordRepository;
import webtienganh.service.WordNoteCategoryService;
import webtienganh.utils.AuthenInfo;
import webtienganh.utils.MyConstant;

@Service
@Transactional
public class WordNoteCategoryServiceImpl implements WordNoteCategoryService {

	@Autowired
	private WordNoteCategoryRepository wordNoteCategoryRepository;
	@Autowired
	private WordNoteCategoryConverter wordNoteCategoryConverter;
	@Autowired
	private WordNoteRepository wordNoteRepository;
	@Autowired
	private WordRepository wordRepository;
	@Autowired
	private AuthenInfo authenInfo;

	@Override
	public List<WordNoteCategoryDTO> getAllCategoryInfos() {

		AuthenInfo.checkLogin();

		String username = AuthenInfo.getUsername();

		return wordNoteCategoryRepository.findAllByUserUsername(username).stream()
				.map(wnc -> wordNoteCategoryConverter.toWordNoteCategoryDTO(wnc)).collect(Collectors.toList());

	}

	@Override
	public WordNoteCategoryDTO add(String name) {

		AuthenInfo.checkLogin();

		if (name == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		WordNoteCategory wordNoteCategory = new WordNoteCategory();
		wordNoteCategory.setName(name);
		wordNoteCategory.setCreateDate(LocalDate.now());
		wordNoteCategory.setUser(authenInfo.getUser());
		
		return wordNoteCategoryConverter.toWordNoteCategoryDTO(wordNoteCategoryRepository.save(wordNoteCategory));
	}

	@Override
	public WordNoteCategoryDTO update(Integer id, String name) {

		AuthenInfo.checkLogin();

		if (id == null || name == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		checkAuthenticationForCategory(id);

		WordNoteCategory result = wordNoteCategoryRepository.findById(id)
				.orElseThrow(() -> MyExceptionHelper.throwResourceNotFoundException(MyConstant.GHI_CHU));
		result.setName(name);

		return wordNoteCategoryConverter.toWordNoteCategoryDTO(wordNoteCategoryRepository.save(result));
	}

	@Override
	public void delete(Integer id) {

		AuthenInfo.checkLogin();

		if (id == null)
			throw MyExceptionHelper.throwIllegalArgumentException();

		checkAuthenticationForCategory(id);

		wordNoteCategoryRepository.deleteById(id);

	}

	@Override
	public void addWord(Integer id, Integer wordId) {
		
		AuthenInfo.checkLogin();
		
		if (id == null || wordId == null )
			throw MyExceptionHelper.throwIllegalArgumentException();

		// check có quyền với category
		checkAuthenticationForCategory(id);
		
		// check có từ vựng đó không
		if(!wordRepository.existsById(wordId))
			throw MyExceptionHelper.throwResourceNotFoundException(MyConstant.TU_VUNG);
		
		// check từ này đã lưu chưa
		WordNote_PK wordNote_PK = new WordNote_PK(id, wordId); 
		// nếu tồn tài rồi thì không lưu nữa
		if(wordNoteRepository.existsById(wordNote_PK) )
			return;
		
		WordNote wordNote = new WordNote(new WordNoteCategory(id), new Word(wordId));
		wordNoteRepository.save(wordNote);
		
	}

	private void checkAuthenticationForCategory(Integer id) {

		if (!wordNoteCategoryRepository.existsByUserUsernameAndId(AuthenInfo.getUsername(), id))
			throw MyExceptionHelper.throwAuthenticationException();
	}
}
