package hibernate05;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {
	@EmbeddedId
	private Name name;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@OneToMany(mappedBy="owner")
	private List<Project> projects = new ArrayList<>();
}
