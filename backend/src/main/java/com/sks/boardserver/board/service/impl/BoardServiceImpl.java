package com.sks.boardserver.board.service.impl;

import com.sks.boardserver.board.data.BoardDto;
import com.sks.boardserver.board.data.BoardRepository;
import com.sks.boardserver.board.entity.Board;
import com.sks.boardserver.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){this.boardRepository = boardRepository;}

    /** 글 작성 메소드
     * CREATE */
    @Override
    public void insertBoard(HttpServletRequest request) throws ParseException {
        System.out.println("service : " + request.getParameter("no"));
        Board board = new BoardDto(request).toEntity();
        Board savedBoard = boardRepository.save(board);
    }

    /** 글 목록 조회 메소드
     * READ */
    @Override
    public List<BoardDto> selectBoardAll(Long number) {
        List<Board> boardList = boardRepository.findByNo(number);
        List<BoardDto> selectedBoardList = boardList.stream().map(BoardDto::new).collect(Collectors.toList());

        return selectedBoardList;
    }
    /** 글 하나 조회 메소드 */
    @Override
    public BoardDto selectBoard(int number) {
        return null;
    }
    /** 글 수정 조회 메소드 */
    @Override
    public void updateBoard(BoardDto boardDto) {

    }
    /** 글 삭제 메소드 */
    @Override
    public void deleteBoard(Long number) throws Exception {

    }
}
