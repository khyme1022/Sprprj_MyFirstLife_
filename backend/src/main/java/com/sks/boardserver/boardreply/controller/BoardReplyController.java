package com.sks.boardserver.boardreply.controller;

import com.sks.boardserver.board.service.BoardService;
import com.sks.boardserver.boardreply.data.BoardReplyDto;
import com.sks.boardserver.boardreply.entity.BoardReply;
import com.sks.boardserver.boardreply.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;
@RestController
@RequestMapping("/reply")
public class BoardReplyController {
    private final BoardReplyService boardReplyService;
    @Autowired
    public BoardReplyController(BoardReplyService boardReplyService)
    {
        this.boardReplyService = boardReplyService;
    }
    /**
     댓글 파트 API
     */
    // 댓글 작성
    @PostMapping
    public ResponseEntity<String> writeReply(HttpServletRequest request){
        return null;
    }
    // 댓글 불러오기
    @GetMapping
    public ResponseEntity<List<BoardReplyDto>> readReplyList(@RequestParam(value = "page",required = false, defaultValue = "0") int page){
        return null;
    }
    // 댓글 수정
    @Transactional
    @PutMapping
    public ResponseEntity<String> modifyReply(HttpServletRequest request, @PathVariable("boardNum") int boardNum){
        return null;

    }
    // 댓글 삭제
    @Transactional
    @DeleteMapping
    public ResponseEntity<String> deleteReply(@PathVariable("boardNum") int boardNum)
    {
        return null;

    }
}
