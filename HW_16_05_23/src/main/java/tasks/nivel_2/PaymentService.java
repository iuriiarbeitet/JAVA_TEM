package tasks.nivel_2;

/**
 * Создайте класс PaymentService, который зависит от класса PaymentGateway.
 *      PaymentGateway содержит метод processPayment(double amount), который возвращает true,
 *      если платеж успешно обработан, и false в противном случае. Напишите тест, используя Mockito,
 *      чтобы проверить, что метод processPayment был вызван и вернул ожидаемый результат.
 */
public class PaymentService {
    private PaymentGateway paymenteGateway;

    public PaymentService(PaymentGateway paymentGateway){
        this.paymenteGateway = paymentGateway;
    }
    public boolean makePayment(double amount) {
        return paymenteGateway.processPayment(amount);
    }

}
