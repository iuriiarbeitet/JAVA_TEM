package tasks.nivel_3;

/**
 * Создайте класс OrderService, который зависит от классов PaymentGateway и InventoryManager.
 * PaymentGateway содержит метод processPayment(double amount),
 * а InventoryManager содержит метод checkStock(String item, int quantity),
 * возвращающий true, если товар есть в наличии в нужном количестве,
 * и false в противном случае. Напишите тест, используя Mockito, чтобы проверить,
 * что методы processPayment и checkStock были вызваны с правильными аргументами.
 */
public class OrderService {
    private PaymentGateway paymentGateway;
    private InventoryManager inventoryManager;

    public OrderService(PaymentGateway paymentGateway, InventoryManager inventoryManager) {
        this.paymentGateway = paymentGateway;
        this.inventoryManager = inventoryManager;
    }

    public boolean placeOrder(String item, int quantity, double amount) {
        if (inventoryManager.checkStock(item, quantity)) {
            return paymentGateway.processPayment(amount);
        }
        return false;
    }
}
