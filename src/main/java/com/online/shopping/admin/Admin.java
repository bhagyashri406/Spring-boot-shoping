package com.online.shopping.admin;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.swagger.annotations.ApiModel;


@ApiModel(description = "all details about Admin")
@Entity
@Embeddable
@Table(name = "Admin")
public class Admin {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@Column(unique = true)
	@Email
	private String email ;

	@NotNull
	@Size(min = 8)
	private String password ;
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	/*
	 * public String getPassword() { return password; }
	 */


	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {	
		
	}

	public Admin(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Admin [id=" + id + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	

}
