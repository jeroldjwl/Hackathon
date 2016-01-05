package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gacl
 * 用户实体�?
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4313782718477229465L;
	
	// 用户ID
	private String id;
	// 用户�?
	private String userName;
	// 用户密码
	private String userPwd;
	// 用户邮箱
	private String email;
	// 用户生日
	private Date birthday;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
