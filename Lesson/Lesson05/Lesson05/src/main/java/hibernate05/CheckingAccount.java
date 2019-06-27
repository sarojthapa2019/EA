package hibernate05;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("checking")
public class CheckingAccount extends Account {
	private Double overdraftLimit;
}
