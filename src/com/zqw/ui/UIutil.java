package com.zqw.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import com.zqw.bean.CurtainShopGoods;
import com.zqw.util.DBUtil;

public class UIutil {

	static String hqlCurtainShop_All = "select new CurtainShop(cs.id,cs.name,cs.telephone,cs.address,cs.owner) from CurtainShop cs order by convert(name, 'gbk')";
	static String hqlCurtainShop_From_Name = "select new CurtainShop(cs.id,cs.name,cs.telephone,cs.address,cs.owner) from CurtainShop cs where name = :name0";
	static String hqlCurtainShop_From_Name_Have_Arrears = "select new OrderLst(g.arrears,g.curtainShop,g.date,g.id,g.orderState) from OrderLst g where  orderState = :name0";
	static String hqlCurtainShopOrderLst_From_Name = "select new OrderLst(g.arrears,g.curtainShop,g.date,g.id,g.orderState) from OrderLst g where curtainShop = :name";
	static String hqlCurtainShopGoods_From_Name = "select new CurtainShopGoods(g.id,g.serialNumber,g.sellingPrice,g.curtainShop,g.remarks) from CurtainShopGoods g where curtainShop = :name order by serialNumber";
	static String hqlGoods_From_Name = "select new Goods(g.id,g.serialNumber,g.purchasePrice,g.factory,g.telephone,g.bankCard,g.remark) from Goods g where serialNumber = :name0";
	static String hqlOrderLst_Max = "select max(id) from OrderLst";
	static String hqlOrderGoods_From_CurtainShopName = "select new OrderGoods(g.serialNumber,g.sellingPrice,g.purchasePrice,g.number,g.date) from OrderGoods g where curtainShop = :name order by serialNumber";
	static String hqlOrderGoods_From_OrderId = "select new OrderGoods(g.serialNumber,g.sellingPrice,g.purchasePrice,g.number) from OrderGoods g where orderId = :name";
	static String sqlDel_ordergoods_is_null = "DELETE  FROM  _ordergoods  WHERE  Order_id is null";

	public static void initCurtainShopGoodsLstFromName(
			ListSelectionListener mainWi, JList<String> goodsjList,
			List<CurtainShopGoods> goodsLst) {
		ArrayList<String> item = new ArrayList<String>();
		for (int i = 0; i < goodsLst.size(); i++) {
			item.add(goodsLst.get(i).getSerialNumber());
			System.out.println(goodsLst.get(i).getSerialNumber());
		}
		initJlist(mainWi, goodsjList, item);
	}

	public static void initJlist(ListSelectionListener UI, JList<String> jList,
			ArrayList<String> item) {
		DefaultListModel<String> lm = new DefaultListModel<String>();
		for (int i = 0; i < item.size(); i++) {
			lm.addElement(item.get(i));
		}
		jList.setModel(lm);
		jList.removeListSelectionListener(UI);
		jList.addListSelectionListener(UI);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	public static void delFromCurtainShopGoods() {
		DBUtil.delBySql(sqlDel_ordergoods_is_null);
	}

	public static int getMaxIdFromOrderLst() {
		return (Integer) DBUtil.get(hqlOrderLst_Max, "", "") + 1;
	}

}
