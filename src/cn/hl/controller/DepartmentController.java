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
	 * ִ�в�����Ӳ���
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
	 * ִ�в���ɾ������
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
	 * ����Idִ�в����޸Ĳ���
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
	 * ����ID��ѯ������Ϣ
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
	 * ��ѯ���в�����Ϣ
	 * @return
	 */
	@RequestMapping(value="dept",method=RequestMethod.GET)
	@ResponseBody
	public List<Department> getAll(){
		return service.getAll();
	}
	
	/**
	 * ������дҳ����ת
	 * @return
	 */
	@RequestMapping(value="jump",method=RequestMethod.POST)
	@ResponseBody
	public String jump() {
		return this.SUCCESS;
	}
	
	/**
	 * ��������ִ��ģ����ѯ
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