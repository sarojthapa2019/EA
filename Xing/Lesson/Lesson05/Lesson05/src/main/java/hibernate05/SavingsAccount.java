package hibernate05;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("savings")
public class SavingsAccount extends Account {
	private Double APY;
}
