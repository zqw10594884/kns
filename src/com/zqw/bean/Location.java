package com.zqw.bean;

import java.util.ArrayList;

public class Location {
	private ArrayList<String> county;
	private ArrayList<String> address;
	private ArrayList<String> residentialQuarters;

	public ArrayList<String> getCounty() {
		return county;
	}

	public void setCounty(ArrayList<String> county) {
		this.county = county;
	}

	public ArrayList<String> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<String> address) {
		this.address = address;
	}

	public ArrayList<String> getResidentialQuarters() {
		return residentialQuarters;
	}

	public void setResidentialQuarters(ArrayList<String> residentialQuarters) {
		this.residentialQuarters = residentialQuarters;
	}
}
