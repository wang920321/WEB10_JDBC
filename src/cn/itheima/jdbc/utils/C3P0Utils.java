package cn.itheima.jdbc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
    private static DataSource dataSource=new ComboPooledDataSource("itheima");
    public static DataSource getDataSource(){
    	return dataSource;
    }
    public static Connection getConnection(){
    	try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
    }
}
