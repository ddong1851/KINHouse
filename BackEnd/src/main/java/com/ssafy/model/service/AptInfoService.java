package com.ssafy.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.AptSearchIsLoginVo;
import com.ssafy.model.dto.AptSearchVo;
import com.ssafy.model.dto.AptSearchBybCodeIsLoginVo;
import com.ssafy.model.dto.AptSearchBybCodeVo;
import com.ssafy.util.PageNavigation;

public interface AptInfoService {
	List<AptSearchVo> searchApt(Map<String, String> map) throws Exception;
	PageNavigation makePageNavigation(Map<String, String> map)  throws Exception;
	List<AptSearchIsLoginVo> searchAptIsLogin(Map<String, String> map) throws Exception;
	List<AptSearchBybCodeVo> findByAddress(double bcode, int pg) throws Exception;
	PageNavigation makePageNavigation(double bcode, int pg) throws Exception;
	List<AptSearchBybCodeIsLoginVo> findByAddressIsLogin(double bcode, int pg, String id);
}
