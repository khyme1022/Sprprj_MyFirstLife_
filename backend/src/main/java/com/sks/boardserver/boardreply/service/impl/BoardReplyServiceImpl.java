package com.sks.boardserver.boardreply.service.impl;

import com.sks.boardserver.boardreply.data.BoardReplyRepository;
import com.sks.boardserver.boardreply.data.BoardReplyRequestDto;
import com.sks.boardserver.boardreply.data.BoardReplyResponseDto;
import com.sks.boardserver.boardreply.entity.BoardReply;
import com.sks.boardserver.boardreply.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardReplyServiceImpl implements BoardReplyService {

    private final BoardReplyRepository boardReplyRepository;
    @Autowired
    public BoardReplyServiceImpl(BoardReplyRepository boardReplyRepository)
    {
        this.boardReplyRepository = boardReplyRepository;
    }
    // 댓글 저장 메소드
    // HttpServlerReuqest 객체에 담긴 정보를 BoardReply 엔티티 객체로 만든 후 저장하는 메소드
    @Override
    public void writeBoardReply(HttpServletRequest request, int boardNum) throws ParseException {
        BoardReply boardReply = new BoardReplyRequestDto(request,boardNum).toEntity();
        boardReply.setBoardNo(boardNum);
        boardReplyRepository.save(boardReply);
    }
    // 댓글 읽기
    // 해당 boardNum의 게시글의 댓글을 읽어 List로 반환하는
    @Override
    public List<BoardReplyResponseDto> readBoardReplyList(int boardNum, int pageNum) {
        Page<BoardReply> boardReplyList = boardReplyRepository.findByBoardNoAndIsDeleteOrderByReplyNoDesc(boardNum,false, PageRequest.of(pageNum,10));

        return boardReplyList.stream().map(BoardReplyResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public void modifyBoardReply(HttpServletRequest request, int boardNum, int replyNum) throws ParseException {
        BoardReply updateBoardReply = new BoardReplyRequestDto(request,boardNum).toEntity();
        boardReplyRepository.updateByReplyNo(replyNum, updateBoardReply.getContent());
    }

    @Override
    public void deleteBoardReply(int boardNum, int replyNum) {
        boardReplyRepository.deleteByReplyNo(replyNum);
    }


}
