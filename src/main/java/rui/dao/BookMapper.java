package rui.dao;

import org.apache.ibatis.annotations.Mapper;
import rui.model.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    int addBook(Book book);
    List<Book> getAllBooks();
}
