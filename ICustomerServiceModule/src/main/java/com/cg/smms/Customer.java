package com.cg.smms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	private Integer id;
	private String name;
	private Integer order_id;
	private String phone;
	private String email;


public Customer()
{	
}
public Customer(Integer id,String name,Integer order_id,String phone,String email) {
	this.id= id;
	this.name = name;
	this.order_id = order_id;
	this.phone= phone;
	this.email= email;	
}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "Customer [id=" + id +",name=" + name +",order_id=" + order_id +",phone=" + phone +",email=" + email +"]";
}

}
