package cs544.application03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return customerDao.getAll();
    }

    public void save(Customer c){
        customerDao.save(c);
    }
}
