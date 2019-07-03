package cs544.application03;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<Customer> getAll() {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}
}
