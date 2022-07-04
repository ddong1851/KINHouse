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

import com.ssafy.model.dto.Qna_reply;
import com.ssafy.model.service.QnaReplyService;

@RestController
@CrossOrigin("*")
@RequestMapping("/reply")
public class QnaReplyController {
	
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	
	@Autowired
	QnaReplyService replyService;
	
	@PostMapping(value="/register", produces="application/json;")
	public ResponseEntity<String> submitReply(@RequestBody Qna_reply reply){
		if(replyService.submit(reply)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	} // end of submit
	
	@GetMapping("/list/{qna_no}")
	public ResponseEntity<?> getReplyList(@PathVariable int qna_no){
		return new ResponseEntity<List<Qna_reply>>(replyService.getList(qna_no),
				HttpStatus.OK);
	} // end of list
	
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<?> deleteItem(@PathVariable("no") int no){
		try {
			if(replyService.delete(no)) {
				return new ResponseEntity<String>(SUCCESS, HttpStatus.ACCEPTED);
			}
			return new ResponseEntity<String>(FAIL, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value="/modify/{no}", produces="application/json;")
	public ResponseEntity<String> modifyItem(@PathVariable("no") int no, @RequestBody Qna_reply reply){
		System.out.println(reply);
		String msg = "";
		HttpStatus status = null;
		try {
			if(replyService.modify(no, reply.getContent())) msg = SUCCESS;
			else msg = FAIL;
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			msg = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(msg, status);
	}
	
	
} // end of class 
