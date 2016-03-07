package com.zqw.bean;

import java.util.Date;



public class OrderGoods {
	private int id;
	private String serialNumber;
	private double sellingPrice;
	private double purchasePrice;
	private double number;
	private String curtainShop;
	private int orderId;
	private int owner;
	private OrderLst order;
	private Date date;
	private String remark;
	

	public OrderGoods(String serialNumber, double sellingPrice,
			double purchasePrice, double number, String curtainShop, int owner,String remark) {
		super();
		this.serialNumber = serialNumber;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.curtainShop = curtainShop;
		this.owner = owner;
		this.remark = remark;
	}
	
	

	public OrderGoods(String serialNumber, double sellingPrice,
			double purchasePrice, double number,Date date) {
		super();
		this.serialNumber = serialNumber;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.date = date;
	}
	
	public OrderGoods(String serialNumber, double sellingPrice,
			double purchasePrice, double number) {
		super();
		this.serialNumber = serialNumber;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
	}

	public OrderGoods(String serialNumber, double sellingPrice,
			double purchasePrice, double number,int orderId) {
		super();
		this.serialNumber = serialNumber;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.orderId = orderId;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderLst getOrder() {
		return order;
	}

	public void setOrder(OrderLst order) {
		this.order = order;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public OrderGoods() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public String getCurtainShop() {
		return curtainShop;
	}

	public void setCurtainShop(String curtainShop) {
		this.curtainShop = curtainShop;
	}
}
