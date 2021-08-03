package webtienganh.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import webtienganh.dto.BookDTO;
import webtienganh.entity.Book;
import webtienganh.repository.ExamRepository;
import webtienganh.service.BookRepository;

@Component
public class BookConverter {

	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private BookRepository bookRepository;

	public BookDTO toBookDTO(Book book) {

		BookDTO result = new BookDTO();
		result.setId(book.getId());
		result.setName(book.getName());
		result.setImage(book.getImage());
		result.setExams(examRepository.getAllNameSlugOnlysByBookId(book.getId()));

		return result;
	}
	
	public Book toBook(BookDTO bookDTO) {
		
		Book book = new Book();
		
		Integer id = bookDTO.getId();
		
		if(id != 0)
			book = bookRepository.findById(id).get();
		
		book.setId(bookDTO.getId());
		book.setName(bookDTO.getName());
		
		return book;
	}
}
