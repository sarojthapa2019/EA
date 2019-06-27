package hibernate05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("cs544");

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.getTransaction().commit();

		emf.close();

	}

}
