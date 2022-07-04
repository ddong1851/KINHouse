package com.ssafy.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.AptDongJibun;
import com.ssafy.model.dto.AptNameLocationCon;
import com.ssafy.model.dto.AptWithLatLng;

@Mapper
public interface LocationMapper {
	
	List<AptDongJibun> getList();

	int register(AptWithLatLng aptWithLatLng);

	List<AptNameLocationCon> getNearApt(Double lat, Double lng);
}
