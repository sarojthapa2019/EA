package hibernate06;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Employee {
	@Id
	@GeneratedValue
	private Long employeeId;
	private String 	firstName;
	private String lastName;

	public Employee(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
