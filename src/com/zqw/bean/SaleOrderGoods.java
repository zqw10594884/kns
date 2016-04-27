package com.zqw.bean;

public class SaleOrderGoods {
	private int id;
	private String serialNumber;
	private double sellingPrice;
	private double purchasePrice;
	private double number;
	private String saleCustomer;
	private int orderId;
	private SaleOrderLst order;
	private String remark;

	public SaleOrderGoods() {
		super();
	}

	public SaleOrderGoods(int id, String serialNumber, double sellingPrice,
			double purchasePrice, double number, String saleCustomer,
			int orderId, SaleOrderLst order, String remark) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.sellingPrice = sellingPrice;
		this.purchasePrice = purchasePrice;
		this.number = number;
		this.saleCustomer = saleCustomer;
		this.orderId = orderId;
		this.order = order;
		this.remark = remark;
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

	public String getSaleCustomer() {
		return saleCustomer;
	}

	public void setSaleCustomer(String saleCustomer) {
		this.saleCustomer = saleCustomer;
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
