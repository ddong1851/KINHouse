package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.AptInfoHot;
import com.ssafy.model.dto.AptInfoLocal;
import com.ssafy.model.mapper.HomeMapper;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	HomeMapper homeMapper;

	@Override
	public List<AptInfoLocal> getLocal(Map<String, String> map) {
		// TODO Auto-generated method stub
		return homeMapper.getLocal(map);
	}

	@Override
	public List<AptInfoHot> getHot() {
		List<AptInfoHot> list = homeMapper.getHot();
		int size = 12 - list.size();
		System.out.println(size);
		if(size>0) {
			list.addAll(homeMapper.getRand(size));
		}
		
		for (int i = 0; i < 12; i++) {
			list.get(i).setImg_num((int)(Math.random()*10));
		}
		
		return list;
	}

}
