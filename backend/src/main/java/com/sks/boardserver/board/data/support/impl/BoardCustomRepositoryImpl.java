package com.sks.boardserver.board.data.support.impl;

import com.sks.boardserver.board.QBoard;
import com.sks.boardserver.board.data.BoardRepository;
import com.sks.boardserver.board.data.support.BoardCustomRepository;
import com.sks.boardserver.board.entity.Board;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

// QueryDSL 메소드 정의 구현 클래스
@Component
public class BoardCustomRepositoryImpl extends QuerydslRepositorySupport implements BoardCustomRepository {

    public BoardCustomRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public List<Board> findByNo(Long Number) {
        QBoard board = QBoard.board;

        List<Board> boardList = from(board)
                .select(board)
                .fetch();
        return boardList;
    }
}
