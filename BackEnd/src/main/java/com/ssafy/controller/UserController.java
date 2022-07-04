package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

import com.ssafy.model.dto.Liked_apt;
import com.ssafy.model.dto.User;
import com.ssafy.model.service.JwtService;
import com.ssafy.model.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
	
	public static String SUCCESS = "success";
	public static String FAIL = "fail";
	public static String msg = "message";
	@Autowired
	JwtService jwtService;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user){
		Map<String, Object> result = new HashMap<>();
		HttpStatus status = null;
		try {
			User check = userService.login(user);
			if(check!=null) {
				String token = jwtService.create("userid", check.getId(), "access-token");
				result.put("token", token);
				result.put("id", check.getId());
				result.put("name", check.getName());
				result.put(msg, SUCCESS);
				// 사용자 관심 목록 가져오기
				result.put("liked", userService.getLiked(user.getId()));
				status = HttpStatus.ACCEPTED;
			} else {
				result.put(msg, FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			result.put(msg, e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(result.get(msg));
		return new ResponseEntity<Map<String,Object>>(result, status);
	} // end of login
	
	@GetMapping("/info/{id}")
	public ResponseEntity<Map<String, Object>> getUserInfo(@PathVariable("id") String id, HttpServletRequest request){
		Map<String, Object> result = new HashMap<>();
		HttpStatus status = null;
		System.out.println(id);
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			try {
				User user = userService.getUserInfo(id);
				result.put("userInfo", user);
				result.put(msg, SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				result.put(msg, e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			result.put(msg, "FAIL");
			status = HttpStatus.ACCEPTED;
		}
		System.out.println(result);
		return new ResponseEntity<Map<String,Object>>(result, status);
	}
	
	@PostMapping("/regist")
	public ResponseEntity<String> register(@RequestBody User user){
		if(userService.register(user)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	} // end of register
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyUser(@RequestBody User user){
		if(userService.modify(user)) {
			System.out.println("수정 "+SUCCESS);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		System.out.println("삭제");
		if(userService.delete(id)) {
			System.out.println("삭제 성공");
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/find/id")
	public ResponseEntity<?> findId(@RequestBody User user){
		String id = userService.findId(user);
		if(id!=null) {
			return new ResponseEntity<String>(id, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/find/pass")
	public ResponseEntity<?> findPass(@RequestBody User user){
		String password = userService.findPass(user);
		if(password!=null) {
			return new ResponseEntity<String>(password, HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/check")
	public ResponseEntity<?> checkDuplicated(@RequestBody User user){
		if(userService.check(user)==1) {
			return new ResponseEntity<String>("Y", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("N", HttpStatus.OK);
		}
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getUserList(){
		return new ResponseEntity<List<User>>(userService.getList(), HttpStatus.OK);
	}
	
	@GetMapping("/liked/{id}")
	public ResponseEntity<?> getUserLikedList(@PathVariable String id){
		return new ResponseEntity<List<Liked_apt>>(userService.getLiked(id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/item/{id}")
	public ResponseEntity<?> deleteUserLikedItem(@PathVariable int id){
		System.out.println(id);
		String msg = "";
		HttpStatus status = null;
		try {
			if(userService.deleteItem(id)) {
				msg = SUCCESS;
			} else {
				msg = FAIL;
			}
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			msg = e.getMessage();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		System.out.println(msg);
		return new ResponseEntity<String>(msg, status);
	}
	
} // end of class 
