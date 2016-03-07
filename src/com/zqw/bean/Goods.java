package com.zqw.bean;

public class Goods {
	private int id;
	private String serialNumber;
	private double purchasePrice;
	private String distance;
	private String factory;
	private String telephone;
	private String bankCard;
	private String remark;

	public Goods(int id, String serialNumber, double purchasePrice,
			String factory, String telephone, String bankCard,String remark) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
		this.purchasePrice = purchasePrice;
		this.factory = factory;
		this.telephone = telephone;
		this.bankCard = bankCard;
		this.remark = remark;
	}

	public Goods(String serialNumber, double purchasePrice, String factory,
			String telephone, String distance) {
		super();
		this.serialNumber = serialNumber;
		this.purchasePrice = purchasePrice;
		this.factory = factory;
		this.telephone = telephone;
		this.distance = distance;
	}


	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getBankCard() {
		return bankCard;
	}

	public void setBankCard(String bankCard) {
		this.bankCard = bankCard;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public Goods() {
	};

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

}
