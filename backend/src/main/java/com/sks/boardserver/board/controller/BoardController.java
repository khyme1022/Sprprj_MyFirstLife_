package com.sks.boardserver.board.controller;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
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

    /**
     * request 값을 받아와 DB에 삽입
     * @param request
     * @return String
     */
    @PostMapping("/write")
    public ResponseEntity<String> writeBoard(HttpServletRequest request) {
        try {
            boardService.insertBoard(request);
        }catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("작성 완료");
    }

    /**
     *
     * @param page
     * @return List<BoardDto>
     *     파라미터가 없을 시 첫 페이지 (0)을 보여주고
     *     /board?page=2
     *     쿼리스트링으로 파라미터 받아올 시 해당하는 페이지를 보여줌
     */
    @GetMapping
    public ResponseEntity<List<BoardDto>> readBoardList(@RequestParam(value = "page",required = false, defaultValue = "0") int page){
        System.out.println("결과 : " + boardService.selectBoardList(page));
        return ResponseEntity.ok(boardService.selectBoardList(page));
    }

    /**
     * /board/2로 글번호 요청 시 해당하는 글을 보여줌
     * @param boardNum
     * @return BoardDto
     */
    @GetMapping("/{boardNum}")
    public ResponseEntity<BoardDto> readBoard(@PathVariable("boardNum") int boardNum){
        System.out.println(boardNum);
        return ResponseEntity.ok(boardService.selectBoard(boardNum));
    }
    /**
     * /board/2로 PUT 요청 시 글번호와 request 요청을 받아 글을 수정함
     * @param boardNum
     * @return String
     */
    @Transactional
    @PutMapping("/{boardNum}")
    public ResponseEntity<String> modifyBoard(HttpServletRequest request, @PathVariable("boardNum") int boardNum){
        try {
            boardService.updateBoard(request,boardNum);
        }catch (ParseException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred exception while parsing date");
        }
        return ResponseEntity.status(HttpStatus.OK).body("수정 완료");

    }
    /**
     * /board/2로 DELETE 요청 시 해당 글 번호의 isDelete 속성을 true로 변경함
     * @param boardNum
     * @return String
     */
    @Transactional
    @DeleteMapping("/{boardNum}")
    public ResponseEntity<String> deleteBoard(@PathVariable("boardNum") int boardNum)
    {
        try {
            boardService.deleteBoard(boardNum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");

    }


}
