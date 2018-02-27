package cn.itheima.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.itheima.domain.User;
import cn.itheima.jdbc.utils.C3P0Utils;

/**
 * 测试DBUtils查询操作
 * @author Administrator
 *
 */
public class TestDBUtils2 {
	
	/**
	 * 查询所有
	 */
	@Test
	public void testQueryAll(){
		
		try {
			//1获取核心类queryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2编写sql
			String sql="select * from user";
			//3执行查询操作
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class));
			//4对结果集集合遍历
			for (User user : users) {
				System.out.println(user.getUname()+" : "+user.getUpassword());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	@Test
	public void testQueryUserById(){
		
		try {
			//1获取核心类queryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2编写sql
			String sql="select * from user where uid=?";
			//3为占位符设置值
			Object[] params={9};
			//4执行查询操作
			User user=qr.query(sql, new BeanHandler<User>(User.class), params);
			
				System.out.println(user.getUname()+" : "+user.getUpassword());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 */
	@Test
	public void testQueryUserCount(){
		
		try {
			//1获取核心类queryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2编写sql
			String sql="select count(*) from user ";
			
			//4执行查询操作
			Long count= (Long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testQueryAll1(){
		
		try {
			//1获取核心类queryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2编写sql
			String sql="select * from user";
			//3执行查询操作
			List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
			//4对结果集集合遍历
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testQueryAll2(){
		
		try {
			//1获取核心类queryRunner
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			//2编写sql
			String sql="select * from user";
			//3执行查询操作
			List<Object> list = qr.query(sql, new ColumnListHandler("uname"));
			//4对结果集集合遍历
			for (Object object : list) {
				System.out.println(object);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
