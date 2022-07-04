package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.AptInfoHot;
import com.ssafy.model.dto.AptInfoLocal;
import com.ssafy.model.service.HomeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	
	
	@PostMapping("/local")
	public ResponseEntity<?> getLocal(@RequestBody Map<String, String> map){
		System.out.println(map);
		return new ResponseEntity<List<AptInfoLocal>>(homeService.getLocal(map), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/hot")
	public ResponseEntity<?> getHot(){
		try {
			List<AptInfoHot> list = homeService.getHot();
			if(list.size()!=0) {
				return new ResponseEntity<List<AptInfoHot>>(list, HttpStatus.ACCEPTED);
			} 
			return new ResponseEntity<String>(FAIL, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
