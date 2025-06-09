package com.server.librarycrud.board.service;

import com.server.librarycrud.board.dto.Request.PostBookRequest;
import com.server.librarycrud.board.dto.response.BookInfoResponse;

import java.util.List;

public interface BookService {
    BookInfoResponse getBookInfo(String bookName);
//    BookInfoResponse getBookInfo(GetBookRequest request,
    BookInfoResponse postBookInfo(PostBookRequest request);

    List<BookInfoResponse> getAllBookInfo();

    BookInfoResponse updateBookInfo(String bookName, PostBookRequest request);
    void deleteBookInfo(String bookName);
}
