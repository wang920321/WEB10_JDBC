package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import cn.itheima.jdbc.DataSource.MyDataSource;
import cn.itheima.jdbc.DataSource.MyDataSource1;
import cn.itheima.jdbc.utils.JDBCUtil_V3;

public class TestMyDataSource {
	
    /**
     * 添加用户
     * 使用未改造过的Connection
     */
    @Test
    public void testAddUser(){
    	Connection conn=null;
    	PreparedStatement pst=null;
    	//1创建自定义连接池对象
    	MyDataSource dataSource=new MyDataSource();
    	try {
    		//2从连接池获取连接
			conn=dataSource.getConnection();
			String sql="insert into user values(null,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "张凡");
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
			dataSource.backConnection(conn);
		}
    }
    /**
     * 添加用户
     * 使用造过的Connection
     */
    @Test
    public void testAddUser1(){
    	Connection conn=null;
    	PreparedStatement pst=null;
    	//1创建自定义连接池对象
    	DataSource dataSource=new MyDataSource1();
    	try {
    		//2从连接池获取连接
			conn=dataSource.getConnection();
			String sql="insert into user values(null,?,?)";
			//3必须在自定义的MyConnection类中重写preparStatement(sql)方法
			pst=conn.prepareStatement(sql);
			pst.setString(1, "张凡1");
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
