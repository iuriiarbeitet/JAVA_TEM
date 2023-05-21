package tasks.nivel_5;

public class PaymentFailedException extends Throwable {
    public String paymentFailed;


    public PaymentFailedException(String paymentFailed) {
        this.paymentFailed = paymentFailed;
    }
}
