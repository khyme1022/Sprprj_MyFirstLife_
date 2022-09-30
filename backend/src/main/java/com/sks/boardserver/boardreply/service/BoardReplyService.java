package com.sks.boardserver.boardreply.service;

import com.sks.boardserver.boardreply.data.BoardReplyDto;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface BoardReplyService {
    public void insertBoardReply(HttpServletRequest request) throws ParseException;
    public List<BoardReplyDto> selectBoardReplyList(int PageNum);
    public void updateBoardReply(HttpServletRequest request, int replyNum, int boardNum) throws ParseException;
    public void deleteBoardReply(int replyNum, int boardNum);


}
