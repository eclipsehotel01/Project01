package com.eclipse.hotel.vo;

public class paymentVO {
	
	int p_num;
	int reservecode;
	String p_date;
	int p_price;
	String p_cancel;
	String id;
	String name;
	String check_in;
	String check_out;
	int rnum;
	String rname;
	String rtype;
	String img;
	
	public String getP_cancel() {
		return p_cancel;
	}
	public void setP_cancel(String p_cancel) {
		this.p_cancel = p_cancel;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCheck_in() {
		return check_in;
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out;
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
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
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getReservecode() {
		return reservecode;
	}
	public void setReservecode(int reservecode) {
		this.reservecode = reservecode;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	
	

}
