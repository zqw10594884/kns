package com.zqw.bean;

public class CheckListItem {
	private String label;
	private boolean isSelected = false;

	public CheckListItem() {
		super();
	}

	public CheckListItem(String label, boolean isSelected) {
		super();
		this.label = label;
		this.isSelected = isSelected;
	}

	public CheckListItem(String label) {
		this.label = label;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public String toString() {
		return label;
	}
}