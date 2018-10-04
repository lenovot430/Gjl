package cn.hl.mapper;

import java.util.List;

import cn.hl.pojo.User;

public interface UserMapper {

	//��Ӳ�����Ϣ
	public int add(User user);
	
	//����IDɾ��������Ϣ
	public int delete(int id);
	
	//����Id���Ĳ�����Ϣ
	public int update(User user);
	
	//����Id��ѯ������Ϣ
	public User getById(int id);
	
	//��ѯ���в�����Ϣ
	public List<User> getAll();
	
	//���ղ�������ѯ
	public User getByAccount(String account);
}
