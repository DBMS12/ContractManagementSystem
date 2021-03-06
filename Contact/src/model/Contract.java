package model;

import java.util.Date;

public class Contract {
	private int id; 			//ID
	private String num; 		// Contract number
	private String name; 		// Contract name
	private int userId; 		// User id
	private String customer; 	// Customer
	private String content; 	// Contract content
	private Date beginTime; 	// Begin time
	private Date endTime; 		// End time
	private int del; 			// Delete status(0-Not deleted, 1-Deleted)

	public Contract() {
		this.setId(0);
		this.setNum("");
		this.setName("");
		this.setUserId(0);
		this.setCustomer("");
		this.setContent("");
		this.setBeginTime(new Date());
		this.setEndTime(new Date());	
		this.setDel(0);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}
	
	

}

