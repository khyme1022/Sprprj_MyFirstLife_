package com.sks.boardserver.boardreply.service;

import com.sks.boardserver.boardreply.data.BoardReplyResponseDto;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface BoardReplyService {

    // 댓글 저장 메소드
    // HttpServlerReuqest 객체에 담긴 정보를 BoardReply 엔티티 객체로 만든 후 저장하는 메소드
    public void writeBoardReply(HttpServletRequest request, int boardNum) throws ParseException;

    public List<BoardReplyResponseDto> readBoardReplyList(int boardNum, int pageNum);
    public void modifyBoardReply(HttpServletRequest request, int boardNum, int replyNum) throws ParseException;
    public void deleteBoardReply(int boardNum, int replyNum);
}
