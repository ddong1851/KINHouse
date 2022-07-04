package com.ssafy.controller;

import java.sql.SQLException;
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

import com.ssafy.model.dto.Notice;
import com.ssafy.model.service.NoticeService;

@RestController
@RequestMapping("/notice")
@CrossOrigin("*")
public class NoticeController {
	
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	@Autowired
	private NoticeService noticeService;

	@GetMapping(value = "/list")
	public ResponseEntity<?> getList() {
		try {
			List<Notice> list = noticeService.getNoticeList();
			if(list.size()!=0) {
				return new ResponseEntity<List<Notice>>(list, HttpStatus.ACCEPTED);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} // end of board list
	
	@PostMapping(value="/regist", produces="application/json;")
	public ResponseEntity<String> register(@RequestBody Notice notice){
		System.out.println(notice.toString());
		String msg = "";
		HttpStatus status = null;
		try {
			if(noticeService.register(notice)) {
				msg = SUCCESS;
			} else {
				msg = FAIL;
			}
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(msg);
		return new ResponseEntity<String>(msg, status);
	}
	
	@GetMapping("/list/{no}")
	public ResponseEntity<?> getListItem(@PathVariable("no") int no){
		try {
			Notice notice = noticeService.getDetail(no);
			return new ResponseEntity<Notice>(notice, HttpStatus.ACCEPTED);
		} catch (SQLException e) {
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{no}")
	public ResponseEntity<?> deleteItem(@PathVariable("no") int no){
		String msg = "";
		HttpStatus status = null;
		try {
			if(noticeService.deleteNotice(no)) {
				msg = SUCCESS;
			} else {
				msg = FAIL;
			}
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			msg = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<String>(msg, status);
	}
	
	@PutMapping(value="/modify/{no}", produces="application/json;")
	public ResponseEntity<?> modifyItem(@PathVariable int no, @RequestBody Notice notice){
		String msg = "";
		HttpStatus status = null;
		try {
			if(noticeService.modifyItem(no, notice)) {
				msg = SUCCESS;
			} else {
				msg = FAIL;
			}
			status = HttpStatus.ACCEPTED;
			System.out.println("정상수정");
			return new ResponseEntity<String>(msg, status);
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity<Void>(status);
		}
	}
	

}
