package com.zqw.bean;

public class CurtainShop {
	private int id;
	private String name;
	private String telephone;
	private String address;
	private int owner;

	
	
	public CurtainShop(int id, String name, String telephone, String address,
			int owner) {
		super();
		this.id = id;
		this.name = name;
		this.telephone = telephone;
		this.address = address;
		this.owner = owner;
	}

	public CurtainShop(String address, String telephone, String name,int owner) {
		super();
		this.address = address;
		this.telephone = telephone;
		this.name = name;
		this.owner = owner;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public CurtainShop() {
		super();
	}
}
