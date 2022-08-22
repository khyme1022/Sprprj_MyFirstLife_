package com.sks.boardserver.board.service;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.board.entity.Board;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface BoardService {
    void insertBoard(HttpServletRequest request) throws ParseException;

    List<BoardDto> selectBoard(Long number);
    void updateBoard(BoardDto boardDto);
    void deleteBoard(Long number) throws Exception;
}
