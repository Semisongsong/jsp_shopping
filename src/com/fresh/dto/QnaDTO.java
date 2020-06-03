package com.fresh.dto;

import java.sql.Timestamp;

public class QnaDTO {
	private int num;
	private String title;
	private String id;
	//private int answer;
	private String contents;
	private int views;
	private int grp;
	private int lvl;
	private int seq;
	private Timestamp qdate;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

//	public int getAnswer() {
//		return answer;
//	}
//
//	public void setAnswer(int answer) {
//		this.answer = answer;
//	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getGrp() {
		return grp;
	}

	public void setGrp(int grp) {
		this.grp = grp;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public Timestamp getQdate() {
		return qdate;
	}

	public void setQdate(Timestamp qdate) {
		this.qdate = qdate;
	}

}
