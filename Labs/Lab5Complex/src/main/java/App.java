import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {
    static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");
        EntityManager em = emf.createEntityManager();

        Patient p = new Patient("Swikriti","1000N 4th", "Fairfield","52557");
        Doctor d = new Doctor("Neuro","Sujiv","Shrestha");
        Payment py = new Payment("2019-01-02",100.0);
        Appointment ap = new Appointment("2019-01-02",p,py,d);

        em.getTransaction().begin();
        em.persist(ap);
        em.getTransaction().commit();

        em.getTransaction().begin();
        List<Appointment> appList = em.createQuery("from Appointment",Appointment.class).getResultList();
        for(Appointment app:appList){
            System.out.println("Appointment id:"+app.getId()
                    +" appDate:"+app.getAppdate()
                    +" appPayDate:"+app.getPayment().getPaydate()
                    +" appAmmount:"+app.getPayment().getAmmount()
                    +" patient:"+app.getPatient().getId()
                    +" doctor:"+app.getDoctor().getId()
            );

            Patient p1 = app.getPatient();
            System.out.println("Patient id:"+p1.getId()
                    +" Name:"+p1.getName()
                    +" Street:"+p1.getStreet()
                    +" City:"+p1.getCity()
                    +" Zip:"+p1.getZip()
            );

            Doctor d1 = app.getDoctor();
            System.out.println("Doctor id:"+d1.getId()
                    +" Name:"+d1.getFirstname()+" "+d1.getLastname()
                    +" Type:"+d1.getDoctortype()
            );

        }

        em.close();
    }
}
