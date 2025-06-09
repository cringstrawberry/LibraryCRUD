package com.server.librarycrud.board.repository;

import com.server.librarycrud.board.domain.entity.Book;
import com.server.librarycrud.board.dto.response.BookInfoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{
//    List<BookInfoResponse> findAllByBookName(String bookName);
//    List<Object> findByBookName(String bookName);
}
