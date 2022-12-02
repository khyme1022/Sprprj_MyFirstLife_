package com.sks.boardserver.boardreply.controller;

import com.sks.boardserver.boardreply.data.BoardReplyRequestDto;
import com.sks.boardserver.boardreply.data.BoardReplyResponseDto;
import com.sks.boardserver.boardreply.service.BoardReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

/**
 댓글 파트 컨트롤러
 */


@RestController
@RequestMapping("/board/{boardNum}/reply")
public class BoardReplyController {
    private final BoardReplyService boardReplyService;
    @Autowired
    public BoardReplyController(BoardReplyService boardReplyService)
    {
        this.boardReplyService = boardReplyService;
    }


    // 댓글 작성 
    // board/{boardNum}/reply/write
    @PostMapping("/write")
    public ResponseEntity<String> writeReply(HttpServletRequest request,@PathVariable("boardNum") int boardNum){
        try{
            boardReplyService.writeBoardReply(request,boardNum);
        }catch(ParseException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("작성이 완료되었습니다.");
    }
    // 댓글 읽기
    // board/{boardNum}/reply/page=2
    @GetMapping
    public ResponseEntity<List<BoardReplyResponseDto>> readReplyList(@PathVariable("boardNum") int boardNum, @RequestParam(value = "page",required = false,defaultValue = "1") int page){
        return ResponseEntity.ok(boardReplyService.readBoardReplyList(boardNum, page-1));
    }
    // 댓글 수정
    // board/{boardNum}/reply/{replyNum}
    @Transactional
    @PutMapping("/{replyNum}")
    public ResponseEntity<String> modifyReply(HttpServletRequest request, @PathVariable("boardNum") int boardNum, @PathVariable("replyNum") int replyNum) throws ParseException {
        try{
            boardReplyService.modifyBoardReply(request,boardNum,replyNum);
        }
        catch (ParseException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("수정 완료");


    }
    // 댓글 삭제
    // board/{boardNum}/reply/{replyNum}
    @Transactional
    @DeleteMapping("/{replyNum}")
    public ResponseEntity<String> deleteReply(@PathVariable("boardNum") int boardNum, @PathVariable("replyNum") int replyNum)
    {
        try{
            boardReplyService.deleteBoardReply(boardNum, replyNum);
        }catch (Exception e){
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("DELETE FAIL");
        }
        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");

    }
}
