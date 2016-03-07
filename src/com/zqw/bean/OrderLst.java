package com.zqw.bean;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderLst {
	private List<OrderGoods> goodsLst;
	private String curtainShop;
	private String untreatedPerson;
	private Date date;
	private Date submitTime;
	private int id;
	private int arrears;
	private int orderState;

	public OrderLst() {
		super();
	}

	public OrderLst(int arrears, String curtainShop, Date date, int id, int orderState) {
		super();
		this.curtainShop = curtainShop;
		this.date = date;
		this.id = id;
		this.arrears = arrears;
		this.orderState = orderState;
	}



	public String getUntreatedPerson() {
		return untreatedPerson;
	}

	public void setUntreatedPerson(String untreatedPerson) {
		this.untreatedPerson = untreatedPerson;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public int getOrderState() {
		return orderState;
	}

	/**
	 * 
	 * @param printState
	 *            0 完成 1出库 2备货中 3提交
	 */
	public void setOrderState(int printState) {
		this.orderState = printState;
	}

	public int getArrears() {
		return arrears;
	}

	public void setArrears(int arrears) {
		this.arrears = arrears;
	}

	public String getCurtainShop() {
		return curtainShop;
	}

	public void setCurtainShop(String curtainShop) {
		this.curtainShop = curtainShop;
	}

	public Date getDate() {
		return date;
	}

	public String getSimpleDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderGoods> getGoodsLst() {
		return goodsLst;
	}

	public void setGoodsLst(List<OrderGoods> goodsLst) {
		this.goodsLst = goodsLst;
	}

	public String getOrderStateToString() {
		String state = "";
		if (0 == orderState) {
			// do nothing
		} else if (1 == orderState) {
			state = "出库";
		} else if (2 == orderState) {
			state = "备货中";
		} else if (3 == orderState) {
			state = "提交";
		}
		return state;
	}
}
