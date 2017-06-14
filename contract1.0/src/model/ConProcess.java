package model;

import java.util.Date;

public class ConProcess {
	private int id;			    //ID
	private int conId;			// Contract id
	private int userId;			// User id
	private int type;			// Operation type(1-countersign ,2-approve,3-sign)
	private int state;			// Operation status(0-unfinished,1-completed,2-rejected)
	private String content;		// Operation content
	private Date time;			// Operation time 
	private int del;			// Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public ConProcess(){
		this.setId(0);
		this.setConId(0);
		this.setUserId(0);
		this.setType(0);
		this.setState(0);
		this.setContent("");
		this.setTime(new Date());
		this.setDel(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getConId() {
		return conId;
	}

	public void setConId(int conId) {
		this.conId = conId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	

}
