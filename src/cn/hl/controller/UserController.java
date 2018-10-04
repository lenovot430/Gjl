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
	 * ִ���û���Ӳ���
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
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	@RequestMapping(value="user",method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAll() {
		return service.getAll(); 
	}
	
	/**
	 * ����Idɾ����Ϣ
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
	 * �����û�����
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
	 * ����Id��ѯ�����û���Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user/{id}",method=RequestMethod.PATCH)
	@ResponseBody
	public User getById(@PathVariable int id) {
		return service.getById(id);
	}
	
	
	
	/**
	 * ִ�е�½��֤
	 * @param account
	 * @param pwd
	 * @param session
	 * @return
	 */
	@RequestMapping(value="login/{account}/{pwd}")
	@ResponseBody
	public String login(@PathVariable String account, @PathVariable String pwd,HttpSession session,Model model) {
		User user=service.getByAccount(account,pwd);
		
		System.out.println("��½����ִ����");
		if(user!=null) {
			session.setAttribute("user", user);
			
			return this.SUCCESS;
		}else {
			return "User name or password error";
		}
	}
	
	/**
	 * ִ���û�ע������
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
