package com.sks.boardserver.boardreply.data.support;

import com.sks.boardserver.boardreply.entity.BoardReply;
import org.springframework.stereotype.Component;

/**
 * BoardReply 커스텀 리포지토리 인터페이스
 */

public interface BoardReplyCustomRepository {
    public void updateByReplyNo(int replyNo, String content);
    public void deleteByReplyNo(int replyNo);
}
