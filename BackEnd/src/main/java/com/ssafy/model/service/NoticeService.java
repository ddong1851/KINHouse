package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Notice;

public interface NoticeService {
	/** 모든 게시판 정보를 받아온다.*/
	List<Notice> getNoticeList() throws SQLException;
	/** 공지사항 게시*/
	boolean register(Notice notice);
	/** 게시판 번호를 통해 상세 게시판 정보를 가져온다*/
	Notice getDetail(int no) throws SQLException;
	/** 선택한 항목 삭제*/
	boolean deleteNotice(int no) throws Exception;
	/** 수정*/
	boolean modifyItem(int no, Notice notice);
}
