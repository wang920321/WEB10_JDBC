package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.itheima.jdbc.DataSource.MyDataSource;

public class TestMyDataSource {
	
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
}
