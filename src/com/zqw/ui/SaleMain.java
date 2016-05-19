package com.zqw.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
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
import com.zqw.bean.SaleOrderGoods;
import com.zqw.bean.SaleOrderLst;
import com.zqw.util.DBUtil;
import com.zqw.util.ReflectionUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jfree.data.DataUtilities;

public class SaleMain extends JFrame implements ListSelectionListener {

	private JPanel contentPane;
	private JTextField curtainClothName;
	private JTextField clothPrice;
	private JTable saleTable;
	private JTextField customerName;
	private JTextField customerTel1;
	private JTextField customerTel2;
	private JTextField customerAdr;
	private JTextField customerDeposit;
	private JTextField curtainLocation;
	private JTextField curtainTapePrice;
	private JTextField clothRemark;
	private JTextField curtainTapeRemark;
	private JTextField curtainRodPrice;
	private JTextField curtainRodRemark;
	private JTextField curtainTapeName;
	private List<CurtainShopGoods> goodsLst = new ArrayList<CurtainShopGoods>();
	private List<SaleOrderLst> solLatelyLst = new ArrayList<SaleOrderLst>();
	private SaleOrderLst currentSol = new SaleOrderLst();
	private JList saleGoodjList;
	private JList saleLatelyjList;
	private JButton addCustomerBtn;
	private JButton addCurtainGood;
	private JScrollPane scrollPane_1;
	private JTextField curtainLaceName;
	private JTextField curtainLacePrice;
	private JTextField curtainLaceRemark;
	private JTextField curtainRingName;
	private JTextField curtainRingPrice;
	private JTextField curtainRingRemark;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField curtainHight;
	private JComboBox hightLocationCB;
	private JTextField curtainWidth;
	private JTextField curtainRodName;
	private DefaultTableModel tableModel;
	private String[] columnNames = { "位置", "形式", "高度位置", "高度", "宽度", "窗帘布",
			"花边", "窗帘杆", "窗帘圈" };
	private JComboBox curtainStyleCB;

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
		initComponents();
		initGoodLst();
		initTable();
		initlatelyList();
	}

	private void initlatelyList() {
		solLatelyLst = (List<SaleOrderLst>) DBUtil
				.getLstClass("id", "", SaleOrderLst.class, "");
		ArrayList<String> LatelyItem = new ArrayList<String>();
		if (solLatelyLst != null) {
			for (int i = 0; i < solLatelyLst.size(); i++) {
				SaleOrderLst sol = solLatelyLst.get(i);
				LatelyItem.add("(" + sol.getSubmitTime() + ")"
						+ sol.getCustomerName());
			}
			UIutil.initJlist(this, saleLatelyjList, LatelyItem);
		}
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 716);
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
		scrollPane_1.setBounds(199, 394, 764, 239);
		contentPane.add(scrollPane_1);

		saleTable = new JTable();
		// saleTable.setModel();
		saleTable.setToolTipText("窗帘");
		scrollPane_1.setViewportView(saleTable);

		JLabel label_2 = new JLabel("窗帘布：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(209, 186, 56, 15);
		contentPane.add(label_2);

		curtainClothName = new JTextField();
		curtainClothName.setEditable(false);
		curtainClothName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reBuildGoodLst("A-");
			}
		});
		curtainClothName.setColumns(10);
		curtainClothName.setBounds(264, 183, 130, 21);
		contentPane.add(curtainClothName);

		JLabel label_4 = new JLabel("价格：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(404, 186, 45, 15);
		contentPane.add(label_4);

		clothPrice = new JTextField();
		clothPrice.setColumns(10);
		clothPrice.setBounds(444, 183, 38, 21);
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
		addCurtainGood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCurtainGoodActionPerformed(e);
			}
		});
		addCurtainGood.setFont(new Font("宋体", Font.PLAIN, 14));
		addCurtainGood.setBounds(556, 361, 100, 23);
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
		addCustomerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomerActionPerformed(e);
			}
		});
		addCustomerBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		addCustomerBtn.setBounds(334, 105, 103, 23);
		panel_1.add(addCustomerBtn);

		JButton customerModifyBtn = new JButton("修改");
		customerModifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		customerModifyBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		customerModifyBtn.setBounds(257, 104, 67, 23);
		panel_1.add(customerModifyBtn);

		JButton customerDelBtn = new JButton("删除");
		customerDelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		customerDelBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		customerDelBtn.setBounds(180, 104, 67, 23);
		panel_1.add(customerDelBtn);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(689, 10, 274, 374);
		contentPane.add(panel_2);

		JLabel label_9 = new JLabel();
		label_9.setText("历史订单");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_2
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_panel_2
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_panel_2
																		.createSequentialGroup()
																		.addComponent(
																				scrollPane_2,
																				GroupLayout.DEFAULT_SIZE,
																				169,
																				Short.MAX_VALUE)
																		.addContainerGap())
														.addGroup(
																Alignment.TRAILING,
																gl_panel_2
																		.createSequentialGroup()
																		.addComponent(
																				label_9)
																		.addGap(100)))));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(
				Alignment.LEADING).addGroup(
				gl_panel_2
						.createSequentialGroup()
						.addContainerGap()
						.addComponent(label_9)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE,
								339, Short.MAX_VALUE).addContainerGap()));

		saleLatelyjList = new JList();
		scrollPane_2.setViewportView(saleLatelyjList);
		panel_2.setLayout(gl_panel_2);

		JLabel label_5 = new JLabel("安装位置：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(450, 158, 79, 15);
		contentPane.add(label_5);

		curtainLocation = new JTextField();
		curtainLocation.setBounds(526, 155, 130, 21);
		contentPane.add(curtainLocation);
		curtainLocation.setColumns(10);

		JLabel lblNewLabel = new JLabel("布带：");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(209, 217, 56, 15);
		contentPane.add(lblNewLabel);

		JLabel label_10 = new JLabel("价格：");
		label_10.setFont(new Font("宋体", Font.PLAIN, 14));
		label_10.setBounds(404, 217, 45, 15);
		contentPane.add(label_10);

		curtainTapePrice = new JTextField();
		curtainTapePrice.setColumns(10);
		curtainTapePrice.setBounds(444, 214, 38, 21);
		contentPane.add(curtainTapePrice);

		JLabel label_11 = new JLabel("备注：");
		label_11.setFont(new Font("宋体", Font.PLAIN, 14));
		label_11.setBounds(492, 186, 45, 15);
		contentPane.add(label_11);

		clothRemark = new JTextField();
		clothRemark.setColumns(10);
		clothRemark.setBounds(532, 183, 124, 21);
		contentPane.add(clothRemark);

		curtainTapeRemark = new JTextField();
		curtainTapeRemark.setColumns(10);
		curtainTapeRemark.setBounds(532, 214, 124, 21);
		contentPane.add(curtainTapeRemark);

		JLabel label_12 = new JLabel("备注：");
		label_12.setFont(new Font("宋体", Font.PLAIN, 14));
		label_12.setBounds(492, 217, 45, 15);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("窗帘杆：");
		label_13.setFont(new Font("宋体", Font.PLAIN, 14));
		label_13.setBounds(209, 303, 56, 15);
		contentPane.add(label_13);

		JLabel label_14 = new JLabel("价格：");
		label_14.setFont(new Font("宋体", Font.PLAIN, 14));
		label_14.setBounds(409, 303, 45, 15);
		contentPane.add(label_14);

		curtainRodPrice = new JTextField();
		curtainRodPrice.setColumns(10);
		curtainRodPrice.setBounds(449, 300, 38, 21);
		contentPane.add(curtainRodPrice);

		JLabel label_15 = new JLabel("备注：");
		label_15.setFont(new Font("宋体", Font.PLAIN, 14));
		label_15.setBounds(497, 303, 45, 15);
		contentPane.add(label_15);

		curtainRodRemark = new JTextField();
		curtainRodRemark.setColumns(10);
		curtainRodRemark.setBounds(537, 300, 124, 21);
		contentPane.add(curtainRodRemark);

		curtainTapeName = new JTextField();
		curtainTapeName.setEditable(false);
		curtainTapeName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reBuildGoodLst("C-布带");
			}
		});
		curtainTapeName.setColumns(10);
		curtainTapeName.setBounds(264, 214, 130, 21);
		contentPane.add(curtainTapeName);

		JLabel label_16 = new JLabel("花边：");
		label_16.setFont(new Font("宋体", Font.PLAIN, 14));
		label_16.setBounds(209, 245, 56, 15);
		contentPane.add(label_16);

		curtainLaceName = new JTextField();
		curtainLaceName.setEditable(false);
		curtainLaceName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reBuildGoodLst("C-花边");
			}
		});
		curtainLaceName.setColumns(10);
		curtainLaceName.setBounds(264, 242, 130, 21);
		contentPane.add(curtainLaceName);

		JLabel label_17 = new JLabel("价格：");
		label_17.setFont(new Font("宋体", Font.PLAIN, 14));
		label_17.setBounds(404, 245, 45, 15);
		contentPane.add(label_17);

		curtainLacePrice = new JTextField();
		curtainLacePrice.setColumns(10);
		curtainLacePrice.setBounds(444, 242, 38, 21);
		contentPane.add(curtainLacePrice);

		JLabel label_18 = new JLabel("备注：");
		label_18.setFont(new Font("宋体", Font.PLAIN, 14));
		label_18.setBounds(492, 245, 45, 15);
		contentPane.add(label_18);

		curtainLaceRemark = new JTextField();
		curtainLaceRemark.setColumns(10);
		curtainLaceRemark.setBounds(532, 242, 124, 21);
		contentPane.add(curtainLaceRemark);

		JLabel label_19 = new JLabel("窗帘圈：");
		label_19.setFont(new Font("宋体", Font.PLAIN, 14));
		label_19.setBounds(209, 273, 56, 15);
		contentPane.add(label_19);

		curtainRingName = new JTextField();
		curtainRingName.setEditable(false);
		curtainRingName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reBuildGoodLst("C-孔");
			}
		});
		curtainRingName.setColumns(10);
		curtainRingName.setBounds(264, 270, 130, 21);
		contentPane.add(curtainRingName);

		JLabel label_20 = new JLabel("价格：");
		label_20.setFont(new Font("宋体", Font.PLAIN, 14));
		label_20.setBounds(404, 273, 45, 15);
		contentPane.add(label_20);

		curtainRingPrice = new JTextField();
		curtainRingPrice.setColumns(10);
		curtainRingPrice.setBounds(444, 270, 38, 21);
		contentPane.add(curtainRingPrice);

		JLabel label_21 = new JLabel("备注：");
		label_21.setFont(new Font("宋体", Font.PLAIN, 14));
		label_21.setBounds(492, 273, 45, 15);
		contentPane.add(label_21);

		curtainRingRemark = new JTextField();
		curtainRingRemark.setColumns(10);
		curtainRingRemark.setBounds(532, 270, 124, 21);
		contentPane.add(curtainRingRemark);

		JButton submitBtn = new JButton("提交订单");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitAction(e);
			}
		});
		submitBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		submitBtn.setBounds(547, 644, 100, 23);
		contentPane.add(submitBtn);

		JButton curtainDelBtn = new JButton("删除");
		curtainDelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		curtainDelBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		curtainDelBtn.setBounds(382, 361, 67, 23);
		contentPane.add(curtainDelBtn);

		JButton curtainModifyBtn = new JButton("修改");
		curtainModifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		curtainModifyBtn.setFont(new Font("宋体", Font.PLAIN, 14));
		curtainModifyBtn.setBounds(470, 361, 67, 23);
		contentPane.add(curtainModifyBtn);

		hightLocationCB = new JComboBox();
		hightLocationCB.setModel(new DefaultComboBoxModel(new String[] {
				"高度位置", "顶高", "底高" }));
		hightLocationCB.setToolTipText("");
		hightLocationCB.setBounds(459, 332, 100, 21);
		contentPane.add(hightLocationCB);

		curtainHight = new JTextField();
		curtainHight.setColumns(10);
		curtainHight.setBounds(584, 332, 77, 21);
		contentPane.add(curtainHight);

		JLabel label_22 = new JLabel("宽度：");
		label_22.setFont(new Font("宋体", Font.PLAIN, 14));
		label_22.setBounds(209, 331, 56, 15);
		contentPane.add(label_22);

		curtainWidth = new JTextField();
		curtainWidth.setColumns(10);
		curtainWidth.setBounds(264, 328, 77, 21);
		contentPane.add(curtainWidth);

		curtainRodName = new JTextField();
		curtainRodName.setEditable(false);
		curtainRodName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reBuildGoodLst("C-杆");
			}
		});
		curtainRodName.setColumns(10);
		curtainRodName.setBounds(264, 300, 130, 21);
		contentPane.add(curtainRodName);

		curtainStyleCB = new JComboBox();
		curtainStyleCB.setModel(new DefaultComboBoxModel(new String[] {
				"打孔*1.7", "挂钩*1.5", "挂钩+0.5" }));
		curtainStyleCB.setBounds(226, 157, 98, 21);
		contentPane.add(curtainStyleCB);
	}

	private void submitAction(ActionEvent e) {
		DBUtil.insert(currentSol);
	}

	private void addCurtainGoodActionPerformed(ActionEvent e) {
		double width = Double.parseDouble(curtainWidth.getText().trim());
		String curtainStyle = curtainStyleCB.getSelectedItem().toString();

		List<SaleOrderGoods> goodsLst = new ArrayList<SaleOrderGoods>();
		// 窗帘布
		SaleOrderGoods sog = new SaleOrderGoods(curtainHight.getText().trim(),
				width + "", curtainLocation.getText().trim(),
				hightLocationCB.getSelectedIndex() + "", curtainStyle);
		sog.setClothSerialNumber(curtainClothName.getText().trim());
		sog.setCurtainTapeSerialNumber(curtainTapeName.getText().trim());
		sog.setCurtainLaceSerialNumber(curtainLaceName.getText().trim());
		sog.setCurtainRingSerialNumber(curtainRingName.getText().trim());
		sog.setCurtainRodSerialNumber(curtainRodName.getText().trim());

		sog.setClothSellingPrice(Double
				.parseDouble(clothPrice.getText().trim()));
		sog.setCurtainTapeSellingPrice(Double.parseDouble(curtainTapePrice
				.getText().trim()));
		sog.setCurtainLaceSellingPrice(Double.parseDouble(curtainLacePrice
				.getText().trim()));
		sog.setCurtainRingSellingPrice(Double.parseDouble(curtainRingPrice
				.getText().trim()));
		sog.setCurtainRodSellingPrice(Double.parseDouble(curtainRodPrice
				.getText().trim()));

		sog.setClothRemark(clothRemark.getText());
		sog.setCurtainTapeRemark(curtainTapeRemark.getText());
		sog.setClothRemark(curtainLaceRemark.getText());
		sog.setClothRemark(curtainRingRemark.getText());
		sog.setClothRemark(curtainRodRemark.getText());

		if ("打孔*1.7".equals(curtainStyle)) {
			sog.setClothNumber(width * 1.7);
			sog.setClothNumber(width * 1.7);
			sog.setClothNumber(width * 1.7);
			sog.setClothNumber(width * 1.7);
		} else if ("挂钩*1.5".equals(curtainStyle)) {
			sog.setClothNumber(width * 1.5);
			sog.setClothNumber(width * 1.5);
			sog.setClothNumber(width * 1.5);
		} else {
			sog.setClothNumber(width + 0.5);
		}
		sog.setClothNumber(width);
		goodsLst.add(sog);

		currentSol.setGoodsLst(goodsLst);
		String[] rowValues = creatRow(sog);
		tableModel.addRow(rowValues);
	}

	private String[] creatRow(SaleOrderGoods sog) {
		String[] row = new String[columnNames.length];
		row[0] = sog.getLocation();
		row[1] = sog.getCurtainStyle();
		row[2] = sog.getHightLocation();
		row[3] = sog.getCurtainHight();
		row[4] = sog.getCurtainWidth();
		row[5] = sog.getClothSerialNumber();
		row[6] = sog.getCurtainLaceSerialNumber();
		row[7] = sog.getCurtainRodSerialNumber();
		row[8] = sog.getCurtainRingSerialNumber();
		return row;
	}

	private void addCustomerActionPerformed(ActionEvent e) {

		currentSol.setCustomerName(customerName.getText().trim());
		currentSol.setCustomerTel1(customerTel1.getText().trim());
		currentSol.setCustomerTel2(customerTel2.getText().trim());
		currentSol.setCustomerDeposit(customerDeposit.getText().trim());
		currentSol.setSubmitTime(new Date());

		solLatelyLst.add(currentSol);
		ArrayList<String> item = new ArrayList<String>();
		for (int i = 0; i < solLatelyLst.size(); i++) {
			item.add(solLatelyLst.get(i).getSimpleDate() + "   "
					+ solLatelyLst.get(i).getCustomerName());
		}
		UIutil.initJlist(this, saleLatelyjList, item);
		DBUtil.insert(currentSol);
	}

	@SuppressWarnings("unchecked")
	private void initGoodLst() {
		goodsLst = (List<CurtainShopGoods>) DBUtil.getLstClass("serialNumber",
				"eq", CurtainShopGoods.class, "curtainShop", "凯妮丝二店", "String");

		UIutil.initCurtainShopGoodsLstFromName(this, saleGoodjList, goodsLst);
	}

	private void reBuildGoodLst(String index) {
		List<CurtainShopGoods> indexLst = new ArrayList<CurtainShopGoods>();
		for (int i = 0; i < goodsLst.size(); i++) {
			CurtainShopGoods c = goodsLst.get(i);
			if (c.getSerialNumber().contains(index)) {
				indexLst.add(c);
			}
		}
		UIutil.initCurtainShopGoodsLstFromName(this, saleGoodjList, indexLst);
	}

	private void initTable() {

		String[][] tableVales = new String[][] {};
		tableModel = new DefaultTableModel(tableVales, columnNames);
		saleTable.setModel(tableModel);
		saleTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablemouseClicked(e);
				
			}
		});
		saleTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		int[] width = { 69, 78, 58, 38, 38, 120, 120, 120, 120, };
		for (int i = 0; i < width.length; i++) {
			TableColumn col0 = saleTable.getColumnModel().getColumn(i);
			col0.setPreferredWidth(width[i]);
		}
	}

	protected void tablemouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int selectedRow = saleTable.getSelectedRow();
		if (selectedRow != -1) {
			SaleOrderGoods sog = currentSol.getGoodsLst().get(selectedRow);
			ReflectionUtil.setField(sog, this);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting()) {
			if (e.getSource().equals(saleGoodjList)) {
				String s = (String) saleGoodjList.getSelectedValue();
				if (s.contains("A-")) {
					curtainClothName.setText(s);
				} else if (s.contains("C-孔")) {
					curtainRingName.setText(s);
				} else if (s.contains("C-布带")) {
					curtainTapeName.setText(s);
				} else if (s.contains("C-杆")) {
					curtainRodName.setText(s);
				} else if (s.contains("C-花边")) {
					curtainLaceName.setText(s);
				}
			} else if (e.getSource().equals(saleLatelyjList)) {
				for (int i = 0; i < tableModel.getRowCount();) {
					tableModel.removeRow(0);
				}
				int index = saleLatelyjList.getSelectedIndex();
				currentSol = solLatelyLst.get(index);
				for (int i = 0; i < currentSol.getGoodsLst().size(); i++) {
					String[] rowValues = creatRow(currentSol.getGoodsLst().get(
							i));
					tableModel.addRow(rowValues);
				}
			}
		}
	}
}
