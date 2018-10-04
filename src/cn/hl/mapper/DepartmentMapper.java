package cn.hl.mapper;

import java.util.List;

import cn.hl.pojo.Department;

public interface DepartmentMapper {

	//��Ӳ�����Ϣ
	public int add(Department dept);
	
	//����IDɾ��������Ϣ
	public int delete(int Id);
	
	//����Id���Ĳ�����Ϣ
	public int update(Department dept);
	
	//����Id��ѯ������Ϣ
	public Department getById(int Id);
	
	//��ѯ���в�����Ϣ
	public List<Department> getAll();
	
	//���ղ�������ѯ
	public List<Department> getByExp(String name);
}
