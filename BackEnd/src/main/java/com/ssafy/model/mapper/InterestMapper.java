package com.ssafy.model.mapper;

import java.util.List;

import com.ssafy.model.dto.Interest;


public interface InterestMapper {
	public List<Interest> searchAll();
	public List<Interest> selectUser(String id);
	public void update(int type, String id);
	public void update(int type, String id, String key, String value);
}
