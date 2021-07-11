package webtienganh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import webtienganh.entity.CourseWord;
import webtienganh.entity.CourseWord_PK;

public interface CourseWordRepository extends JpaRepository<CourseWord, CourseWord_PK>{

}
