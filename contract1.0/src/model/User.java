package model;

public class User {
	private int id;			    //ID
	private String name;		//User name
	private String password;	//Password
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	public User(){
		this.id = 0;
		this.name = "";
		this.password = "";
		this.del = 0;
	}

}
