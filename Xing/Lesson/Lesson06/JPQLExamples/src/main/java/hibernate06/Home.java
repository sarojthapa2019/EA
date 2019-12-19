package hibernate06;

public class Home {
	private Person person;
	private Address address;

	public Home(Person p, Address a) {
		this.person = p;
		this.address = a;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	
}
