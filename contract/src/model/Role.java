package model;

public class Role {
	private int id;			    //ID
	private String name;		//Role name
	private String funcIds;		//Function number combination(Split multiple function number with ",")
	private String description;	//Description
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

	public String getFuncIds() {
		return funcIds;
	}

	public void setFuncIds(String funcIds) {
		this.funcIds = funcIds;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	public Role() {
		this.id = 0;
		this.name = "";
		this.funcIds = "";
		this.description = "";
		this.del = 0;
	}

}
