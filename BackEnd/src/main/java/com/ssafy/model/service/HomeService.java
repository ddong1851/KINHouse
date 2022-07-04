package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.AptInfoHot;
import com.ssafy.model.dto.AptInfoLocal;

public interface HomeService {
	List<AptInfoLocal> getLocal(Map<String, String> map);

	List<AptInfoHot> getHot();
}
