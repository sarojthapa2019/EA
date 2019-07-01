import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private Long id;
    private String appdate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient", referencedColumnName = "id")
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor", referencedColumnName = "id")
    private Doctor doctor;

    public Appointment(){}

    public Appointment(String appdate, Patient p, Payment pay, Doctor d){
        this.appdate = appdate;
        this.patient = p;
        this.payment = pay;
        this.doctor = d;
    }

    public Long getId() {
        return id;
    }

    public String getAppdate() {
        return appdate;
    }

    public Patient getPatient() {
        return patient;
    }

    public Payment getPayment() {
        return payment;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
