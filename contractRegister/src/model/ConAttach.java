package model;

import java.util.Date;

public class ConAttach {
	private int id;			    //ID
	private int conId;			// Contract id
	private String fileName;	// Attachment name
	private String path;		// Attachment path
	private String type;		// Attachment type
	private Date uploadDate;	// Upload date
	private int del;			// Delete status(0-Not deleted, 1-Deleted)
	
	/**
	 * No-arg constructor assigns initial values to object attributes
	 */
	public ConAttach(){
		this.id = 0;
		this.conId = 0;
		this.fileName = "";
		this.path = "";
		this.type = "";
		this.setUploadDate(new Date());
		this.del = 0;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}


	public Date getUploadDate() {
		return uploadDate;
	}


	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	
}
