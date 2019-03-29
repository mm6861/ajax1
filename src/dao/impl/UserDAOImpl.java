package dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dao.UserDAO;
import db.DBCon;

public class UserDAOImpl implements UserDAO{
	private String sql = "insert into user_info(ui_num,ui_name,ui_id,ui_pwd,ui_email)"
			+ " values(seq_ui_num.nextval,?,?,?,?)";
	@Override
	public int insertUser(Map<String, String> user) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(sql);
			ps.setString(1, user.get("uiName"));
			ps.setString(2, user.get("uiId"));
			ps.setString(3, user.get("uiPwd"));
			ps.setString(4, user.get("uiEmail"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}
	
	public static void main(String[] args) {
		UserDAO ud = new UserDAOImpl();
		Map<String,String> user = new HashMap<>();
		user.put("uiName","uiName");
		user.put("uiId","uiName");
		user.put("uiPwd","uiPwd");
		user.put("uiEmail","uiEmail");
		System.out.println(ud.insertUser(user));
	}
	

}
