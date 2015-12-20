package com.util.db;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCUtil {
	private JDBCUtil(){}//��ֹ���⹹��
	private static ResourceBundle rb= ResourceBundle.getBundle("com/util/db/jdbc");
	private static String URL= null;
	private static String USER= null;
	private static String PASSWORD= null;
	private static String DRIVER= null;
	static {//�����پ�̬���ﹹ�쾲̬��������÷��ڿ���
		URL= rb.getString("jdbc.url");
		USER= rb.getString("jdbc.user");
		PASSWORD= rb.getString("jdbc.password");
		DRIVER= rb.getString("jdbc.driver");
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()//�������ӷ���,��Ϊÿһ�����ݶ���Ҫ�õ�һ�����ӣ�������Ҫ����ֵ
	{
		Connection conn= null;//�˴���Ϊ���ܺͳ�������ʧ�ܵ����������ʹ��conn��Ϊ�գ����Ϊ�˷�ֹ�����쳣������Ĭ��ֵnull
		try {
			conn= DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("����ʧ��");
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs, Statement st,Connection conn)
	{
			try {
			if(rs!= null)	rs.close();
			if(st!= null)	st.close(); 
			if(conn!= null)   conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
