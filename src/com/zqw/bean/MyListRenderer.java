package com.zqw.bean;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.zqw.bean.Global;

public class MyListRenderer extends DefaultListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value,

	int index, boolean isSelected, boolean hasFocus) {
		setEnabled(list.isEnabled());
		setFont(Global.f);
		setText(value.toString());
		this.setBackground(list.getBackground());
		if (isSelected) {
			this.setBackground(list.getSelectionBackground());
		} else {
			this.setBackground(list.getBackground());
		}
		return this;
	}

}