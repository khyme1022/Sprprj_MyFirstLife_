package com.sks.boardserver.board.data;

import com.sks.boardserver.board.data.support.BoardCustomRepository;
import com.sks.boardserver.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {

}
