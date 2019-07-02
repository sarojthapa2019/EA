package hibernate06;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("savings")
public class SavingsAccount extends Account {
	private Double APY;

    public SavingsAccount(double balance, Double APY) {
        super(balance);
        this.APY = APY;
    }
}
