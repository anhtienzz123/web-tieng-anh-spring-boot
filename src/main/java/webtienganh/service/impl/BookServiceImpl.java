package webtienganh.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtienganh.converter.BookConverter;
import webtienganh.dto.BookDTO;
import webtienganh.service.BookRepository;
import webtienganh.service.BookService;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookConverter bookConverter;

	@Override
	public List<BookDTO> getAll() {

		return bookRepository.findAll().stream().map(book -> bookConverter.toBookDTO(book))
				.collect(Collectors.toList());
	}

}
