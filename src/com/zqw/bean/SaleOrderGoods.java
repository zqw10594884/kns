package com.zqw.bean;

import java.io.Serializable;

public class SaleOrderGoods implements Serializable {
	/**
	 * 
	 */
	private int id;

	private String clothSerialNumber;
	private double clothSellingPrice;
	private double clothNumber;
	private String clothRemark;

	private String curtainTapeSerialNumber;
	private double curtainTapeSellingPrice;
	private double curtainTapeNumber;
	private String curtainTapeRemark;

	private String curtainLaceSerialNumber;
	private double curtainLaceSellingPrice;
	private double curtainLaceNumber;
	private String curtainLaceRemark;

	private String curtainRingSerialNumber;
	private double curtainRingSellingPrice;
	private double curtainRingNumber;
	private String curtainRingRemark;

	private String curtainRodSerialNumber;
	private double curtainRodSellingPrice;
	private double curtainRodNumber;
	private String curtainRodRemark;

	private int orderId;
	private String curtainHight;
	private String curtainWidth;
	private String location;
	private String hightLocation;
	private String curtainStyle;
	private SaleOrderLst order;

	public SaleOrderGoods() {
		super();
	}

	public SaleOrderGoods(String curtainHight, String curtainWidth,
			String location, String hightLocation, String curtainStyle) {
		super();
		this.curtainHight = curtainHight;
		this.curtainWidth = curtainWidth;
		this.location = location;
		this.hightLocation = hightLocation;
		this.curtainStyle = curtainStyle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClothSerialNumber() {
		return clothSerialNumber;
	}

	public void setClothSerialNumber(String clothSerialNumber) {
		this.clothSerialNumber = clothSerialNumber;
	}

	public double getClothSellingPrice() {
		return clothSellingPrice;
	}

	public void setClothSellingPrice(double clothSellingPrice) {
		this.clothSellingPrice = clothSellingPrice;
	}

	public double getClothNumber() {
		return clothNumber;
	}

	public void setClothNumber(double clothNumber) {
		this.clothNumber = clothNumber;
	}

	public String getClothRemark() {
		return clothRemark;
	}

	public void setClothRemark(String clothRemark) {
		this.clothRemark = clothRemark;
	}

	public String getCurtainTapeSerialNumber() {
		return curtainTapeSerialNumber;
	}

	public void setCurtainTapeSerialNumber(String curtainTapeSerialNumber) {
		this.curtainTapeSerialNumber = curtainTapeSerialNumber;
	}

	public double getCurtainTapeSellingPrice() {
		return curtainTapeSellingPrice;
	}

	public void setCurtainTapeSellingPrice(double curtainTapeSellingPrice) {
		this.curtainTapeSellingPrice = curtainTapeSellingPrice;
	}

	public double getCurtainTapeNumber() {
		return curtainTapeNumber;
	}

	public void setCurtainTapeNumber(double curtainTapeNumber) {
		this.curtainTapeNumber = curtainTapeNumber;
	}

	public String getCurtainTapeRemark() {
		return curtainTapeRemark;
	}

	public void setCurtainTapeRemark(String curtainTapeRemark) {
		this.curtainTapeRemark = curtainTapeRemark;
	}

	public String getCurtainLaceSerialNumber() {
		return curtainLaceSerialNumber;
	}

	public void setCurtainLaceSerialNumber(String curtainLaceSerialNumber) {
		this.curtainLaceSerialNumber = curtainLaceSerialNumber;
	}

	public double getCurtainLaceSellingPrice() {
		return curtainLaceSellingPrice;
	}

	public void setCurtainLaceSellingPrice(double curtainLaceSellingPrice) {
		this.curtainLaceSellingPrice = curtainLaceSellingPrice;
	}

	public double getCurtainLaceNumber() {
		return curtainLaceNumber;
	}

	public void setCurtainLaceNumber(double curtainLaceNumber) {
		this.curtainLaceNumber = curtainLaceNumber;
	}

	public String getCurtainLaceRemark() {
		return curtainLaceRemark;
	}

	public void setCurtainLaceRemark(String curtainLaceRemark) {
		this.curtainLaceRemark = curtainLaceRemark;
	}

	public String getCurtainRingSerialNumber() {
		return curtainRingSerialNumber;
	}

	public void setCurtainRingSerialNumber(String curtainRingSerialNumber) {
		this.curtainRingSerialNumber = curtainRingSerialNumber;
	}

	public double getCurtainRingSellingPrice() {
		return curtainRingSellingPrice;
	}

	public void setCurtainRingSellingPrice(double curtainRingSellingPrice) {
		this.curtainRingSellingPrice = curtainRingSellingPrice;
	}

	public double getCurtainRingNumber() {
		return curtainRingNumber;
	}

	public void setCurtainRingNumber(double curtainRingNumber) {
		this.curtainRingNumber = curtainRingNumber;
	}

	public String getCurtainRingRemark() {
		return curtainRingRemark;
	}

	public void setCurtainRingRemark(String curtainRingRemark) {
		this.curtainRingRemark = curtainRingRemark;
	}

	public String getCurtainRodSerialNumber() {
		return curtainRodSerialNumber;
	}

	public void setCurtainRodSerialNumber(String curtainRodSerialNumber) {
		this.curtainRodSerialNumber = curtainRodSerialNumber;
	}

	public double getCurtainRodSellingPrice() {
		return curtainRodSellingPrice;
	}

	public void setCurtainRodSellingPrice(double curtainRodSellingPrice) {
		this.curtainRodSellingPrice = curtainRodSellingPrice;
	}

	public double getCurtainRodNumber() {
		return curtainRodNumber;
	}

	public void setCurtainRodNumber(double curtainRodNumber) {
		this.curtainRodNumber = curtainRodNumber;
	}

	public String getCurtainRodRemark() {
		return curtainRodRemark;
	}

	public void setCurtainRodRemark(String curtainRodRemark) {
		this.curtainRodRemark = curtainRodRemark;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCurtainHight() {
		return curtainHight;
	}

	public void setCurtainHight(String curtainHight) {
		this.curtainHight = curtainHight;
	}

	public String getCurtainWidth() {
		return curtainWidth;
	}

	public void setCurtainWidth(String curtainWidth) {
		this.curtainWidth = curtainWidth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHightLocation() {
		return hightLocation;
	}

	public void setHightLocation(String hightLocation) {
		this.hightLocation = hightLocation;
	}

	public String getCurtainStyle() {
		return curtainStyle;
	}

	public void setCurtainStyle(String curtainStyle) {
		this.curtainStyle = curtainStyle;
	}

	public SaleOrderLst getOrder() {
		return order;
	}

	public void setOrder(SaleOrderLst order) {
		this.order = order;
	}

}
