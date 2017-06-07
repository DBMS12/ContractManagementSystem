package model;

import java.util.Date;

public class Log {
	private int id;			    //ID
	private int userId;			//Operator id
	private Date time;			//Operation time
	private String content;		//Log content
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	private int del;			//Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public Log(){
		this.id = 0;
		this.userId = 0;
		this.time = new Date();
		this.content = "";
		this.del = 0;
	}


}
