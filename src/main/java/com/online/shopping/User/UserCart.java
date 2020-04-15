package com.online.shopping.User;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "all details about UserCart")
@Entity
@Table(name = "User_Cart")
@Embeddable
public class UserCart {
	
	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	@NotEmpty
	private int userId;
	
	@NotNull
	@NotEmpty
	private int productId;
	
	
	private int productCount = 1 ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public UserCart(int userId, int productId, int productCount) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.productCount = productCount;
	}
	
	public UserCart() {
		super();
	}

}
