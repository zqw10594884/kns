package com.zqw.listener;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.zqw.bean.CheckListItem;

public class CheckListRenderer extends JCheckBox implements ListCellRenderer {

	public Component getListCellRendererComponent(JList list, Object value,

	int index, boolean isSelected, boolean hasFocus) {

		setEnabled(list.isEnabled());
		setSelected(((CheckListItem) value).isSelected());
		setFont(list.getFont());
		if (isSelected) {
			this.setBackground(list.getSelectionBackground());
			this.setForeground(list.getSelectionForeground());
		} else {
			this.setBackground(list.getBackground());
			this.setForeground(list.getForeground());
		}
		setText(value.toString());
		return this;

	}

}