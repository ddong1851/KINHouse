package com.ssafy.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Liked_apt;
import com.ssafy.model.dto.User;

@Mapper
public interface UserMapper {
	
	public List<User> searchAll();
	public boolean register(User user);
	public boolean delete(String id);
	public User getUser(String id);
	public User login(User user);
	public void update(User user);
	public User getUserInfo(String id);
	public boolean modify(User user);
	public String findId(User user);
	public String findPass(User user);
	public int check(HashMap<String, String> map);
	public List<User> getList();
	public void setLoginTime(String id);
	public List<Liked_apt> getLiked(String id);
	public boolean deleteItem(int id);
	public boolean changeUserNotice(Map<String, String> map);
	public boolean changeUserQna(Map<String, String> map);
	public boolean changeUserReply(Map<String, String> map);
	public boolean deleteLikedUser(String id);
	
}
