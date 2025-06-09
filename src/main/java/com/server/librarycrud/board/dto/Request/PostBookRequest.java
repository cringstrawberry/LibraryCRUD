package com.server.librarycrud.board.dto.Request;

public record PostBookRequest(
        String bookName,
        String content,
        String writer
){
}
