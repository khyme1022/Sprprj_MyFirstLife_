package com.sks.boardserver.board.service.impl;

import com.sks.boardserver.board.data.BoardRequestDto;
import com.sks.boardserver.board.data.BoardRepository;
import com.sks.boardserver.board.data.BoardResponseDto;
import com.sks.boardserver.board.entity.Board;
import com.sks.boardserver.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    /** 글 작성 메소드
     * HttpServletRequest 객체를 받아와서 BoardDto 객체 생성 후 toEntity() 메소드로 엔티티 객체로 바꿔준 후 저장
     * CREATE */
    @Override
    public void insertBoard(HttpServletRequest request) throws ParseException {
        Board board = new BoardRequestDto(request).toEntity();
        boardRepository.save(board);
    }

    /** 글 목록 조회 메소드
     * 페이지 파라미터를 받아옴 없을 시 첫 페이지
     * 정렬 순서 바꿔야함
     * READ */
    @Override
    public List<BoardResponseDto> selectBoardList(int pageNum) {
        Page<Board> boardList = boardRepository.findByisDeleteOrderByNoDesc(false,PageRequest.of(pageNum,2));

        return boardList.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
    /** 
     * 글 하나 조회 메소드
     */
    @Override
    public BoardResponseDto selectBoard(int boardNum){
        Board board = boardRepository.findByisDeleteAndNo(false,boardNum);
        return new BoardResponseDto(board);
    }

    /** 글 수정 조회 메소드 */
    @Override
    public void updateBoard(HttpServletRequest request, int boardNum) throws ParseException {
        Board updateBoard = new BoardRequestDto(request).toEntity();
        boardRepository.updateByNo(updateBoard.getTitle(),updateBoard.getContent(), boardNum);

    }
    /** 글 삭제 메소드 */
    @Override
    public void deleteBoard(int boardNum) throws Exception {
        boardRepository.deleteByNo(boardNum);
    }
}
