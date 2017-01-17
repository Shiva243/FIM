package com.fin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FinDetails")
public class FinanceDetails {
	@Id
	private Long _id;
	@Indexed(unique = true)
	private String chitAmount;
	private String chitMonths;
	private String intrestRate;
	private String createdDate;
	private String modifyDate;
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	public String getChitAmount() {
		return chitAmount;
	}
	public void setChitAmount(String chitAmount) {
		this.chitAmount = chitAmount;
	}
	public String getChitMonths() {
		return chitMonths;
	}
	public void setChitMonths(String chitMonths) {
		this.chitMonths = chitMonths;
	}
	public String getIntrestRate() {
		return intrestRate;
	}
	public void setIntrestRate(String intrestRate) {
		this.intrestRate = intrestRate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	
}
