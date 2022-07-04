package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.model.dto.LikedAptRequest;
import com.ssafy.model.dto.AddLikedAptResponse;

@Service
public interface LikedAptService {

	public boolean addlikedapt(LikedAptRequest likedaptrequest);

	public void deletelikedapt(Map<String, Object> map);

	public List<AddLikedAptResponse> getUserLikedAptCode(String userId);
	
}
