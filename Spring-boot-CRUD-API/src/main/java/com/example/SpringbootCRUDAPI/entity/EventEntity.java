package com.example.SpringbootCRUDAPI.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="events")
public class EventEntity {
	@Id
	private UUID eventId;
	
	@Column(name="transId", nullable = false)
	private String transId;
	
	@Column(name="transTms", nullable = false)
	private String transTms;
	
	@Column(name="rcNum", nullable = false)
	private String rcNum;
	
	@Column(name="clientId", nullable = false)
	private String clientId;
	
	@GeneratedValue
	@Column(name="eventCnt", nullable = false)
	private int eventCnt;
	
	@Column(name="locationCd", nullable = false)
	private String locationCd;
	
	@Column(name="locationId1", nullable = false)
	private String locationId1;
	
	@Column(name="locationId2", nullable = false)
	private String locationId2;
	
	@Column(name="addrNbr", nullable = false)
	private String addrNbr;
	
	public EventEntity() {}
	
	//Getters
	public UUID getEventId() {
		return eventId;
	}
	
	public String getTransId() {
		return transId;
	}
	
	public String getTransTms() {
		return transTms;
	}
	
	public String getRcNum() {
		return rcNum;
	}
	
	public String getClientId() {
		return clientId;
	}
	
	public int getEventCnt() {
		return eventCnt;
	}
	
	public String getLocationCd() {
		return locationCd;
	}
	
	public String getLocationId1() {
		return locationId1;
	}
	
	public String getLocationId2() {
		return locationId2;
	}
	
	public String getAddrNbr() {
		return addrNbr;
	}
	
	//setters
	public void setEventId(UUID eventId) {
		this.eventId = eventId;
	}
	
	public void setTransId(String transId) {
		this.transId = transId;
	}
	
	public void setTransTms(String transTms) {
		this.transTms = transTms;
	}
	
	public void setRcNum(String rcNum) {
		this.rcNum = rcNum;
	}
	
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public void setEventCnt(int eventCnt) {
		this.eventCnt = eventCnt;
	}
	
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
	
	public void setLocationId1(String locationId1) {
		this.locationId1 = locationId1;
	}
	
	public void setLocationId2(String locationId2) {
		this.locationId2 = locationId2;
	}
	
	public void setAddrNbr(String addrNbr) {
		this.addrNbr = addrNbr;
	}
}
