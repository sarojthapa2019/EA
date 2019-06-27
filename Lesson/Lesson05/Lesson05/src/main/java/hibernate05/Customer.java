package hibernate05;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
  @Id
  @GeneratedValue
  private int id;
  private String firstname;
  private String lastname;

  @Embedded
  @AttributeOverrides( {
    @AttributeOverride(name="street", column= @Column (name="ship_street")),
    @AttributeOverride(name="city", column=@Column(name="ship_city")),
    @AttributeOverride(name="state", column=@Column(name="ship_state")),
    @AttributeOverride(name="zip", column=@Column(name="ship_zip"))
  })
  private Address shipping;

  @Embedded
  @AttributeOverrides( {
    @AttributeOverride(name="street", column=@Column(name="bill_street")),
    @AttributeOverride(name="city", column=@Column(name="bill_city")),
    @AttributeOverride(name="state", column=@Column(name="bill_state")),
    @AttributeOverride(name="zip", column=@Column(name="bill_zip"))
  })
  private Address billing;
}
