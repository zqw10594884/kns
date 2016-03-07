package com.zqw.bean;

import java.util.Date;

public class PurchaseOrder {
	private int id;
	private String serialNumber;
	private double purchasePrice;
	private double number;
	private Date date;
	private int state;
	
	
	public PurchaseOrder(int id, String serialNumber, double purchasePrice,
			double number, Date date, int state) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.date = date;
		this.state = state;
	}
	public PurchaseOrder( String serialNumber, double purchasePrice,
			double number, Date date, int state) {
		super();
		this.serialNumber = serialNumber;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.date = date;
		this.state = state;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
