package com.server.librarycrud.board.service.impl;

import com.server.librarycrud.board.domain.entity.Book;
import com.server.librarycrud.board.dto.Request.PostBookRequest;
import com.server.librarycrud.board.dto.response.BookInfoResponse;
import com.server.librarycrud.board.repository.BookRepository;
import com.server.librarycrud.board.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;


    @Override
    public BookInfoResponse getBookInfo(String bookName) {
        Book book = bookRepository.findById(bookName)
                .orElseThrow(()-> new RuntimeException("not book"));
        return BookInfoResponse.of(book);
    }

    @Override
    public BookInfoResponse postBookInfo(PostBookRequest request) {
        if (request.bookName() == null || request.bookName().isBlank()) {
            throw new IllegalArgumentException();
        }
       Book book = Book.builder()
               .bookName(request.bookName())
               .content(request.content())
               .writer(request.writer())
               .build();

       return BookInfoResponse.of(bookRepository.save(book));
    }

    @Override
    public List<BookInfoResponse> getAllBookInfo() {
        try {
            List<Book> books = bookRepository.findAll();

            List<BookInfoResponse> bookInfoResponseList = new ArrayList<>();

            for (Book book : books) {
                bookInfoResponseList.add(BookInfoResponse.of(book));
            }
            return bookInfoResponseList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BookInfoResponse updateBookInfo(String bookName, PostBookRequest request) {
        if (bookName == null) {
            throw new RuntimeException();
        }
        Book book = bookRepository.findById(bookName).get();
        book.setContent(request.content());
        book.setWriter(request.writer());
        return BookInfoResponse.of(bookRepository.save(book));
    }

    @Override
    public void deleteBookInfo(String bookName) {
        bookRepository.deleteById(bookName);
    }
}


