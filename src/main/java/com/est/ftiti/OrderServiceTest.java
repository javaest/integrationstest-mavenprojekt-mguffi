package com.est.ftiti;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;




public class OrderServiceTest {
    
    @Mock
    private PaymentService paymentService; 

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder() {
        Order order = new Order(100.0);
        when(paymentService.processPayment(100.0)).thenReturn(true);
        assertTrue(orderService.placeOrder(order));

    }
    @Test
    public void testPlaceOrder_FailedPayment() {
       
        Order order = new Order(100.0); 
        when(paymentService.processPayment(order.getAmount())).thenReturn(false);

        
        boolean result = orderService.placeOrder(order);

        
        assertFalse(result); 
    }
}


