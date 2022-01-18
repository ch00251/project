package com.exam.dto;

import java.sql.Timestamp;

public class BbsDto {
	
	private int bbsId = 1, bbsHit = 0;
	private String bbsTitle, bbsContent, bbsCategory, id;
	private Timestamp bbsDate;
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsCategory() {
		return bbsCategory;
	}
	public void setBbsCategory(String bbsCategory) {
		this.bbsCategory = bbsCategory;
	}
	public Timestamp getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(Timestamp bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BbsDto [bbsId=").append(bbsId).append(", bbsHit=").append(bbsHit).append(", bbsTitle=")
				.append(bbsTitle).append(", bbsContent=").append(bbsContent).append(", bbsCategory=")
				.append(bbsCategory).append(", bbsDate=").append(bbsDate).append(", id=").append(id).append("]");
		return builder.toString();
	}
	
	

}
