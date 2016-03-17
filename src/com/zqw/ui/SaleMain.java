package com.zqw.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.zqw.bean.CurtainShopGoods;
import com.zqw.util.DBUtil;

public class SaleMain extends JFrame implements ListSelectionListener{

	private JPanel contentPane;
	private JTextField clothName;
	private JTextField clothPrice;
	private JTable saleTable;
	private JTextField customerName;
	private JTextField customerTel1;
	private JTextField customerTel2;
	private JTextField customerAdr;
	private JTextField customerDeposit;
	private JTextField curtainLocation;
	private JTextField curtainRingPrice;
	private JTextField clothRemark;
	private JTextField curtainRingRemark;
	private JTextField curtainRodPrice;
	private JTextField curtainRodRemark;
	private JTextField curtainRingName;
	private List<CurtainShopGoods> goodsLst;
	private JList saleGoodjList;
	private JList saleLatelyjList;
	private JButton addCustomerBtn;
	private JComboBox curtainRodName;
	private JButton addCurtainGood;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleMain frame = new SaleMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaleMain() {
		initGoodLst();
		initComponents();

	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 189, 678);
		contentPane.add(panel);

		JLabel label = new JLabel();
		label.setText("货 物");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGroup(
										gl_panel.createParallelGroup(
												Alignment.LEADING)
												.addGroup(
														gl_panel.createSequentialGroup()
																.addGap(71)
																.addComponent(
																		label))
												.addGroup(
														gl_panel.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		scrollPane,
																		GroupLayout.DEFAULT_SIZE,
																		160,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(label)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								613, Short.MAX_VALUE).addContainerGap()));

		saleGoodjList = new JList();
		scrollPane.setViewportView(saleGoodjList);
		panel.setLayout(gl_panel);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(199, 304, 462, 329);
		contentPane.add(scrollPane_1);

		saleTable = new JTable();
		scrollPane_1.setViewportView(saleTable);

		JLabel label_2 = new JLabel("窗帘布：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(209, 160, 56, 15);
		contentPane.add(label_2);

		clothName = new JTextField();
		clothName.setColumns(10);
		clothName.setBounds(264, 157, 130, 21);
		contentPane.add(clothName);

		JLabel label_4 = new JLabel("价格：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(404, 160, 45, 15);
		contentPane.add(label_4);

		clothPrice = new JTextField();
		clothPrice.setColumns(10);
		clothPrice.setBounds(444, 157, 38, 21);
		contentPane.add(clothPrice);

		JLabel saleTotal = new JLabel("总价：");
		saleTotal.setFont(new Font("宋体", Font.PLAIN, 14));
		saleTotal.setBounds(209, 643, 45, 25);
		contentPane.add(saleTotal);

		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(253, 643, 54, 20);
		contentPane.add(label_8);

		addCurtainGood = new JButton("添加货物");
		addCurtainGood.setFont(new Font("宋体", Font.PLAIN, 14));
		addCurtainGood.setBounds(555, 255, 88, 23);
		contentPane.add(addCurtainGood);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5BA2\u6237\u4FE1\u606F",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(201, 10, 460, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel label_1 = new JLabel("姓名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(10, 26, 70, 15);
		panel_1.add(label_1);

		customerName = new JTextField();
		customerName.setColumns(10);
		customerName.setBounds(54, 23, 103, 21);
		panel_1.add(customerName);

		JLabel label_3 = new JLabel("电话：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(207, 26, 54, 15);
		panel_1.add(label_3);

		customerTel1 = new JTextField();
		customerTel1.setColumns(10);
		customerTel1.setBounds(254, 23, 87, 21);
		panel_1.add(customerTel1);

		customerTel2 = new JTextField();
		customerTel2.setColumns(10);
		customerTel2.setBounds(351, 23, 86, 21);
		panel_1.add(customerTel2);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(277, 50, 93, 21);
		panel_1.add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(168, 50, 93, 21);
		panel_1.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(54, 51, 93, 21);
		panel_1.add(comboBox_2);

		JLabel label_6 = new JLabel("地址：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(10, 52, 54, 16);
		panel_1.add(label_6);

		customerAdr = new JTextField();
		customerAdr.setColumns(10);
		customerAdr.setBounds(53, 78, 383, 21);
		panel_1.add(customerAdr);

		customerDeposit = new JTextField();
		customerDeposit.setColumns(10);
		customerDeposit.setBounds(54, 106, 66, 21);
		panel_1.add(customerDeposit);

		JLabel label_7 = new JLabel("定金：");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_7.setBounds(11, 106, 54, 21);
		panel_1.add(label_7);

		addCustomerBtn = new JButton("添加客户");
		addCustomerBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		addCustomerBtn.setBounds(344, 104, 93, 23);
		panel_1.add(addCustomerBtn);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(666, 0, 189, 678);
		contentPane.add(panel_2);

		JLabel label_9 = new JLabel();
		label_9.setText("历史订单");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGap(0, 189, Short.MAX_VALUE)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addGap(71)
																		.addComponent(
																				label_9))
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scrollPane_2,
																				GroupLayout.DEFAULT_SIZE,
																				169,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2
				.createParallelGroup(Alignment.LEADING)
				.addGap(0, 678, Short.MAX_VALUE)
				.addGroup(
						gl_panel_2
								.createSequentialGroup()
								.addContainerGap()
								.addComponent(label_9)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(scrollPane_2,
										GroupLayout.DEFAULT_SIZE, 633,
										Short.MAX_VALUE).addContainerGap()));

		saleLatelyjList = new JList();
		scrollPane_2.setViewportView(saleLatelyjList);
		panel_2.setLayout(gl_panel_2);

		JLabel label_5 = new JLabel("安装位置：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(209, 259, 79, 15);
		contentPane.add(label_5);

		curtainLocation = new JTextField();
		curtainLocation.setBounds(285, 256, 77, 21);
		contentPane.add(curtainLocation);
		curtainLocation.setColumns(10);

		JLabel lblNewLabel = new JLabel("窗帘圈：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(209, 191, 56, 15);
		contentPane.add(lblNewLabel);

		JLabel label_10 = new JLabel("价格：");
		label_10.setFont(new Font("宋体", Font.PLAIN, 14));
		label_10.setBounds(404, 191, 45, 15);
		contentPane.add(label_10);

		curtainRingPrice = new JTextField();
		curtainRingPrice.setColumns(10);
		curtainRingPrice.setBounds(444, 188, 38, 21);
		contentPane.add(curtainRingPrice);

		JLabel label_11 = new JLabel("备注：");
		label_11.setFont(new Font("宋体", Font.PLAIN, 14));
		label_11.setBounds(492, 160, 45, 15);
		contentPane.add(label_11);

		clothRemark = new JTextField();
		clothRemark.setColumns(10);
		clothRemark.setBounds(532, 157, 124, 21);
		contentPane.add(clothRemark);

		curtainRingRemark = new JTextField();
		curtainRingRemark.setColumns(10);
		curtainRingRemark.setBounds(532, 188, 124, 21);
		contentPane.add(curtainRingRemark);

		JLabel label_12 = new JLabel("备注：");
		label_12.setFont(new Font("宋体", Font.PLAIN, 14));
		label_12.setBounds(492, 191, 45, 15);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("窗帘杆：");
		label_13.setFont(new Font("宋体", Font.PLAIN, 14));
		label_13.setBounds(209, 219, 56, 15);
		contentPane.add(label_13);

		curtainRodName = new JComboBox();
		curtainRodName.setBounds(264, 216, 130, 21);
		contentPane.add(curtainRodName);

		JLabel label_14 = new JLabel("价格：");
		label_14.setFont(new Font("宋体", Font.PLAIN, 14));
		label_14.setBounds(404, 219, 45, 15);
		contentPane.add(label_14);

		curtainRodPrice = new JTextField();
		curtainRodPrice.setColumns(10);
		curtainRodPrice.setBounds(444, 216, 38, 21);
		contentPane.add(curtainRodPrice);

		JLabel label_15 = new JLabel("备注：");
		label_15.setFont(new Font("宋体", Font.PLAIN, 14));
		label_15.setBounds(492, 219, 45, 15);
		contentPane.add(label_15);

		curtainRodRemark = new JTextField();
		curtainRodRemark.setColumns(10);
		curtainRodRemark.setBounds(532, 216, 124, 21);
		contentPane.add(curtainRodRemark);

		curtainRingName = new JTextField();
		curtainRingName.setColumns(10);
		curtainRingName.setBounds(264, 188, 130, 21);
		contentPane.add(curtainRingName);
	}

	private void initGoodLst() {
		// TODO Auto-generated method stub
		goodsLst = (List<CurtainShopGoods>) DBUtil.getLstClass("serialNumber",
				"eq", CurtainShopGoods.class, "curtainShop", "凯妮丝二店", "String");
		UIutil.initCurtainShopGoodsLstFromName(this, saleGoodjList, goodsLst);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
