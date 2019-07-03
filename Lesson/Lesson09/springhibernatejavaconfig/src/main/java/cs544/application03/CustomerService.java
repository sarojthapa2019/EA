package cs544.application03;

import java.util.List;

//import javax.annotation.Resource;
//import javax.annotation.Resources;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	@PersistenceContext
	private EntityManager em;

	public List<Customer> getCustomers() {
		return customerDao.getAll();
	}
}
