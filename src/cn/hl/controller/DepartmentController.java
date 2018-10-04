package cn.hl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hl.pojo.Department;
import cn.hl.service.DepartmentService;

@Controller
public class DepartmentController {

	private final String SUCCESS="success";
	private final String ERROR="error";
	
	@Autowired
	private DepartmentService service;
	
	/**
	 * 执行部门添加操作
	 * @param dept
	 * @return
	 */
	@RequestMapping(value="dept",method=RequestMethod.POST)
	@ResponseBody
	public String add(Department dept) {
		if(service.add(dept)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 执行部门删除操作
	 * @param Id
	 * @return
	 */
	@RequestMapping(value="dept/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable int id) {
		System.out.println("delete is do....");
		if(service.delete(id)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 按照Id执行部门修改操作
	 * @return
	 */
	@RequestMapping(value="dept",method=RequestMethod.PUT)
	@ResponseBody
	public String update(Department dept) {
		if(service.update(dept)>0) {
			return this.SUCCESS;
		}else {
			return this.ERROR;
		}
	}
	
	/**
	 * 按照ID查询部门信息
	 * @param Id
	 * @return
	 */
	@RequestMapping(value="dept/{id}",method=RequestMethod.PATCH)
	@ResponseBody
	public Department getById(@PathVariable int id) {
		
		System.out.println("getById is do.."+id);
		
		return service.getById(id);
	}
	
	/**
	 * 查询所有部门信息
	 * @return
	 */
	@RequestMapping(value="dept",method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getAll(){
		return service.getAll();
	}
	
	/**
	 * 自我书写页面跳转
	 * @return
	 */
	@RequestMapping(value="jump",method=RequestMethod.POST)
	@ResponseBody
	public String jump() {
		return this.SUCCESS;
	}
	
	/**
	 * 按照名字执行模糊查询
	 * @param name
	 * @return
	 */
	@RequestMapping(value="dept/{name}",method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getByExp(@PathVariable String name) {
		
		System.out.println("getByExp is do...");
		
		return service.getByExp(name);
	}
}