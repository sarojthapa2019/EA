package hibernate06;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@NamedQueries({@NamedQuery(name = "Person.Everybody", query = "from Person")})
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private List<PhoneNumber> numbers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @OrderColumn
    private List<Account> accounts = new ArrayList<>();

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addPhonenumber(PhoneNumber phoneNumber) {
        numbers.add(phoneNumber);
    }


}
