package cn.hl.mapper;

import java.util.List;

import cn.hl.pojo.Department;

public interface DepartmentMapper {

	//添加部门信息
	public int add(Department dept);
	
	//按照ID删除部门信息
	public int delete(int Id);
	
	//按照Id更改部门信息
	public int update(Department dept);
	
	//按照Id查询部门信息
	public Department getById(int Id);
	
	//查询所有部门信息
	public List<Department> getAll();
	
	//按照部门名查询
	public List<Department> getByExp(String name);
}
