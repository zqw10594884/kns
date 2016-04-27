package com.zqw.bean;

import java.util.Date;
import java.util.List;

public class SaleOrderLst {
	private List<SaleOrderGoods> goodsLst;
	private String saleCustomer;
	private String untreatedPerson;
	private Date date;
	private Date submitTime;
	private int orderState;
	private int id;
	private int arrears;
	
	public SaleOrderLst() {
		super();
	}
	
	
	public SaleOrderLst(List<SaleOrderGoods> goodsLst, String saleCustomer,
			String untreatedPerson, Date date, Date submitTime, int id,
			int arrears, int orderState) {
		super();
		this.goodsLst = goodsLst;
		this.saleCustomer = saleCustomer;
		this.untreatedPerson = untreatedPerson;
		this.date = date;
		this.submitTime = submitTime;
		this.id = id;
		this.arrears = arrears;
		this.orderState = orderState;
	}


	public List<SaleOrderGoods> getGoodsLst() {
		return goodsLst;
	}
	public void setGoodsLst(List<SaleOrderGoods> goodsLst) {
		this.goodsLst = goodsLst;
	}
	public String getSaleCustomer() {
		return saleCustomer;
	}
	public void setSaleCustomer(String saleCustomer) {
		this.saleCustomer = saleCustomer;
	}
	public String getUntreatedPerson() {
		return untreatedPerson;
	}
	public void setUntreatedPerson(String untreatedPerson) {
		this.untreatedPerson = untreatedPerson;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public int getArrears() {
		return arrears;
	}
	public void setArrears(int arrears) {
		this.arrears = arrears;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

}
