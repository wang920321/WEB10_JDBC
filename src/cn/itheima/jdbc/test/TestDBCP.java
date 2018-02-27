package cn.itheima.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.itheima.jdbc.utils.DBCPUtils;
import cn.itheima.jdbc.utils.JDBCUtil_V3;

public class TestDBCP {
    @Test
    public void testUpdateById(){
    	Connection conn=null;
    	PreparedStatement pst=null;
    	
    	try {
    		conn=DBCPUtils.getConnection();
        	String sql="update user set upassword=? where uid=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, "999000");
			pst.setInt(2, 5);
			int rows = pst.executeUpdate();
			if(rows>0){
				System.out.println("修改成功");
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
