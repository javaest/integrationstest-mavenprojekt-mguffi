package com.est.ftiti;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private PaymentService paymentService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        paymentService = Mockito.mock(PaymentService.class);
        orderService = new OrderService(paymentService);
    }

    @Test
    public void testPlaceOrder_PaymentSuccessful() {
        Order order = new Order(100.0);
     // Mock the behavior of the paymentService to return true when the processPayment method is called with the order's amount
        when(paymentService.processPayment(order.getAmount())).thenReturn(true);

        // Call the placeOrder method of the orderService with the order object and store the result
        boolean result = orderService.placeOrder(order);

        // Assert that the result of placeOrder is true
        assertTrue(result);

        // Verify that the processPayment method of the paymentService was called exactly once with the order's amount
        verify(paymentService, times(1)).processPayment(order.getAmount());

    }

    @Test
    public void testPlaceOrder_PaymentFailed() {
    	assertTrue(false);
    }
}
