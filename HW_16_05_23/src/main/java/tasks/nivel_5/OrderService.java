package tasks.nivel_5;

/**
 * Создайте класс OrderService, который зависит от класса PaymentGateway.
 * PaymentGateway содержит метод processPayment(double amount), который может выбросить исключение PaymentFailedException,
 * если платеж не удался. Напишите тест, используя Mockito, чтобы проверить, что при выбрасывании исключения
 * PaymentFailedException в нужных случаях, метод processPayment был обработан правильно.
 */
public class OrderService {

    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }


    public void processPayment(double amount) throws PaymentFailedException {
        paymentGateway.processPayment(amount);
    }
}
