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

    @GetMapping
    public ResponseEntity<List<BoardDto>> getBoard(Long number){
        List<BoardDto> boardDto = boardService.selectBoard(number);
        return ResponseEntity.status(HttpStatus.OK).body(boardDto);
    }

    @PostMapping
    public ResponseEntity<String> writeBoard(HttpServletRequest request) {
        try {
            System.out.println(request.getParameter("no"));
            boardService.insertBoard(request);
        }catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("success");
    }
}
