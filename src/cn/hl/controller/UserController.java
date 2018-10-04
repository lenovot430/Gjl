package cn.hl.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hl.pojo.User;
import cn.hl.service.UserService;

@Controller
public class UserController {
	
	private final String SUCCESS="success";
	private final String ERROR="error";
	
	@Autowired
	private UserService service;

	/**
	 * 执行用户添加操作
	 * @param user
	 * @return
	 */
	@RequestMapping(value="user",method=RequestMethod.POST)
	@ResponseBody
	public String add(User user) {
		if(service.add(user)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	@RequestMapping(value="user",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAll() {
		return service.getAll(); 
	}
	
	/**
	 * 按照Id删除信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int id) {
		if(service.delete(id)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 更新用户数据
	 * @param user
	 * @return
	 */
	@RequestMapping(value="user",method=RequestMethod.PUT)
	@ResponseBody
	public String update(User user) {
		
		System.out.println("update() is do..."+user);
		
		if(service.update(user)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 按照Id查询所有用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user/{id}",method=RequestMethod.PATCH)
	@ResponseBody
	public User getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	
	
	/**
	 * 执行登陆验证
	 * @param account
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login/{account}/{pwd}")
	@ResponseBody
	public String login(@PathVariable String account, @PathVariable String pwd,HttpSession session,Model model) {
		User user=service.getByAccount(account,pwd);
		
		System.out.println("登陆方法执行了");
		if(user!=null) {
			session.setAttribute("user", user);
			
			return this.SUCCESS;
		}else {
			return "User name or password error";
		}
	}
	
	/**
	 * 执行用户注销功能
	 * @param session
	 * @return
	 */
	@RequestMapping(value="logout")
	@ResponseBody
	public String logout(HttpSession session) {
		session.invalidate();
		return this.SUCCESS;
	}
	
}
