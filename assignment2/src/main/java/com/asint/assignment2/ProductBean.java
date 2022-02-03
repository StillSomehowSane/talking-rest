package com.asint.assignment2;

import java.util.Objects;

public class ProductBean {
	
	private String id;
	private Boolean isActive;
	private String price;
	private String productName;
	private String company;
	private String about;
	private String country;
	private String registered;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRegistered() {
		return registered;
	}
	public void setRegistered(String registered) {
		this.registered = registered;
	}
	
	public float getFloatPrice() {
		String temp = price;
		temp = temp.replace("$", "");
		temp = temp.replace(",", "");
		return Float.parseFloat(temp);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(about, company, country, id, isActive, price, productName, registered);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductBean other = (ProductBean) obj;
		return Objects.equals(about, other.about) && Objects.equals(company, other.company)
				&& Objects.equals(country, other.country) && Objects.equals(id, other.id)
				&& Objects.equals(isActive, other.isActive) && Objects.equals(price, other.price)
				&& Objects.equals(productName, other.productName) && Objects.equals(registered, other.registered);
	}
	
	
	
	
}
