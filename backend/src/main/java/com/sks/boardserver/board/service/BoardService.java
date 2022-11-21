package com.sks.boardserver.board.service;

import com.sks.boardserver.board.data.BoardRequestDto;
import com.sks.boardserver.board.data.BoardResponseDto;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface BoardService {
    /** 글 작성 메소드 */
    public void insertBoard(HttpServletRequest request) throws ParseException;
    /** 글 목록 조회 */
    public List<BoardResponseDto> selectBoardList(int pageNum);
    public BoardResponseDto selectBoard(int boardNum);
    /** 글 수정 메소드 */
    public void updateBoard(HttpServletRequest request,int boardNum) throws ParseException;
    /** 글 삭제 메소드*/
    public void deleteBoard(int number) throws Exception;
}
