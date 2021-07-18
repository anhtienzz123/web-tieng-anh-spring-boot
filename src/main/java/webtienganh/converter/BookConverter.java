package webtienganh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webtienganh.dto.BookDTO;
import webtienganh.entity.Book;
import webtienganh.repository.ExamRepository;

@Component
public class BookConverter {

	@Autowired
	private ExamRepository examRepository;

	public BookDTO toBookDTO(Book book) {

		BookDTO result = new BookDTO();
		result.setName(book.getName());
		result.setImage(book.getImage());
		result.setExams(examRepository.getAllNameSlugOnlysByBookId(book.getId()));

		return result;
	}
}
