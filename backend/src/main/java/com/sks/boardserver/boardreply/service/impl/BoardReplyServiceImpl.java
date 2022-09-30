package com.sks.boardserver.boardreply.service.impl;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.boardreply.data.BoardReplyDto;
import com.sks.boardserver.boardreply.data.BoardReplyRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import com.sks.boardserver.boardreply.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public class BoardReplyServiceImpl implements BoardReplyService {

    private final BoardReplyRepository boardReplyRepository;
    @Autowired
    public BoardReplyServiceImpl(BoardReplyRepository boardReplyRepository)
    {
        this.boardReplyRepository = boardReplyRepository;
    }

    @Override
    public void insertBoardReply(HttpServletRequest request) throws ParseException {
        BoardReply boardReply =new BoardReplyDto(request).toEntity();
        boardReplyRepository.save(boardReply);
    }
    // 아마 정렬 메소드가 필요할 듯
    @Override
    public List<BoardReplyDto> selectBoardReplyList(int PageNum) {
        return null;
    }

    @Override
    public void updateBoardReply(HttpServletRequest request, int replyNum, int boardNum) throws ParseException {
        BoardReply boardReply =new BoardReplyDto(request).toEntity();
        boardReplyRepository.updateByNo(boardReply.getContent(),replyNum,boardNum);
    }

    @Override
    public void deleteBoardReply(int replyNum,int boardNum) {
        boardReplyRepository.deleteByNo(replyNum,boardNum);
    }
}
