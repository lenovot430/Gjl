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
	 * ��Ӳ�����Ϣ
	 * @param dept
	 * @return
	 */
	public int add(Department dept) {
		return dao.add(dept);
	}
	
	/**
	 * ����IDɾ��������Ϣ
	 * @param Id
	 * @return
	 */
	public int delete(int Id) {
		return dao.delete(Id);
	}
	
	/**
	 * ����Id���²�����Ϣ
	 * @param dept
	 * @return
	 */
	public int update(Department dept) {
		return dao.update(dept);
	}
	
	/**
	 * ����Id��ѯ������Ϣ
	 * @param Id
	 * @return
	 */
	public Department getById(int Id) {
		return dao.getById(Id);
	}
	
	/**
	 * ��ѯ���в�����Ϣ
	 * @return
	 */
	public List<Department> getAll(){
		return dao.getAll();
	}
	
	/**
	 * ���ղ�������ѯ��������
	 * 	֧��ģ����ѯ
	 * @param name
	 * @return
	 */
	public List<Department> getByExp(String name){
		return dao.getByExp("%"+name+"%");
	}
}
