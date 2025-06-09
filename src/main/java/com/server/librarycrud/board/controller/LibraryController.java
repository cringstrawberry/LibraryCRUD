package com.server.librarycrud.board.controller;

import com.server.librarycrud.board.dto.Request.PostBookRequest;
import com.server.librarycrud.board.dto.response.BookInfoResponse;
import com.server.librarycrud.board.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class LibraryController {
    public final BookService bookService;

    @GetMapping("/{bookName}")
    public BookInfoResponse getBookInfo(@PathVariable String bookName){
        return bookService.getBookInfo(bookName);
    }

    @GetMapping
    public List<BookInfoResponse> getAllBookInfo(){
        return bookService.getAllBookInfo();
    }

    @PostMapping
    public BookInfoResponse postBookInfo(@RequestBody PostBookRequest request){
        return bookService.postBookInfo(request);
    }

    @PutMapping("/{bookName}")
    public BookInfoResponse updateBookInfo(@PathVariable String bookName, @RequestBody PostBookRequest request) {
        return bookService.updateBookInfo(bookName, request);
    }

    @DeleteMapping("/{bookName}")
    public HttpStatus deleteBookInfo(@PathVariable String bookName){
        bookService.deleteBookInfo(bookName);
        return HttpStatus.OK;
    }
}
