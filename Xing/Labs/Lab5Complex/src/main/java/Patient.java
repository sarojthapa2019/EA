import javax.persistence.*;

@Entity
@SecondaryTable(name="Address", pkJoinColumns={
        @PrimaryKeyJoinColumn(name="patient_id",referencedColumnName = "id")
})
public class Patient {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(table = "Address")
    private String street;
    @Column(table = "Address")
    private String city;
    @Column(table = "Address")
    private String zip;

    public Patient(){}
    public Patient(String name, String street, String city, String zip){
        this.name = name;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }
}
