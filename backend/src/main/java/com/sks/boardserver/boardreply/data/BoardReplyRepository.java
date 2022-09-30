package com.sks.boardserver.boardreply.data;

import com.sks.boardserver.boardreply.data.support.BoardReplyCustomRepository;
import com.sks.boardserver.boardreply.entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>, BoardReplyCustomRepository {
}
