package siit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.db.CustomerDao;
import siit.model.Customer;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private OrderService orderService;

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    public Customer getBy(int id) {
        Customer customer = customerDao.getBy(id); // fara orders
        customer.setOrders(orderService.getBy(id));
        return customer;
    }
}
