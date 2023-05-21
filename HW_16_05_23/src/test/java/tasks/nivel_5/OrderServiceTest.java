package tasks.nivel_5;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doThrow;

public class OrderServiceTest {


    @Test
    public void testProcessPayment_PaymentFailedExceptionHandled() throws PaymentFailedException {
        PaymentGateway paymentGateway = Mockito.mock(PaymentGateway.class);
        OrderService orderService = new OrderService(paymentGateway);

        double amount = 100.0;

        doThrow(new PaymentFailedException("Payment failed")).when(paymentGateway).processPayment(anyDouble());

        assertThrows(PaymentFailedException.class, () -> orderService.processPayment(amount));
    }
}