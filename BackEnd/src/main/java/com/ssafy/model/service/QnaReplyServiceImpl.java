package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Qna_reply;
import com.ssafy.model.mapper.QnaMapper;
import com.ssafy.model.mapper.QnaReplyMapper;

@Service
public class QnaReplyServiceImpl implements QnaReplyService{
	
	@Autowired
	QnaReplyMapper qnaReplyMapper;

	@Override
	public boolean submit(Qna_reply reply) {
		return qnaReplyMapper.submit(reply);
	}

	@Override
	public List<Qna_reply> getList(int qna_no) {
		// TODO Auto-generated method stub
		return qnaReplyMapper.getList(qna_no);
	}

	@Override
	public boolean delete(int no) {
		// TODO Auto-generated method stub
		return qnaReplyMapper.deleteItem(no);
	}

	@Override
	public boolean modify(int no, String content) {
		Map<String, Object> map = new HashMap<>();
		map.put("no", no);
		map.put("content", content);
		return qnaReplyMapper.modifyItem(map);
	}
}
