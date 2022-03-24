package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.config.DatabaseConfig;
import siit.model.Customer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Customer> getAllCustomers() {
        return jdbcTemplate.query("SELECT * FROM CUSTOMERS", this::extractCustomer);

    }

    public Customer getBy(int customerId) {
        String sql = "SELECT * FROM CUSTOMERS WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::extractCustomer, customerId);
    }

    private Customer extractCustomer(ResultSet rs, int rowNumb) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        return new Customer(id, name, phone, email);
    }

    public void update(Customer customer) {
        String sql = "UPDATE CUSTOMERS SET name=?, phone=?, email=?, birthday=? WHERE id =?";
        jdbcTemplate.update(sql, customer.getName(), customer.getPhone(), customer.getEmail(), customer.getDate(), customer.getId());
    }
}
