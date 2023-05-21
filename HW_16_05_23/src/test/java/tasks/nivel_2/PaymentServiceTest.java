package tasks.nivel_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


public class PaymentServiceTest {
    @Test
    public void testMakePayment() {
        // Создаем mock объект PaymentGateway
        PaymentGateway paymentGateway = mock(PaymentGateway.class);

        // Создаем объект PaymentService, передавая ему mock объект PaymentGateway
        PaymentService paymentService = new PaymentService(paymentGateway);

        // Вызываем метод makePayment с параметром 100
        paymentService.makePayment(100);

        // Проверяем, что метод processPayment был вызван с параметром 100
        verify(paymentGateway).processPayment(100);

        // Устанавливаем, что метод processPayment вернет true
        when(paymentGateway.processPayment(100)).thenReturn(true);

        // Проверяем, что метод makePayment вернул true
        boolean flag = paymentService.makePayment(100);
        assertTrue(flag);
    }
}




