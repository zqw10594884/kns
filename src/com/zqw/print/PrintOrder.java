//package com.zqw.print;
//
//import java.awt.BasicStroke;
//import java.awt.Color;
//import java.awt.Component;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Stroke;
//import java.awt.print.PageFormat;
//import java.awt.print.Printable;
//import java.awt.print.PrinterException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import com.zqw.bean.Global;
//import com.zqw.bean.SaleOrderLst;
//import com.zqw.util.DataUtil;
//
//public class PrintOrder implements Printable {
//
//	private SaleOrderLst order;
//	private int parameter;
//
//	public PrintOrder() {
//		super();
//	}
//
//	public PrintOrder(SaleOrderLst order, int parameter) {
//		super();
//		this.order = order;
//		this.parameter = parameter;
//	}
//
//	// xy起点偏移
//	int offSetX = 60;
//	int offSetY = 110;
//	// 行高
//	int rowH = 30;
//	// 每个格子的宽度 所有值的加和= 595 - offSetX*2
//	int[] col = { 155, 45, 45, 55, 175 };
//	int[] TotalCol = { 120, 100, 255 };
//	String[] title = { "品       名", "数量", "单价", "小计", "备   注" };
//
//	/**
//	 * @param Graphic指明打印的图形环境
//	 * @param PageFormat指明打印页格式
//	 *            （页面大小以点为计量单位，1点为1英才的1/72，1英寸为25.4毫米。A4纸大致为595×842点）
//	 * @param pageIndex指明页号
//	 **/
//	public int print(Graphics gra, PageFormat pf, int pageIndex) throws PrinterException {
//		Component c = null;
//		// 转换成Graphics2D
//		Graphics2D g2 = (Graphics2D) gra;
//		// 设置打印颜色为黑色
//		g2.setColor(Color.black);
//
//		// 打印起点坐标
//		int x = (int) pf.getImageableX() + offSetX;
//		int y = (int) pf.getImageableY() + offSetY;
//		// int w = (int) pf.getWidth();
//		int w = 595 - offSetX * 2;
//		int colW = 475 / 4;
//		int h = (int) pf.getHeight();
//
//		switch (pageIndex) {
//		case 0:
//			Font fontTitle = new Font("新宋体", Font.PLAIN, 30);
//			// Font fontTitle1 = new Font("新宋体", Font.PLAIN, 20);
//			Font font = new Font("新宋体", Font.PLAIN, 15);
//			Stroke stroke = new BasicStroke(1.5f);// 设置线宽为3.0
//
//			// 表头
//			g2.setFont(fontTitle);
//			if (parameter == Global.EMPLOYEE) {
//				g2.drawString("发货单", x + 170, y - 50);
//			} else if (parameter == Global.CUSTOMER) {
//				g2.drawString("凯妮丝红日窗帘批发", x + 100, y - 50);
//			} else if (parameter == Global.OWN) {
//				g2.drawString("底单", x + 200, y - 50);
//			}
//			g2.setFont(font);
//			Date nowTime = new Date();
//			SimpleDateFormat time = new SimpleDateFormat("yyyy MM dd ");
//			g2.drawString(time.format(nowTime), x, y - 50);
//			g2.drawString("订单编号：" + order.getId(), x, y - 13);
//			g2.drawString("地址：" , x + 150, y - 13);
//			if (parameter!=Global.EMPLOYEE) {
//				g2.drawString("电话：" , x + 340, y - 13);
//			}
//			// 表格
//			g2.setFont(font);
//			g2.setStroke(stroke);
//			// 表格标题
//			y = drawLine(g2, y, x, w, col, title);
//			double subtotal = 0;
//			double cloth = 0;
//			double lace = 0;
//			double materials = 0;
//
//			List<SaleOrderLst> goodsLst = order.getGoodsLst();
//			for (int j = 0; j < goodsLst.size(); j++) {
//				SaleOrderLst g = goodsLst.get(j);
//				if ("免费样品".equals(g.getRemark())) {
//					// do null;
//				} else {
//					// 总计
//					subtotal += g.getNumber() * g.getSellingPrice();
//					String serialNumber = g.getSerialNumber();
//					// 布，沙，花边成本计算。
//					if (serialNumber.contains("A-") || serialNumber.contains("B-")) {
//						cloth += g.getNumber() * g.getPurchasePrice();
//					} else if (serialNumber.contains("C-花边")) {
//						lace += g.getNumber() * g.getPurchasePrice();
//					} else if (serialNumber.startsWith("C-")) {
//						materials += g.getNumber() * g.getSellingPrice();
//					}
//
//				}
//				// 画行
//				String[] data = null;
//				if (parameter == Global.EMPLOYEE) {
//					String[] temp = { g.getSerialNumber(), g.getNumber() + "", "", "", g.getRemark()};
//					data = temp;
//				} else {
//					String[] temp = { g.getSerialNumber(), g.getNumber() + "", g.getSellingPrice() + "",
//							(int) (g.getNumber() * g.getSellingPrice()) + "", g.getRemark() };
//					data = temp;
//				}
//				y = drawLine(g2, y, x, w, col, data);
//			}
//			String other = "";
//			if (parameter == Global.OWN) {
//				int profit = DataUtil.getProfit(order);
////				if (curtainShop.getOwner() == 0) {
////					other = "利润" + profit + "付" + ((int) cloth + (int) lace) + "辅料成本" + materials;
////				} else {
////					other = "利润" + profit + "辅料成本" + materials;
////				}
//			}
//			String[] Total = null;
//			if (parameter != Global.EMPLOYEE) {
//				String[] temp = { "合计人民币", (int) subtotal + "元整", other };
//				Total = temp;
//			}
//			y = drawLine(g2, y, x, w, TotalCol, Total);
//			g2.drawLine(x, y, x + w, y);
//			y += rowH;
//			g2.drawString("订货电话：" + Global.Tel, x - 10, y - 13);
//			g2.drawString("农行卡：" + Global.ABCcard, x + 170, y - 13);
//			g2.drawString(order.getId() + "", x - 20, 800);
//			y += rowH;
//			g2.drawString("确认货物无误后签字_____________", x + 200, y - 15);
//			return PAGE_EXISTS;
//		default:
//			return NO_SUCH_PAGE;
//		}
//
//	}
//
//	private int drawLine(Graphics2D g2, int y, int x, int w, int[] col, String[] str) {
//		// TODO Auto-generated method stub
//		int tempW = 0;
//		g2.drawLine(x, y, x + w, y);
//		for (int i = 0; i <= col.length; i++) {
//			g2.drawLine(x + tempW, y, x + tempW, y + rowH);
//			if (i < col.length) {
//				if (str != null) {
//					g2.drawString(str[i], x + tempW + 5, y + rowH - 5);
//				}
//				tempW += col[i];
//			}
//		}
//		return y += rowH;
//	}
//}
