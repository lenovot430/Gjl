package cn.hl.mapper;

import java.util.List;

import cn.hl.pojo.User;

public interface UserMapper {

	//添加部门信息
	public int add(User user);
	
	//按照ID删除部门信息
	public int delete(int id);
	
	//按照Id更改部门信息
	public int update(User user);
	
	//按照Id查询部门信息
	public User getById(int id);
	
	//查询所有部门信息
	public List<User> getAll();
	
	//按照部门名查询
	public User getByAccount(String account);
}
