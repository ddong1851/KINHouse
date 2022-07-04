package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.LikedAptRequest;
import com.ssafy.model.dto.AddLikedAptResponse;
import com.ssafy.model.mapper.LikedAptMapper;

@Service
public class LikedAptServiceImpl implements LikedAptService {

	@Autowired
	LikedAptMapper mapper;
	
	@Override
	public boolean addlikedapt(LikedAptRequest likedaptrequest) {
		if(mapper.addlikedapt(likedaptrequest) == 1) {
//			return mapper.getSearchAptWithLiked(likedaptrequest);
			return true;
		}
		return false;
	}

	@Override
	public void deletelikedapt(Map<String, Object> map) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", map.get("userId"));
		param.put("no", map.get("no"));
		mapper.deletelikedapt(param);
	}

	@Override
	public List<AddLikedAptResponse> getUserLikedAptCode(String userId) {
		List<AddLikedAptResponse> list = mapper.getUserLikedAptCode(userId);
		return list;
	}

}
