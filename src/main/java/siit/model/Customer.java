package siit.model;

import siit.model.Order;

import java.sql.Date;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String phone;
    private String email;
    Date date;
    List<Order> orders;

    public Customer() {
    }

    public Customer(int id, String name) {
        this(id, name, (String)null, (String)null, (Date)null);
    }

    public Customer(int id, String name, String phone) {
        this(id, name, phone, (String)null, (Date)null);
    }

    public Customer(int id, String name, String phone, String email, Date date) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String toString() {
        return "Customer{id=" + this.id + ", name='" + this.name + "', phone='" + this.phone + "', email='" + this.email + "', date=" + this.date + "}";
    }
}
