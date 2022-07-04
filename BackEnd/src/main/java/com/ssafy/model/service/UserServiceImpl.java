package com.ssafy.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.model.dto.Liked_apt;
import com.ssafy.model.dto.User;
import com.ssafy.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean register(User user) {
		return userMapper.register(user);
	}

	@Override
	public boolean delete(String id) {
		Map<String, String> map = new HashMap<>();
		map.put("origin", id);
		map.put("to", "undefined");
		userMapper.changeUserNotice(map);
		userMapper.changeUserQna(map);
		userMapper.changeUserReply(map);
		userMapper.deleteLikedUser(id);
		return userMapper.delete(id);
	}

	@Override
	public User getUser(String id) {
		return userMapper.getUser(id);
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		userMapper.setLoginTime(user.getId());
		return userMapper.login(user);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	@Override
	public User getUserInfo(String id) {
		// TODO Auto-generated method stub
		return userMapper.getUserInfo(id);
	}

	@Override
	public boolean modify(User user) {
		// TODO Auto-generated method stub
		return userMapper.modify(user);
	}

	@Override
	public String findId(User user) {
		// TODO Auto-generated method stub
		return userMapper.findId(user);
	}

	@Override
	public String findPass(User user) {
		// TODO Auto-generated method stub
		return userMapper.findPass(user);
	}

	@Override
	public int check(User user) {
		HashMap<String, String> map = new HashMap<>();
		if (user.getEmail() != null) {
			map.put("key", "email");
			map.put("email", user.getEmail());
		} else {
			map.put("key", "id");
			map.put("id", user.getId());
		}
		return userMapper.check(map);
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return userMapper.getList();
	}

	@Override
	public List<Liked_apt> getLiked(String id) {
		return userMapper.getLiked(id);
	}

	@Override
	public boolean deleteItem(int id) {
		return userMapper.deleteItem(id);
	}

}
