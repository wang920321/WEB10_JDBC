package cn.itheima.jdbc.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
    private static DataSource dataSource;
    static{
    	try {
    		//1加载找到properties文件
        	InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
        	//2加载输入流
        	Properties props=new Properties();
        	props.load(is);
        	//3创建数据源
			dataSource=BasicDataSourceFactory.createDataSource(props);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static DataSource getDataSource(){
    	return dataSource;
    }
    public static Connection getConnection(){
    	try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
}
