package cn.hl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hl.dao.UserDao;
import cn.hl.exception.MeetException;
import cn.hl.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public int add(User user) {
		return dao.add(user);
	}
	
	/**
	 * ����Idɾ���û���Ϣ
	 * @param id
	 * @return
	 */
	public int delete (int id) {
		return dao.delete(id);
	}
	
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	public int update(User user) {
		return dao.update(user);
	}
	
	/**
	 * ����Id��ѯָ���û���Ϣ
	 * @param id
	 * @return
	 */
	public User getById(int id) {
		return dao.getById(id);
	}
	
	/**
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	public List<User> getAll(){
		return dao.getAll();
	}
	
	/**
	 * �������ֲ�ѯ�û���Ϣ��ִ�е�½
	 * @param name
	 * @return
	 */
	public User getByAccount(String account,String pwd){
		User user=dao.getByAccount(account);
		
		//�ж��˺��Ƿ����
		if(user==null) {
			return null;
		}else {
			//�ж������Ƿ���ȷ
			if(user.getPwd().equals(pwd)) {
				//�ж��˺�״̬�Ƿ�Ϊ1
				if(user.getState()!=1) {
					throw new MeetException("�˺��Ѿ�������");
				}else {
					return user;	
				}
			}else {
				return null;
			}
		}
	}
}
