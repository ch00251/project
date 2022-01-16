package com.dto;

public class BoardsDTO {
	private int num;
	private String userid;
	private String title;
	private String content;
	private String regdate;
	private int viewCount;
	//페이징처리
	private int startRowNum;
	private int endRowNum;
	public BoardsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BoardsDTO(int num, String userid, String title, String content, String regdate, int viewCount,
			int startRowNum, int endRowNum) {
		super();
		this.num = num;
		this.userid = userid;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.viewCount = viewCount;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	@Override
	public String toString() {
		return "BoardsDTO [num=" + num + ", userid=" + userid + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", viewCount=" + viewCount + ", startRowNum=" + startRowNum + ", endRowNum="
				+ endRowNum + "]";
	}
	
	
}
