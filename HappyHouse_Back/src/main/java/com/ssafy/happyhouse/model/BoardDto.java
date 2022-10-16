package com.ssafy.happyhouse.model;

public class BoardDto {
	private int boardId;
	private String userId;
	private String title;
	private String content;
	private int hit; // 조회수
	private String regtime; // 등록일
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", userId=" + userId + ", title=" + title + ", content=" + content
				+ ", hit=" + hit + ", regtime=" + regtime + "]";
	}
	public BoardDto(int boardId, String userId, String title, String content, int hit, String regtime) {
		super();
		this.boardId = boardId;
		this.userId = userId;
		this.title = title;
		this.content = content;
		this.hit = hit;
		this.regtime = regtime;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	
	
}
