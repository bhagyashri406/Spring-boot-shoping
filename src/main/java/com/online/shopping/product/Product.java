package com.online.shopping.product;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import io.swagger.annotations.ApiModel;

@ApiModel(description = "all details about Product")
@Entity
@Embeddable
@Table(name = "Product")
public class Product {
	

	@Id
	@GeneratedValue
	private int product_id;
	
	@Size(min = 2)
	@NotNull
	@NotEmpty
	public String product_name ;
	@NotNull
	@NotEmpty
	private String product_code ;
	@NotEmpty
	@NotNull
	public double product_price ;
	
	private String product_discription ;
	
	private double product_weight ;
	
	private int admin_id = 0 ;
	
	
	
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public String getProduct_discription() {
		return product_discription;
	}
	public void setProduct_discription(String product_discription) {
		this.product_discription = product_discription;
	}
	public double getProduct_weight() {
		return product_weight;
	}
	public void setProduct_weight(double product_weight) {
		this.product_weight = product_weight;
	}



	
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public  String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	
	public Product() {
		super();
	}
	
	
	public Product(String product_name, String product_code, double product_price, String product_discription,
			double product_weight) {
		super();
		this.product_name = product_name;
		this.product_code = product_code;
		this.product_price = product_price;
		this.product_discription = product_discription;
		this.product_weight = product_weight;
	}
	public Product(String product_name, String product_code, double product_price, String product_discription,
			double product_weight, int admin_id) {
		super();
		this.product_name = product_name;
		this.product_code = product_code;
		this.product_price = product_price;
		this.product_discription = product_discription;
		this.product_weight = product_weight;
		this.admin_id = admin_id;
		
	}
	public Product(int product_id ,int admin_id) {
		super();
		this.product_id = product_id;
		this.admin_id = admin_id;
	}
	
	

}
