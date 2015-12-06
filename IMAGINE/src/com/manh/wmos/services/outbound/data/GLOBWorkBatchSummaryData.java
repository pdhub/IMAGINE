package com.manh.wmos.services.outbound.data;

import java.sql.Date;

public class GLOBWorkBatchSummaryData {

	private String batchId;
	private Integer statCode;
	private Integer nbrOfLpn;
	private Integer nbrOfTasks;
	private String mheFlag;
	private Date createdDttm;
	private Date lastUpdatedDttm;
	private String userId;
	private Integer units;
	private Integer picks;
	private Integer picksComplete;
	private Integer batchPriority;
	private String batchCriteria;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Integer getStatCode() {
		return statCode;
	}
	public void setStatCode(Integer statCode) {
		this.statCode = statCode;
	}
	public Integer getNbrOfLpn() {
		return nbrOfLpn;
	}
	public void setNbrOfLpn(Integer nbrOfLpn) {
		this.nbrOfLpn = nbrOfLpn;
	}
	public Integer getNbrOfTasks() {
		return nbrOfTasks;
	}
	public void setNbrOfTasks(Integer nbrOfTasks) {
		this.nbrOfTasks = nbrOfTasks;
	}
	public String getMheFlag() {
		return mheFlag;
	}
	public void setMheFlag(String mheFlag) {
		this.mheFlag = mheFlag;
	}
	public Date getCreatedDttm() {
		return createdDttm;
	}
	public void setCreatedDttm(Date createdDttm) {
		this.createdDttm = createdDttm;
	}
	public Date getLastUpdatedDttm() {
		return lastUpdatedDttm;
	}
	public void setLastUpdatedDttm(Date lastUpdatedDttm) {
		this.lastUpdatedDttm = lastUpdatedDttm;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getUnits() {
		return units;
	}
	public void setUnits(Integer units) {
		this.units = units;
	}
	public Integer getPicks() {
		return picks;
	}
	public void setPicks(Integer picks) {
		this.picks = picks;
	}
	public Integer getPicksComplete() {
		return picksComplete;
	}
	public void setPicksComplete(Integer picksComplete) {
		this.picksComplete = picksComplete;
	}
	public Integer getBatchPriority() {
		return batchPriority;
	}
	public void setBatchPriority(Integer batchPriority) {
		this.batchPriority = batchPriority;
	}
	public String getBatchCriteria() {
		return batchCriteria;
	}
	public void setBatchCriteria(String batchCriteria) {
		this.batchCriteria = batchCriteria;
	}
	
	
	
}
