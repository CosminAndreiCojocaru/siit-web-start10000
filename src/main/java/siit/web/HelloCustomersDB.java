package siit.web;
import siit.db.CustomerDao;
import siit.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.temporal.ChronoField;
import java.util.List;

@WebServlet("/customers_db")
public class HelloCustomersDB extends HttpServlet {

    CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.append("<html><table border=1><tr><th>ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Birthday</th></tr>");

        List<Customer> allCustomers = customerDao.getAllCustomers();
        for (Customer customer : allCustomers) {
            writer.append("<tr><td>")
                    .append(String.valueOf(customer.getId()))
                    .append("</td><td>")
                    .append(customer.getName())
                    .append("</td></tr>")
                    .append(customer.getPhone())
                    .append("<td></tr>")
                    .append(customer.getEmail())
                    .append("<td></tr>")
                    .append(String.valueOf(customer.getDate()))
                    .append("<td><td>");
        }

        writer.append("</table></html>");
    }
}
