package cn.itheima.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.itheima.jdbc.utils.C3P0Utils;

/**
 * @author Administrator
 *
 */
public class TestDBUtils {
	 /**
     * 删除用户方法
     */
    @Test
    public void testDeleteUserById(){
    	
    	try {
    		//1创建核心类QueryRunner
        	QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        	//2编写sql语句
        	String sql="delete from user where uid=?";
        	//为占位符设置值
        	Object[] params={13};
        	//4执行添加操作
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	 /**
     * 修改用户方法
     */
    @Test
    public void testUpdateUserById(){
    	
    	try {
    		//1创建核心类QueryRunner
        	QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        	//2编写sql语句
        	String sql="update user set upassword=? where uid=?";
        	//为占位符设置值
        	Object[] params={"cccc",3};
        	//4执行添加操作
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("修改成功");
			}else{
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /**
     * 添加用户方法
     */
    @Test
    public void testAddUser(){
    	
    	try {
    		//1创建核心类QueryRunner
        	QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        	//2编写sql语句
        	String sql="insert into user values(null,?,?)";
        	//为占位符设置值
        	Object[] params={"cccc","bbbb"};
        	//4执行添加操作
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
