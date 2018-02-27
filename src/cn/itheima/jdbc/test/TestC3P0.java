package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.itheima.jdbc.utils.C3P0Utils;
import cn.itheima.jdbc.utils.JDBCUtil_V3;

public class TestC3P0 {
	 @Test
	 public void testAddUser1(){
	    	Connection conn=null;
	    	PreparedStatement pst=null;
	    	
	    	try {
	    		//2从连接池获取连接
				conn=C3P0Utils.getConnection();
				String sql="insert into user values(null,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1, "张凡2");
				pst.setString(2, "12121");
				int row = pst.executeUpdate();
				if(row>0){
					System.out.println("添加成功");
				}else{
					System.out.println("失败");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil_V3.release(conn, pst, null);
			}
	    }
	
	 @Test
	 public void testAddUser(){
	    	Connection conn=null;
	    	PreparedStatement pst=null;
	    	//1创建自定义连接池对象
	    	DataSource dataSource=new ComboPooledDataSource();//加载默认配置
	    	/*DataSource dataSource1=new ComboPooledDataSource("itheima");//加载有名的
*/	    	
	    	try {
	    		//2从连接池获取连接
				conn=dataSource.getConnection();
				String sql="insert into user values(null,?,?)";
				pst=conn.prepareStatement(sql);
				pst.setString(1, "张凡2");
				pst.setString(2, "12121");
				int row = pst.executeUpdate();
				if(row>0){
					System.out.println("添加成功");
				}else{
					System.out.println("失败");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				JDBCUtil_V3.release(conn, pst, null);
			}
	    }
}
