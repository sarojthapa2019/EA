package cs544.application05;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class CustomerDao {
	@PersistenceContext
	private EntityManager em;
	
	public List<Customer> getAll() {
		return em.createQuery("from Customer", Customer.class).getResultList();
	}
}
