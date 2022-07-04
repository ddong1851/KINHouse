package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Liked_apt;
import com.ssafy.model.dto.User;

public interface UserService {
	
	boolean register(User user);
	boolean delete(String id);
	User getUser(String id);
	User login(User user);
	void update(User user);
	User getUserInfo(String id);
	boolean modify(User user);
	String findId(User user);
	String findPass(User user);
	int check(User user);
	List<User> getList();
	List<Liked_apt> getLiked(String id);
	boolean deleteItem(int id);
}
