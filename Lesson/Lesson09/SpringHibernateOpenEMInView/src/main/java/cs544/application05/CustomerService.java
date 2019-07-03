package cs544.application05;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public List<Customer> getCustomers() {
		return customerDao.getAll();
	}	
}
