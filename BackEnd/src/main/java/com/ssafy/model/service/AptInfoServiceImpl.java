package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.AptSearchIsLoginVo;
import com.ssafy.model.dto.AptSearchVo;
import com.ssafy.model.dto.AptSearchBybCodeIsLoginVo;
import com.ssafy.model.dto.AptSearchBybCodeVo;
import com.ssafy.model.mapper.AptInfoMapper;
import com.ssafy.util.PageNavigation;

@Service
public class AptInfoServiceImpl implements AptInfoService {

	@Autowired
	private AptInfoMapper aptMapper; 
	
	// 로그인 안됐을 때 검색
	@Override
	public List<AptSearchVo> searchApt(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		String word = map.get("word");
		String s = map.get("s");
		
		if(key==null) {
			List<AptSearchVo> list = null;
			return list;
		}
		param.put("key", map.get("key") == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : word);
		param.put("s", map.get("s") == null ? "1" : s);
		
		int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		
		return aptMapper.searchApt(param);
	}
	
	// 로그인 됐을 때 검색
	@Override
	public List<AptSearchIsLoginVo> searchAptIsLogin(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		String key = map.get("key");
		String word = map.get("word");
		String s = map.get("s");
		
		if(key==null) {
			List<AptSearchIsLoginVo> list = null;
			return list;
		}
		param.put("key", map.get("key") == null ? "" : key);
		param.put("word", map.get("word") == null ? "" : word);
		param.put("s", map.get("s") == null ? "1" : s);
		param.put("userId", map.get("userId"));
		
		int currentPage = Integer.parseInt(map.get("pg") == null ? "1" : map.get("pg"));
		int sizePerPage = Integer.parseInt(map.get("spp"));
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		System.out.println("here");
		return aptMapper.searchAptIsLogin(param);
	}

	@Override
	public PageNavigation makePageNavigation(Map<String, String> map) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		
		int naviSize = 10;
		int currentPage = map.get("pg") != null ? Integer.parseInt(map.get("pg")) : 1;
		int sizePerPage = Integer.parseInt(map.get("spp"));
		
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);

		int totalCount = 0;
		String key = map.get("key") == null ? "" : map.get("key");
		String word = map.get("word") == null ? "" : map.get("word");
		String s = map.get("s") == null ? "1" : map.get("s");
		if(!word.isEmpty()) {
			if("apt".equals(key)) {								
				totalCount = aptMapper.getAptCount(map);			
			}else if("dong".equals(key)) {						
				totalCount = aptMapper.getDongCount(map);			
			}			
		}else {
			totalCount = aptMapper.getTotalCount(map);			
		}

		System.out.println(totalCount);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}

	public PageNavigation makePageNavigation(double bcode, int pg) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();
		int naviSize = 10;
		int currentPage = pg;
		int sizePerPage = 10;
		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);
		int totalCount = aptMapper.getTotalCountBybcode(bcode);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		
		return pageNavigation;
	}
	
	// 비 로그인 상태에서 주소로 찾기
	@Override
	public List<AptSearchBybCodeVo> findByAddress(double bcode, int pg) throws Exception{
		int currentPage = pg;
		int sizePerPage = 10;
		int start = (currentPage - 1) * sizePerPage;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("spp", sizePerPage);
		param.put("bcode", bcode);
		return aptMapper.findByAddress(param);
	}

	// 로그인 상태에서 주소로 찾기
	@Override
	public List<AptSearchBybCodeIsLoginVo> findByAddressIsLogin(double bcode, int pg, String id) {
		int currentPage = pg;
		int sizePerPage = 10;
		int start = (currentPage - 1) * sizePerPage;
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("spp", sizePerPage);
		param.put("bcode", bcode);
		param.put("id", id);
		return aptMapper.findByAddressIsLogin(param);
	}
	
	
}
