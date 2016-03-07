package com.zqw.ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

public class SaleMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTable saleTable;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(71)
							.addComponent(label))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList saleGoodjList = new JList();
		scrollPane.setViewportView(saleGoodjList);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(199, 215, 462, 418);
		contentPane.add(scrollPane_1);
		
		saleTable = new JTable();
		scrollPane_1.setViewportView(saleTable);
		
		JLabel label_2 = new JLabel("编号：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(199, 186, 54, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(242, 183, 130, 21);
		contentPane.add(textField);
		
		JLabel label_4 = new JLabel("价格：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(382, 185, 54, 15);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(422, 183, 48, 21);
		contentPane.add(textField_2);
		
		JLabel label_5 = new JLabel("数量：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(480, 186, 45, 15);
		contentPane.add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(521, 183, 41, 21);
		contentPane.add(textField_4);
		
		JLabel saleTotal = new JLabel("总价：");
		saleTotal.setFont(new Font("宋体", Font.PLAIN, 14));
		saleTotal.setBounds(209, 643, 45, 25);
		contentPane.add(saleTotal);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(253, 643, 54, 20);
		contentPane.add(label_8);
		
		JButton button_1 = new JButton("添加货物");
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.setBounds(572, 182, 88, 23);
		contentPane.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u5BA2\u6237\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(201, 10, 460, 137);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("姓名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(10, 26, 70, 15);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(54, 23, 103, 21);
		panel_1.add(textField_1);
		
		JLabel label_3 = new JLabel("电话：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(207, 26, 54, 15);
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(254, 23, 87, 21);
		panel_1.add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(351, 23, 86, 21);
		panel_1.add(textField_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 50, 93, 21);
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 50, 93, 21);
		panel_1.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(54, 51, 93, 21);
		panel_1.add(comboBox_2);
		
		JLabel label_6 = new JLabel("地址：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(10, 52, 54, 16);
		panel_1.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(53, 78, 383, 21);
		panel_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(54, 106, 66, 21);
		panel_1.add(textField_7);
		
		JLabel label_7 = new JLabel("定金：");
		label_7.setFont(new Font("新宋体", Font.PLAIN, 14));
		label_7.setBounds(11, 106, 54, 21);
		panel_1.add(label_7);
		
		JButton button = new JButton("添加客户");
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(344, 104, 93, 23);
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(666, 0, 189, 678);
		contentPane.add(panel_2);
		
		JLabel label_9 = new JLabel();
		label_9.setText("历史订单");
		label_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 189, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(71)
							.addComponent(label_9))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 678, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList saleLatelyjList = new JList();
		scrollPane_2.setViewportView(saleLatelyjList);
		panel_2.setLayout(gl_panel_2);
	}
}
