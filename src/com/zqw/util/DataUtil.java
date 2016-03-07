package com.zqw.util;

import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import com.zqw.bean.OrderGoods;
import com.zqw.bean.OrderLst;

public class DataUtil {
	public static int getProfit(OrderLst order){
		return getProfit(order.getGoodsLst());
	}
	public static int getProfit(List<OrderGoods> lst) {
		double total = 0;
		for (int i = 0; i < lst.size(); i++) {
			OrderGoods g = lst.get(i);
			if ("免费样品".equals(g.getRemark())) {
				// do null;
			} else {
				total += ((g.getSellingPrice() - g.getPurchasePrice()) * g
						.getNumber());
			}
		}
		return (int) total;
	}
	public static int getTotal(OrderLst order){
		return getTotal(order.getGoodsLst());
	}
	public static int getTotal(List<OrderGoods> lst) {
		double total = 0;
		for (int i = 0; i < lst.size(); i++) {
			OrderGoods g = lst.get(i);
			if ("免费样品".equals(g.getRemark())) {
				// do null;
			} else {
				total += (g.getSellingPrice() * g.getNumber());
			}
		}
		return (int) total;
	}

	public static double getFlowersCol(double distance, String flag,
			double number) {
		number /= 2;
		int a = (int) (number / distance);
		double b = number - a * distance;
		double result = 0;
		if (b == 0) {
			result = a * distance;
		} else if (flag.equals("less")) {
			result = a * distance;
		} else if (flag.equals("auto")) {
			if ((distance - 2 * b) < 0) {
				result = a * (distance + 1);
			} else {
				result = a * distance;
			}
		} else if (flag.equals("more")) {
			result = a * (distance + 1);
		}
		return result * 2;
	}

	public static String getSelectRa(ButtonGroup buttonGroup1) {
		Enumeration<AbstractButton> enu = buttonGroup1.getElements();
		String result = null;
		while (enu.hasMoreElements()) {
			AbstractButton radioButton = enu.nextElement();
			if (radioButton.isSelected()) {
				result = radioButton.getName();
			}
		}
		return result;
	}

	public static String formatDouble(double d) {
		DecimalFormat df = new DecimalFormat(".00");
		return df.format(d);
	}
}
