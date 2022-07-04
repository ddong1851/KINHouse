package com.ssafy.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.AptInfoHot;
import com.ssafy.model.dto.AptInfoLocal;

@Mapper
public interface HomeMapper {

	List<AptInfoLocal> getLocal(Map<String, String> map);

	List<AptInfoHot> getHot();

	List<AptInfoHot> getRand(int size);
	
}
