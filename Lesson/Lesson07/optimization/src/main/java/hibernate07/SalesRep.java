package hibernate07;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.BatchSize;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class SalesRep {
	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@OneToMany(mappedBy = "salesRep", cascade=CascadeType.ALL)
	@Fetch(FetchMode.SUBSELECT)
	private List<Customer> customers = new ArrayList<>();

	@OneToOne(cascade=CascadeType.ALL)
	private Address address;

	public SalesRep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesRep(String name) {
		super();
		this.name = name;
	}

	public boolean addCustomer(Customer c) {
		if (customers.add(c)) {
			c.setSalesRep(this);
			return true;
		}
		return false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
}
