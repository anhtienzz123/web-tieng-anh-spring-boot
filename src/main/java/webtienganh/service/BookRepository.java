package webtienganh.service;

import org.springframework.data.jpa.repository.JpaRepository;

import webtienganh.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
