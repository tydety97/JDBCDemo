package com.cn.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddUser {
	
	public void add(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			conn = JDBC_Connection.getConnection();
			String sql = "insert into users(id,name,age,tel,address) values(?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, userVo.getId());
			pstm.setString(2, userVo.getName());
			pstm.setInt(3, userVo.getAge());
			pstm.setString(4, userVo.getTel());
			pstm.setString(5, userVo.getAddress());
			
			pstm.executeUpdate();
			System.out.println("添加成功！添加的内容如下：");
			System.out.println("id:" + userVo.getId() + "\t name:" + userVo.getName() + "\t age:" + userVo.getAge() + "\t tel:" + userVo.getTel() + "\t address:" + userVo.getAddress());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_Connection.free(rs, conn, pstm);
		}
	}

	public static void main(String[] args) {
		AddUser addUser = new AddUser();
		UserVo userVo = new UserVo();
		int id = 2;
		String name = "战三";
		int age = 22;
		String tel = "456124456";
		String address = "中国";
		
		userVo.setId(id);
		userVo.setName(name);
		userVo.setAge(age);
		userVo.setTel(tel);
		userVo.setAddress(address);
		
		addUser.add(userVo);
	}

}
