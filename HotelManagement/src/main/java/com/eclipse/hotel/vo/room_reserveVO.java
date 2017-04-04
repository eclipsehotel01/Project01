package com.eclipse.hotel.vo;

public class room_reserveVO {
	int reservecode;
	int m_num;
	String check_in;
	String check_out;
	int person;
	int rnum;
	String rname;
	String reservedate;
	String extracode;
	int extracharge;
	int p_price;
	String rtype;
	int r_price;
	int standperson;
	int max_person;
	
	
	public int getStandperson() {
		return standperson;
	}
	public int getMax_person() {
		return max_person;
	}
	public void setStandperson(int standperson) {
		this.standperson = standperson;
	}
	public void setMax_person(int max_person) {
		this.max_person = max_person;
	}
	public int getR_price() {
		return r_price;
	}
	public void setR_price(int r_price) {
		this.r_price = r_price;
	}
	public int getReservecode() {
		return reservecode;
	}
	public void setReservecode(int reservecode) {
		this.reservecode = reservecode;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getCheck_in() {
		return check_in.substring(0, 10).replace('-', '/');
	}
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}
	public String getCheck_out() {
		return check_out.substring(0, 10).replace('-', '/');
	}
	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
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
	public String getReservedate() {
		return reservedate;
	}
	public void setReservedate(String reservedate) {
		this.reservedate = reservedate;
	}
	public String getExtracode() {
		return extracode;
	}
	public void setExtracode(String extracode) {
		this.extracode = extracode;
	}
	public int getExtracharge() {
		return extracharge;
	}
	public void setExtracharge(int extracharge) {
		this.extracharge = extracharge;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public String getRtype() {
		return rtype;
	}
	public void setRtype(String rtype) {
		this.rtype = rtype;
	}
	

}
