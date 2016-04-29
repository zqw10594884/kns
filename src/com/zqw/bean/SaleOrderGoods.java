package com.zqw.bean;

import java.io.Serializable;

public class SaleOrderGoods implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9090137554867652787L;
	private int id;
	private String serialNumber;
	private double sellingPrice;
	private double purchasePrice;
	private double number;
	private int orderId;
	private SaleOrderLst order;
	private String remark;

	public SaleOrderGoods() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public SaleOrderLst getOrder() {
		return order;
	}

	public void setOrder(SaleOrderLst order) {
		this.order = order;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
