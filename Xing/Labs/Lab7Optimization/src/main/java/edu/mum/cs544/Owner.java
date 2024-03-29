package edu.mum.cs544;

import org.hibernate.annotations.*;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Owner {
	@Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

	@Override
	public String toString() {
		return "Owner{" +
				"id=" + id +
				", name='" + name + '\'' +
				", pets=" + pets +
				'}';
	}

	@OneToMany (cascade={CascadeType.PERSIST})
	@JoinColumn (name="clientid")

//	@LazyCollection(LazyCollectionOption.EXTRA)
//	@BatchSize(size = 47)
//	@Fetch(FetchMode.SUBSELECT)
    private List<Pet> pets;
    
	public Owner() {
	}
	public Owner(String name) {
		super();
		this.name = name;
	}
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
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
    
	
    
}
