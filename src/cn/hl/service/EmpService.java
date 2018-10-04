package cn.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hl.dao.EmpDao;
import cn.hl.pojo.Emp;

@Service
public class EmpService {

	@Autowired
	private EmpDao dao;
	
	public List<Emp> getAll(){
		return dao.getAll();
	}
}
