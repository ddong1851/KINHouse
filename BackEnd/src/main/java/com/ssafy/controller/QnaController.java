package com.ssafy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.Qna;
import com.ssafy.model.service.QnaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/qna")
public class QnaController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	QnaService qnaService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		return new ResponseEntity<List<Qna>>(qnaService.getlist(), HttpStatus.OK);
	}
	
	@PostMapping(value="/register", produces="application/json;")
	public ResponseEntity<String> register(@RequestBody Qna qna) {
		System.out.println("check");
		System.out.println(qna.toString());
		if(qnaService.register(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/list/{no}")
	public ResponseEntity<Qna> selectItem(@PathVariable int no){
		return new ResponseEntity<Qna>(qnaService.selectItem(no), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<String> delete(@PathVariable int no){
		if(qnaService.delete(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/modify/{no}", produces="application/json;")
	public ResponseEntity<String> modify(@RequestBody Qna qna) {
		if(qnaService.modify(qna)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
