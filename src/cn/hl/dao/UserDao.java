package cn.hl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hl.mapper.UserMapper;
import cn.hl.pojo.User;

@Repository
public class UserDao {

	@Autowired
	private UserMapper mapper;
	
	public int add(User user) {
		return mapper.add(user);
	}
	
	public int delete(int id) {
		return mapper.delete(id);
	}
	
	public int update(User user) {
		return mapper.update(user);
	}
	
	public User getById(int id) {
		return mapper.getById(id);
	}
	
	public List<User> getAll(){
		return mapper.getAll();
	}
	
	public User getByAccount(String account){
		return mapper.getByAccount(account);
	}
	
}
