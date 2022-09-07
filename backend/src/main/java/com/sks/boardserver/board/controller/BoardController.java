package com.sks.boardserver.board.controller;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @Autowired
    public BoardController(BoardService boardService)
    {
        this.boardService = boardService;
    }
    
    //Page 번호를 매개변수로 받아 해당 페이지에 해당하는 게시글 목록 보여줌
    @GetMapping()
    public ResponseEntity<List<BoardDto>> getBoardAll(Long number){
        List<BoardDto> boardDto = boardService.selectBoardAll(number);
        return ResponseEntity.status(HttpStatus.OK).body(boardDto);
    }
    //글번호를 파라미터로 받아와 보여주는 메소드
    @GetMapping("/{boardNo}")
    public ResponseEntity<BoardDto> getBoard(Long number){
        return null;
    }

    //글쓰기
    @PostMapping
    public ResponseEntity<String> writeBoard(HttpServletRequest request) {
        try {
            boardService.insertBoard(request);
        }catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }

}
