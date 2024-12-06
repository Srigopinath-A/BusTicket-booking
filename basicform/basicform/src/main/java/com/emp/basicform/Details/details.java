package com.emp.basicform.Details;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// lombok function - not working so create getter and setter manually 
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public details(int id, int seat, String pname, String bname) {
		super();
		this.id = id;
		this.seat = seat;
		this.pname = pname;
		this.bname = bname;
	}
	public details() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "details [id=" + id + ", seat=" + seat + ", pname=" + pname + ", bname=" + bname + "]";
	}
	
	
	
}
