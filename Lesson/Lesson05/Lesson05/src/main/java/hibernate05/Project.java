package hibernate05;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumns({ 
		@JoinColumn(name = "Emp_firstname", referencedColumnName = "firstname"),
		@JoinColumn(name = "Emp_lastname", referencedColumnName = "lastname") 
	})
	private Employee owner;
}
