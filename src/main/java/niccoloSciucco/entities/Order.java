package niccoloSciucco.entities;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private long id;
    private String status;
    private LocalDate orderDate;
    private List<Product> products;
    private Customer customer;

    public Order(long id, String status, LocalDate orderDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.products = products;
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }

    public double calculateTotal() {
        return this.products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
