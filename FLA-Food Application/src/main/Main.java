package main;

import java.util.Scanner;

import Observer.Kitchen;
import Observer.OrderManager;
import Observer.OrderObserver;
import builder.Order;
import payment.Payment;
import payment.PaymentContext;

public class Main {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        OrderObserver kitchen = new Kitchen();
        orderManager.addObserver(kitchen);

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Order food");
            System.out.println("2. Exit");
            System.out.println("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    orderFood(orderManager, scanner);
                    break;
                case 2:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        scanner.close();
    }

    private static void orderFood(OrderManager orderManager, Scanner scanner) {
        System.out.println("Enter food name: ");
        String itemName = scanner.nextLine();
        itemName = scanner.nextLine();

        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();

        System.out.println("Enter total price: ");
        double totalPrice = scanner.nextDouble();

        Order order = new Order.OrderBuilder()
                .withItemName(itemName)
                .withQuantity(quantity)
                .withTotalPrice(totalPrice)
                .build();

        System.out.println("Select payment method (1 for Credit Card, 2 for Cash): ");
        int paymentMethod = scanner.nextInt();

        Payment payment;

        if (paymentMethod == 1) {
            payment = new payment.CreditCard();
        } else {
            payment = new payment.Cash();
        }

        PaymentContext paymentContext = new PaymentContext(payment);

        orderManager.placeOrder(order);

        paymentContext.performPayment(order.getTotalPrice());
    }
}
