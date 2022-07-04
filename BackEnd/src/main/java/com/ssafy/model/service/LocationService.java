package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.AptDongJibun;
import com.ssafy.model.dto.AptNameLocationCon;
import com.ssafy.model.dto.AptWithLatLng;

public interface LocationService {
	List<AptDongJibun> getList();

	int register(AptWithLatLng aptWithLatLng);

	List<AptNameLocationCon> getNearApt(Double lat, Double lng);

}
