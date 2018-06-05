package com.example.timewaste.model;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="waste")
public class Waste {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "first_name")
	private String firstName;
	

	@Column(name = "last_name")
	private String LastName;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	@Override
	public String toString() {
		return "Waste [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + "]";
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}

	
}