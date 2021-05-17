package com.ndtdat;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="Order")
@Table(name = "order_dtb")
public class Order implements Serializable {
	private static final long serialVersionUID = -297553281792804396L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Mapping thông tin biến với tên cột trong Database
	@Column(name = "customerid")
	private Integer customerid;
	@Column(name = "ordername")
	private String ordername;

	/**
	 * 
	 */
	public Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param customerId
	 * @param orderName
	 */
	public Order(Integer customerId, String orderName) {
		this.customerid = customerid;
		this.ordername = ordername;
	}

	public Long getId() {
		return id;
	}

	public Integer getCustomerId() {
		return customerid;
	}

	public void setCustomerId(Integer customerId) {
		this.customerid = customerid;
	}

	public String getOrderName() {
		return ordername;
	}

	public void setOrderName(String orderName) {
		this.ordername = ordername;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}