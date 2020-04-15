package com.online.shopping.User;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Table(name = "User")
@Embeddable
public class User {
	@Id
	@GeneratedValue
	private int userId = 0;
	
	@NotNull
	@Column(unique = true)
	@NotEmpty
	private String email ;
	@NotNull
	@NotEmpty
	private String password ;
	
	
	
	
	
	/*
	 * private List<UserCart> userList ;
	 * 
	 * public int getUserId() { return userId; }
	 * 
	 * public void setUserId(int userId) { this.userId = userId; }
	 * 
	 * public List<UserCart> getUserList() { return userList; }
	 * 
	 * public void setUserList(List<UserCart> userList) { this.userList = userList;
	 * }
	 * 
	 * public User(int userId, List<UserCart> userList) { super(); this.userId =
	 * userId; this.userList = userList; }
	 */

	
	public int getUserId() {
		return userId;
	}





	public void setUserId(int userId) {
		this.userId = userId;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public User() {
		super();
		
	}





	public User(int userId, @NotNull @NotEmpty String email, @NotNull @NotEmpty String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
	}





	

	
	

}
