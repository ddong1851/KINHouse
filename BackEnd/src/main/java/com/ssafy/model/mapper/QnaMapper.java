package com.ssafy.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Qna;

@Mapper
public interface QnaMapper {
	List<Qna> getlist();
	boolean register(Qna qna);
	Qna selectItem(int no);
	boolean delete(int no);
	void deleteReplys(int no);
	boolean modify(Qna qna);
	void updateHits(int no);
}
