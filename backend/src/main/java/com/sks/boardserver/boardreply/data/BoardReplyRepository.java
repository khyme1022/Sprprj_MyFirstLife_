package com.sks.boardserver.boardreply.data;

import com.sks.boardserver.boardreply.data.support.BoardReplyCustomRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, BoardReplyCustomRepository {
    Page<BoardReply> findByBoardNoAndIsDeleteOrderByReplyNoDesc(int boardNo, Boolean isDelete, Pageable pageable); // page, sort 사용해서 해야함
}
