package com.sks.boardserver.boardreply.data.support;

import com.sks.boardserver.board.entity.QBoard;

public interface BoardReplyCustomRepository {
    public void updateByNo(String content, int replyNo, int boardNo);
    public void deleteByNo(int replyNo, int boardNo);
}
