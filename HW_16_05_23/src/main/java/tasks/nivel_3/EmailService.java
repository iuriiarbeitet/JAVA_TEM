package tasks.nivel_3;

/**
 * Создайте класс EmailService, который зависит от класса EmailClient.
 * EmailClient предоставляет метод sendEmail(String recipient, String message),
 * отправляющий электронную почту. Напишите тест, используя Mockito, чтобы убедиться,
 * что метод sendEmail был вызван с правильными аргументами и обработан корректно.
 */
public class EmailService {
    private EmailClient emailClient;

    public EmailService(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    public void sendEmail(String recipient, String message) {
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient is required");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message is required");
        }
        emailClient.sendEmail(recipient, message);
    }
}