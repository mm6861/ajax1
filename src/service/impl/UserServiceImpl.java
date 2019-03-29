package service.impl;

import java.util.HashMap;
import java.util.Map;

import dao.UserDAO;
import dao.impl.UserDAOImpl;
import service.UserService;


public class UserServiceImpl implements UserService{
	private UserDAO udao = new UserDAOImpl(); 
	@Override
	public int insertUser(Map<String, String> user) {
		return udao.insertUser(user);
	}
	public static void main(String[] args) {
		UserService us = new UserServiceImpl();
		Map<String,String> user = new HashMap<>();
		user.put("uiName","uiName");
		user.put("uiId","uiName");
		user.put("uiPwd","uiPwd");
		user.put("uiEmail","uiEmail");
		System.out.println(us.insertUser(user));
	}

}
