package com.indiv.front.vo;

public class memberVO {
	private String id;
	private String pass;
	private String name;
	private String phone;
	private String birth;
	private String zipCode;
	private String addr;
	private String detailAddr;
	private String cre_dt;
	private String upd_dt;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getCre_dt() {
		return cre_dt;
	}
	public void setCre_dt(String cre_dt) {
		this.cre_dt = cre_dt;
	}
	public String getUpd_dt() {
		return upd_dt;
	}
	public void setUpd_dt(String upd_dt) {
		this.upd_dt = upd_dt;
	}
	
	@Override
	public String toString() {
		return "memberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", birth=" + birth
				+ ", zipCode=" + zipCode + ", addr=" + addr + ", detailAddr=" + detailAddr + ", cre_dt=" + cre_dt
				+ ", upd_dt=" + upd_dt + "]";
	}
}
