package com.sks.boardserver.board.data.support;

import com.sks.boardserver.board.entity.Board;

import java.util.List;

// QueryDSL 메소드 정의 인터페이스
public interface BoardCustomRepository {
    List<Board> findByNo(Long Number);
}
