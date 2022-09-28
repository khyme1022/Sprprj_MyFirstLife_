package com.sks.boardserver.board.data;

import com.sks.boardserver.board.data.support.BoardCustomRepository;
import com.sks.boardserver.board.entity.Board;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
    public Page<Board> findByisDelete(Boolean isDelete, Pageable pageable); // page, sort 사용해서 해야함
    public Board findByisDeleteAndNo(Boolean isDelete, int no);
}
