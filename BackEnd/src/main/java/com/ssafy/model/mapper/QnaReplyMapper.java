package com.ssafy.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Qna_reply;

@Mapper
public interface QnaReplyMapper {
	boolean submit(Qna_reply reply);
	List<Qna_reply> getList(int qna_no);
	boolean deleteItem(int no);
	boolean modifyItem(Map<String, Object> map);
}
