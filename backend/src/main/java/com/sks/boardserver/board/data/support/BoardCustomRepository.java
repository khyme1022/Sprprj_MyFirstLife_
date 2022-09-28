package com.sks.boardserver.board.data.support;

import com.sks.boardserver.board.entity.Board;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

// QueryDSL 메소드 정의 인터페이스
public interface BoardCustomRepository {
    public Board findByNo(int number);
    public void updateByNo(String title, String content, int number);
    public void deleteByNo(int number);

}
