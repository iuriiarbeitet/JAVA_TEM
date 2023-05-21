package tasks.nivel_3;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;

class OrderServiceTest {

    @Mock
    private PaymentGateway paymentGateway;

    @Mock
    private InventoryManager inventoryManager;

    private OrderService orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(paymentGateway, inventoryManager);
    }

    @Test
    public void shouldCallProcessPaymentAndCheckStockWithCorrectArguments() {
        String item = "item";
        int quantity = 10;
        double amount = 100.0;

        Mockito.when(inventoryManager.checkStock(item, quantity)).thenReturn(true);

        orderService.placeOrder(item, quantity, amount);

        Mockito.verify(inventoryManager).checkStock(item, quantity);
        Mockito.verify(paymentGateway).processPayment(amount);
    }

    @Test
    public void shouldReturnFalseIfItemIsNotInStock() {
        String item = "item";
        int quantity = 10;
        double amount = 100.0;

        Mockito.when(inventoryManager.checkStock(item, quantity)).thenReturn(false);

        boolean result = orderService.placeOrder(item, quantity, amount);

        assertFalse(result);
    }
}