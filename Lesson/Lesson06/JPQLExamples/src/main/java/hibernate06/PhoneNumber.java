package hibernate06;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

//@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    private String type;

    public PhoneNumber(String number, String type) {
        this.number = number;
        this.type = type;
    }
}
