package niccoloSciucco;

import niccoloSciucco.entities.Customer;
import niccoloSciucco.entities.Order;
import niccoloSciucco.entities.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        Product p1 = new Product(1, "Il Signore degli Anelli", "Books", 125.50);
        Product p2 = new Product(2, "Harry Potter e la Pietra Filosofale", "Boys", 15.00);
        Product p3 = new Product(3, "Smartphone Android 5G", "Electronics", 299.99);
        Product p4 = new Product(4, "Caffettiera Espresso 3 Tazze", "Kitchen", 19.90);
        Product p5 = new Product(5, "T-shirt Cotone Fiammato", "Baby", 14.99);

        Customer c1 = new Customer(11, "Mario", 2);
        Customer c2 = new Customer(12, "Marco", 2);
        Customer c3 = new Customer(13, "Maria", 2);
        Customer c4 = new Customer(14, "Augusto", 2);
        Customer c5 = new Customer(15, "Cesare", 2);

        List<Product> listProduct1 = List.of(p1, p3);
        List<Product> listProduct2 = List.of(p2, p5);
        List<Product> listProduct3 = List.of(p5, p4);
        List<Product> listProduct4 = List.of(p2, p1);
        List<Product> listProduct5 = List.of(p3, p4);

        Order order1 = new Order(21, "DELIVERED", LocalDate.of(2026, 4, 25), listProduct1, c1);
        Order order2 = new Order(22, "SHIPPED", LocalDate.of(2021, 2, 10), listProduct2, c2);
        Order order3 = new Order(23, "PROCESSING", LocalDate.now(), listProduct3, c3);
        Order order4 = new Order(24, "PENDING", LocalDate.of(2026, 3, 21), listProduct4, c4);
        Order order5 = new Order(25, "CANCELLED", LocalDate.of(2026, 5, 15), listProduct5, c5);

        List<Product> products = List.of(p1, p2, p3, p4, p5);
        List<Order> orders = List.of(order1, order2, order3, order4, order5);

        // ESERCIZIO 1
        System.out.println("ESERCIZIO 1: ");
        Map<Customer, List<Order>> ordiniCliente = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        ordiniCliente.forEach((customer, customerOrders) -> {
            System.out.println("Cliente: " + customer.getName());
            System.out.println("Ordini: " + customerOrders);
            System.out.println(" ");
        });

        System.out.println(" ");

        // ESERCIZIO 2
        System.out.println("ESERCIZIO 2: ");

        Map<Customer, Double> totaleVendite = orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomer,
                        Collectors.summingDouble(Order::calculateTotal)
                ));

        totaleVendite.forEach((customer, totalAmount) -> {
            System.out.printf("Cliente: %s (ID: %d) -> Totale Speso: %.2f€%n",
                    customer.getName(), customer.getId(), totalAmount);
        });
    }
}