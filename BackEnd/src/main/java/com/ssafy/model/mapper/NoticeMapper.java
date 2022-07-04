package com.ssafy.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Notice;

@Mapper
public interface NoticeMapper {
	/** 모든 게시판 정보를 받아온다.*/
	List<Notice> getNoticeList() throws SQLException;
	/** 게시판 번호를 통해 상세 게시판 정보를 가져온다*/
	Notice getDetail(int no) throws SQLException;
	/** 선택한 항목 삭제*/
	boolean deleteNotice(int no) throws Exception;
	/** 공지사항 게시*/
	boolean register(Notice notice);
	/** 조회수 증가 메서드*/
	void updatehits(int no);
	/** 수정 */
	boolean modifyItem(Map<String, Object> map);
}
