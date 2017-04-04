package com.eclipse.hotel.vo;

public class room_priceVO {
	String price;
	int season;
	int nonseason;
	String pmemo;
	
	
	public String getPmemo() {
		return pmemo;
	}
	public void setPmemo(String pmemo) {
		this.pmemo = pmemo;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}

	public int getNonseason() {
		return nonseason;
	}
	public void setNonseason(int nonseason) {
		this.nonseason = nonseason;
	}
	
	
	

}
