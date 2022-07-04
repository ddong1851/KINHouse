package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Qna;

public interface QnaService {
	List<Qna> getlist();
	boolean register(Qna qna);
	Qna selectItem(int no);
	boolean delete(int no);
	boolean modify(Qna qna);
}
