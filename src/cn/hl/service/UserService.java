package cn.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hl.dao.UserDao;
import cn.hl.exception.MeetException;
import cn.hl.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	/**
	 * 插入用户信息
	 * @param user
	 * @return
	 */
	public int add(User user) {
		return dao.add(user);
	}
	
	/**
	 * 按照Id删除用户信息
	 * @param id
	 * @return
	 */
	public int delete (int id) {
		return dao.delete(id);
	}
	
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public int update(User user) {
		return dao.update(user);
	}
	
	/**
	 * 按照Id查询指定用户信息
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		return dao.getById(id);
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> getAll(){
		return dao.getAll();
	}
	
	/**
	 * 按照名字查询用户信息，执行登陆
	 * @param name
	 * @return
	 */
	public User getByAccount(String account,String pwd){
		User user=dao.getByAccount(account);
		
		//判断账号是否存在
		if(user==null) {
			return null;
		}else {
			//判断密码是否正确
			if(user.getPwd().equals(pwd)) {
				//判断账号状态是否为1
				if(user.getState()!=1) {
					throw new MeetException("账号已经被冻结");
				}else {
					return user;	
				}
			}else {
				return null;
			}
		}
	}
}
