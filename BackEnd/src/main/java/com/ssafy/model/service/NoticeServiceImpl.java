package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Notice;
import com.ssafy.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Override
	public List<Notice> getNoticeList() throws SQLException {
		// TODO Auto-generated method stub
		return noticeMapper.getNoticeList();
	}

	@Override
	public Notice getDetail(int no) throws SQLException {
		// TODO Auto-generated method stub
		noticeMapper.updatehits(no);
		return noticeMapper.getDetail(no);
	}

	@Override
	public boolean deleteNotice(int no) throws Exception {
		// TODO Auto-generated method stub
		return noticeMapper.deleteNotice(no);
	}

	@Override
	public boolean register(Notice notice) {
		// TODO Auto-generated method stub
		return noticeMapper.register(notice);
	}

	@Override
	public boolean modifyItem(int no, Notice notice) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("no", no);
		map.put("id", notice.getId());
		map.put("title", notice.getTitle());
		map.put("content", notice.getContent());
		return noticeMapper.modifyItem(map);
	}

	
}
