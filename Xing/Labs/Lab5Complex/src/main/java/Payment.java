import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double ammount;

    public Payment(){}

    public Payment(String paydate, double amm){
        this.paydate = paydate;
        this.ammount = amm;
    }

    public String getPaydate() {
        return paydate;
    }

    public double getAmmount() {
        return ammount;
    }
}
