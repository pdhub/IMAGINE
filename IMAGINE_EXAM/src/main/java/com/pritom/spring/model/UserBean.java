package com.pritom.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class UserBean {

	@Id
	@Column(name="USERNAME")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ENABLED")
	private String enabled;
	
	@Column(name="IS_SELLER")
	private String buyer_seller;
	
	@Column(name="LATITUTE")
	private Double latitute;
	
	@Column(name="LONGITUTE")
	private Double longitute;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	public String getBuyer_seller() {
		return buyer_seller;
	}
	public void setBuyer_seller(String buyer_seller) {
		this.buyer_seller = buyer_seller;
	}
	public Double getLatitute() {
		return latitute;
	}
	public void setLatitute(Double latitute) {
		this.latitute = latitute;
	}
	public Double getLongitute() {
		return longitute;
	}
	public void setLongitute(Double longitute) {
		this.longitute = longitute;
	}
	
	
	

}
