package cn.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hl.dao.DepartmentDao;
import cn.hl.pojo.Department;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentDao dao;
	
	/**
	 * 添加部门信息
	 * @param dept
	 * @return
	 */
	public int add(Department dept) {
		return dao.add(dept);
	}
	
	/**
	 * 按照ID删除部门信息
	 * @param Id
	 * @return
	 */
	public int delete(int Id) {
		return dao.delete(Id);
	}
	
	/**
	 * 按照Id更新部门信息
	 * @param dept
	 * @return
	 */
	public int update(Department dept) {
		return dao.update(dept);
	}
	
	/**
	 * 按照Id查询部门信息
	 * @param Id
	 * @return
	 */
	public Department getById(int Id) {
		return dao.getById(Id);
	}
	
	/**
	 * 查询所有部门信息
	 * @return
	 */
	public List<Department> getAll(){
		return dao.getAll();
	}
	
	/**
	 * 按照部门名查询部门名称
	 * 	支持模糊查询
	 * @param name
	 * @return
	 */
	public List<Department> getByExp(String name){
		return dao.getByExp("%"+name+"%");
	}
}
