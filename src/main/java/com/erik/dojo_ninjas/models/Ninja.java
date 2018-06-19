package com.erik.dojo_ninjas.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ninjas")
public class Ninja {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {}
    public Ninja(String fname, String lName, int Age, Dojo dojo) {
    	this.firstName = fname;
    	this.lastName = lName;
    	this.age = Age;
    	this.dojo = dojo;
    }
    public String getFirstName() {
    	return this.firstName;
    }
    public String getLastName() {
    	return this.lastName;
    }
    public int getAge() {
    	return this.age;
    }
    public Dojo getDojo() {
    	return this.dojo;
    }
    public Long getId() {
    	return this.id;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    public void setLastName(String lname) {
    	this.lastName = lname;
    }
    public void setAge(int Age) {
    	this.age = Age;
    }
    public void setDojo(Dojo dojo) {
    	this.dojo = dojo;
    }
}
