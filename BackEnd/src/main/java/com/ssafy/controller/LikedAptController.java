package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.LikedAptRequest;
import com.ssafy.model.dto.AddLikedAptResponse;
import com.ssafy.model.service.LikedAptService;

@RestController
@RequestMapping("house/liked-apt-code")
@CrossOrigin("*")
public class LikedAptController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	private static final String TRUE = "true";
	private static final String FALSE = "false";
	
	@Autowired
	private LikedAptService likedaptservice;
	
	@GetMapping
	public ResponseEntity<List<AddLikedAptResponse>> getUserLikedAptCode(@RequestParam("userid") String userId) throws Exception{
		List<AddLikedAptResponse> list = likedaptservice.getUserLikedAptCode(userId);
		if(list.size()>0) {
			return new ResponseEntity<List<AddLikedAptResponse>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<AddLikedAptResponse>>(HttpStatus.NO_CONTENT);
		
	}
	
	@PostMapping(produces="application/json;")
	public ResponseEntity<String> addLikedApt(@RequestBody LikedAptRequest likedaptrequest) throws Exception{
//		System.out.println(likedaptrequest.toString());
		if(likedaptservice.addlikedapt(likedaptrequest)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	@DeleteMapping("/{userId}/{no}")
	public ResponseEntity<String> deleteLikedApt(@PathVariable("userId") String userid, @PathVariable("no") long no) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userid);
		map.put("no", no);
		System.out.println(map.get("userId")+", "+map.get(no));
		likedaptservice.deletelikedapt(map);
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
	
}
