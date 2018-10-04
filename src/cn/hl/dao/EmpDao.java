package cn.hl.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hl.mapper.EmpMapper;
import cn.hl.pojo.Emp;

@Repository
public class EmpDao {

	@Autowired
	private EmpMapper mapper;
	
	public List<Emp> getAll(){
		return mapper.getAll();
	}
}
