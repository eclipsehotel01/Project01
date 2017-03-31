package com.eclipse.hotel.vo;
public class room_infoVO {
	int rnum;
	String rname;
	String rsize;
	String rtype;
	int standperson;
	int max_person;
	String img;
	String price;
	int season;
	int nonseason;
	String memo;
	
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRsize() {
		return rsize;
	}
	public void setRsize(String rsize) {
		this.rsize = rsize;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	public int getStandperson() {
		return standperson;
	}
	public void setStandperson(int standperson) {
		this.standperson = standperson;
	}
	public int getMax_person() {
		return max_person;
	}
	public void setMax_person(int max_person) {
		this.max_person = max_person;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	

}
