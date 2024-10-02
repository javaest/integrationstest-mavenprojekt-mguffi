package com.est.ftiti;
public class OrderService {
	public static void main(String [] args) {
		System.out.println("");
	}
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(Order order) {
        boolean paymentSuccessful = paymentService.processPayment(order.getAmount());
        if (paymentSuccessful) {
            // Logik zum Abschließen der Bestellung
            return true;
        } else {
            return false;
        }
    }
}