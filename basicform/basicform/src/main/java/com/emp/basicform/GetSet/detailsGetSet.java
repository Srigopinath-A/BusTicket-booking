package com.emp.basicform.GetSet;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class detailsGetSet {
	
	
	public detailsGetSet(int id, int seat, String pname, String bname) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id;
		this.seat = seat;
		this.pname = pname;
		this.bname = bname;
	}

	
	public detailsGetSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	private int id;
	private int seat;
	private String pname;
	private String bname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}


	@Override
	public String toString() {
		return "detailsGetSet [id=" + id + ", seat=" + seat + ", pname=" + pname + ", bname=" + bname + "]";
	}
	
	
}
