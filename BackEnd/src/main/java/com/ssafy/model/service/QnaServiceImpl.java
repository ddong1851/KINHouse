package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Qna;
import com.ssafy.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{

	@Autowired
	QnaMapper qnaMapper;
	
	@Override
	public List<Qna> getlist() {
		return qnaMapper.getlist();
	}

	@Override
	public boolean register(Qna qna) {
		return qnaMapper.register(qna);
	}

	@Override
	public Qna selectItem(int no) {
		// TODO Auto-generated method stub
		// hits 1 증가 후 리스트 아이템을 가져온다.
		qnaMapper.updateHits(no);
		return qnaMapper.selectItem(no);
	}

	@Override
	public boolean delete(int no) {
		// 종속된 답글 먼저 삭제.
		qnaMapper.deleteReplys(no);
		return qnaMapper.delete(no);
	}

	@Override
	public boolean modify(Qna qna) {
		// TODO Auto-generated method stub
		return qnaMapper.modify(qna);
	}
}
