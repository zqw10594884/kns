package com.zqw.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SaleOrderLst implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2580071960678810011L;
	private List<SaleOrderGoods> goodsLst;
	private String customerName;
	private String customerTel1;
	private String customerTel2;
	private String customerDeposit;
	private String customerAddress;
	private Date submitTime;
	private int id;

	public SaleOrderLst() {
		super();
	}

	public List<SaleOrderGoods> getGoodsLst() {
		return goodsLst;
	}

	public void setGoodsLst(List<SaleOrderGoods> goodsLst) {
		this.goodsLst = goodsLst;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerTel1() {
		return customerTel1;
	}

	public void setCustomerTel1(String customerTel1) {
		this.customerTel1 = customerTel1;
	}

	public String getCustomerTel2() {
		return customerTel2;
	}

	public void setCustomerTel2(String customerTel2) {
		this.customerTel2 = customerTel2;
	}

	public String getCustomerDeposit() {
		return customerDeposit;
	}

	public void setCustomerDeposit(String customerDeposit) {
		this.customerDeposit = customerDeposit;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSimpleDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(submitTime);
	}

}
