package cn.itheima.domain;

public class User {
    private Integer uid;
    private String uname;
    private String upassword;
	public User() {
		
	}
	/**
	 * @return the uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the upassword
	 */
	public String getUpassword() {
		return upassword;
	}
	/**
	 * @param upassword the upassword to set
	 */
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
    
}
