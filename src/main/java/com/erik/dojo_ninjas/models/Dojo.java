package com.erik.dojo_ninjas.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dojos")
public class Dojo {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    public Dojo() {}
    public Dojo(String Name) {
    	this.name = Name;
    }
    public Long getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public List<Ninja> getNinjas(){
    	return this.ninjas;
    }
    public void setId(Long Id) {
    	this.id = Id;
    }
    public void setName(String Name) {
    	this.name = Name;
    }
}
