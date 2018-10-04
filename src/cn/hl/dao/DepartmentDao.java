package cn.hl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hl.mapper.DepartmentMapper;
import cn.hl.pojo.Department;

@Repository
public class DepartmentDao {

	@Autowired
	private DepartmentMapper mapper;
	
	public int add(Department dept) {
		return mapper.add(dept);
	}
	
	public int delete(int Id) {
		return mapper.delete(Id);
	}
	
	public int update(Department dept) {
		return mapper.update(dept);
	}
	
	public Department getById(int Id) {
		return mapper.getById(Id);
	}
	
	public List<Department> getAll(){
		return mapper.getAll();
	}
	
	public List<Department> getByExp(String name){
		return mapper.getByExp(name);
	}
}
