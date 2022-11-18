package com.bora.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class AndroidBoardDAO {
	public AndroidBoardDAO() {
		try {
			
			String dbURL = "jdbc:log4jdbc:mysql://itwillbs8.cafe24.com:3306/itwillbs8";
			String dbID = "itwillbs8";
			String dbPW = "itwillbs8030909";
//			Connection conn = Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버??
//			conn = DriverManager.getConnection(dbURL, dbID, dbPW);
			
			// 디비 연결정보
//			String DRIVER = "com.mysql.cj.jdbc.Driver";
//			String DBURL = "jdbc:mysql://localhost:3306/jspdb";
//			String DBID = "root";
//			String DBPW = "1234";
//			
//			// 1. 드라이버로드
//			Class.forName(DRIVER);
//			System.out.println(" 드라이버로드 성공 ");
//			// 2. 디비연결
//			con = DriverManager.getConnection(DBURL, DBID, DBPW);
//			System.out.println(" 디비연결 성공 ");
//			System.out.println(" con : " + con);
//			
//			return con;
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 생성자
	
	
}
