package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Qna_reply;

public interface QnaReplyService {
	boolean submit(Qna_reply reply);

	List<Qna_reply> getList(int qna_no);

	boolean delete(int no);

	boolean modify(int no, String content);
}
