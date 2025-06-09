package com.server.librarycrud.board.dto.response;

import com.server.librarycrud.board.domain.entity.Book;

public record BookInfoResponse(
        String bookName,
        String content,
        String writer
){
    public static BookInfoResponse of(Book book) {
    return new BookInfoResponse(book.getBookName(), book.getContent(), book.getWriter());
    }
}
