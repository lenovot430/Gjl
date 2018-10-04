package cn.hl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hl.pojo.Emp;
import cn.hl.pojo.Sys_User;
import cn.hl.service.EmpService;

@Controller
public class Sys_UserController {
	@Autowired
	private EmpService service;

/*	@RequestMapping("add")
	public String add(String name) {
//		int b=20/i;
		if(name==null) {
			throw new MeetException("名字不能为空");
		}
//		System.out.println(b);
		
		return "index.jsp";
	}*/
	
	
	@RequestMapping("test1")
	@ResponseBody
	public String method1() {
		
		System.out.println("method1 is do....");
		
		return "hello";
	}
	
	/**
	 * 返回list集合对象
	 * @return
	 */
	@RequestMapping(value="user1",method=RequestMethod.PATCH)
	@ResponseBody
	public List<Sys_User> getAll(){
		
		System.out.println("getAll() is do ...");
		
		List<Sys_User> list = new ArrayList<Sys_User>();
		
		list.add(new Sys_User(1,"Mike",true,"123123123"));
		list.add(new Sys_User(1,"Rose",false,"708098232"));
		
		System.out.println(list);
		
		return list;
	}
	
	/**
	 * 添加数据
	 * @param user
	 * @return
	 */
	@RequestMapping(value="user1",method=RequestMethod.POST)
	@ResponseBody
	public String add(Sys_User user) {
		
		System.out.println("add() is do ...");
		System.out.println(user);
		
		return "success";
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="user1/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String del(@PathVariable int id) {
		
		System.out.println(id);
		
		return "success";
	}
	
	/**
	 * 更新数据
	 * @param user
	 * @return
	 */
	@RequestMapping(value="user1",method=RequestMethod.PUT)
	@ResponseBody
	public String update(Sys_User user) {
		
		System.out.println("update() is do ...");
		
		System.out.println(user);
		
		return "success";
		
	}
	
	/**
	 * 按照Id查询数据
	 * @return
	 */
	@RequestMapping(value="user1/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Sys_User getById(@PathVariable int id) {
		
		System.out.println("id="+id);
		
		return new Sys_User(7,"Lily",true,"123123123");
		
	}
	

	
	@RequestMapping(value="add")
	public String getEmp() {
		
		List<Emp> emp=service.getAll();
		System.out.println(emp);
		
		return "WEB-INF/add.jsp";
	}
	
	
}
