package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.AptDongJibun;
import com.ssafy.model.dto.AptNameLocationCon;
import com.ssafy.model.dto.AptWithLatLng;
import com.ssafy.model.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService{
	
	@Autowired
	LocationMapper locationMapper;
	
	@Override
	public List<AptDongJibun> getList() {
		// TODO Auto-generated method stub
		return locationMapper.getList();
	}

	@Override
	public int register(AptWithLatLng aptWithLatLng) {
		// TODO Auto-generated method stub
		return locationMapper.register(aptWithLatLng);
	}

	@Override
	public List<AptNameLocationCon> getNearApt(Double lat, Double lng) {
		// TODO Auto-generated method stub
		return locationMapper.getNearApt(lat, lng);
	}

}
