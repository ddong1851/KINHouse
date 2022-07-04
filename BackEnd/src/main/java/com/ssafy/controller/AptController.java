package com.ssafy.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ssafy.model.dto.AptResponseIsLoginVo;
import com.ssafy.model.dto.AptResponseVo;
import com.ssafy.model.dto.AptResponsebybCodeIsLoginVo;
import com.ssafy.model.dto.AptResponsebybCodeVo;
import com.ssafy.model.dto.AptSearchBybCodeIsLoginVo;
import com.ssafy.model.dto.AptSearchIsLoginVo;
import com.ssafy.model.dto.AptSearchVo;
import com.ssafy.model.dto.AptSearchBybCodeVo;
import com.ssafy.model.service.AptInfoService;
import com.ssafy.util.NewsApi;
import com.ssafy.util.PageNavigation;



@RestController
@RequestMapping("/house")
@CrossOrigin("*")
public class AptController {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(AptController.class);
	
	@Autowired
	private AptInfoService aptInfoService;
	
	
	@GetMapping("/home")
	public String house() {
		return "/apart/search";
	}

//  로그인 하지 않은 상태서 검색
	@GetMapping("/search")
	public ResponseEntity<AptResponseVo> search(@RequestParam Map<String, String> map) throws Exception{
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "10");
		List<AptSearchVo> list = aptInfoService.searchApt(map);			
		PageNavigation navigation = aptInfoService.makePageNavigation(map);
		AptResponseVo response = new AptResponseVo(list, navigation, map.get("key"), map.get("word"), navigation.getCurrentPage());
		return new ResponseEntity<AptResponseVo>(response, HttpStatus.OK);

	}
	
	// 로그인 한 상태서 검색
	@GetMapping("/search/isLogin")
	public ResponseEntity<AptResponseIsLoginVo> searchIsLogin(@RequestParam Map<String, String> map) throws Exception{
		System.out.println(map.toString());
		String spp = map.get("spp");
		map.put("spp", spp != null ? spp : "10");
		
		List<AptSearchIsLoginVo> list = aptInfoService.searchAptIsLogin(map);			
		PageNavigation navigation = aptInfoService.makePageNavigation(map);
		
		for (AptSearchIsLoginVo aptSearchIsLoginVo : list) {
			System.out.println(aptSearchIsLoginVo.toString());
		}
		
		AptResponseIsLoginVo response = new AptResponseIsLoginVo(list, navigation, map.get("key"), map.get("word"), navigation.getCurrentPage());
		
		return new ResponseEntity<AptResponseIsLoginVo>(response, HttpStatus.OK);

	}
	
	@GetMapping("/news/{keyword}")
	public ResponseEntity<String> news(@PathVariable("keyword") String keyword) throws Exception {

		String clientId = "7Td1A0XOg2_QIP2tWBqA";
		String clientSecret = "Qu3HdLf7XQ";
		
		String text = null;
		try {
			text = URLEncoder.encode(keyword, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("인코딩 실패", e);
		}
		String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text+ "&display=5&start=1&sort=sim";	// json
		
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = NewsApi.get(apiURL,requestHeaders);

		return new ResponseEntity<String>(responseBody, HttpStatus.OK);
	}
	
	@GetMapping("/findByAddress/{bcode}/{pg}")
	public ResponseEntity<AptResponsebybCodeVo> findByAddress(@PathVariable("bcode") String bcode, @PathVariable("pg") String pg) throws Exception {

		PageNavigation navigation = aptInfoService.makePageNavigation(Double.parseDouble(bcode), Integer.parseInt(pg));
		List<AptSearchBybCodeVo> list = aptInfoService.findByAddress(Double.parseDouble(bcode), Integer.parseInt(pg));
		AptResponsebybCodeVo response = new AptResponsebybCodeVo(list, navigation, "dong",list.get(0).getDong(), navigation.getCurrentPage());
		
		return new ResponseEntity<AptResponsebybCodeVo>(response, HttpStatus.OK);
	}
	
	@GetMapping("/findByAddress/{bcode}/{pg}/{userId}")
	public ResponseEntity<AptResponsebybCodeIsLoginVo> findByAddressIsLogin(@PathVariable("bcode") String bcode, @PathVariable("pg") String pg, @PathVariable("userId") String id) throws Exception {

		PageNavigation navigation = aptInfoService.makePageNavigation(Double.parseDouble(bcode), Integer.parseInt(pg));
		List<AptSearchBybCodeIsLoginVo> list = aptInfoService.findByAddressIsLogin(Double.parseDouble(bcode), Integer.parseInt(pg), id);
		AptResponsebybCodeIsLoginVo response = new AptResponsebybCodeIsLoginVo(list, navigation, "dong",list.get(0).getDong(), navigation.getCurrentPage());
		
		return new ResponseEntity<AptResponsebybCodeIsLoginVo>(response, HttpStatus.OK);
	}

}
