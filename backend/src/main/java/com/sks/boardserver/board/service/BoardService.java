package com.sks.boardserver.board.service;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.board.entity.Board;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface BoardService {
    /** 글 작성 메소드 */
    void insertBoard(HttpServletRequest request) throws ParseException;
    /** 글 목록 조회 */
    List<BoardDto> selectBoardAll(Long number);
    /** 글 하나 조회 */
    BoardDto selectBoard(int number);
    /** 글 수정 메소드 */
    void updateBoard(BoardDto boardDto);
    /** 글 삭제 메소드*/
    void deleteBoard(Long number) throws Exception;
}
