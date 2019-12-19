import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    @GeneratedValue
    private Long id;
    private String doctortype;
    private String firstname;
    private String lastname;

    public Doctor(){}

    public Doctor(String doctortype, String fn, String ln){
        this.doctortype = doctortype;
        this.firstname = fn;
        this.lastname = ln;
    }

    public Long getId() {
        return id;
    }

    public String getDoctortype() {
        return doctortype;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
