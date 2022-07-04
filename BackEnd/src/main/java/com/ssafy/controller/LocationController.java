package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.AptDongJibun;
import com.ssafy.model.dto.AptNameLocationCon;
import com.ssafy.model.dto.AptWithLatLng;
import com.ssafy.model.service.LocationService;

/** DB 갱신용*/
@RestController
@CrossOrigin("*")
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	LocationService locationService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<AptDongJibun> list = locationService.getList();
		if(list!=null && !list.isEmpty()) return new ResponseEntity<List<AptDongJibun>>(list, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AptWithLatLng aptWithLatLng){
		int res = locationService.register(aptWithLatLng);
		if(res==1) return new ResponseEntity<String> ("성공!!", HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/getNearApt/{lat}/{lng}")
	public ResponseEntity<?> getNearApt(@PathVariable(value="lat") Double lat, @PathVariable(value="lng") Double lng){
		System.out.println(lat+" "+lng);
		List<AptNameLocationCon> list = locationService.getNearApt(lat, lng);
		if(list!=null && !list.isEmpty()) return new ResponseEntity<List<AptNameLocationCon>>(list, HttpStatus.OK);
		else return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
