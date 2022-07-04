package com.ssafy.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.LikedAptRequest;
import com.ssafy.model.dto.AddLikedAptResponse;

@Mapper
public interface LikedAptMapper {	
	public int addlikedapt(LikedAptRequest likedaptrequest);
	public void deletelikedapt(Map<String, Object> param);
	public List<AddLikedAptResponse> getUserLikedAptCode(String userId);
	public List<AddLikedAptResponse> getSearchAptWithLiked(LikedAptRequest likedaptrequest);
}
