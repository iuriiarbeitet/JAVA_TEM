package tasks.nivel_3;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class EmailServiceTest {
    private EmailClient emailClient = Mockito.mock(EmailClient.class);
    private EmailService emailService = new EmailService(emailClient);

    @Test
    public void sendsEmailWithCorrectArguments() {
        String recipient = "test@example.com";
        String message = "Hello, world!";
        emailService.sendEmail(recipient, message);
        verify(emailClient).sendEmail(recipient, message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfRecipientIsNull() {
        String message = "Hello, world!";
        emailService.sendEmail(null, message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfRecipientIsEmpty() {
        String recipient = "";
        String message = "Hello, world!";
        emailService.sendEmail(recipient, message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMessageIsNull() {
        String recipient = "test@example.com";
        emailService.sendEmail(recipient, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionIfMessageIsEmpty() {
        String recipient = "test@example.com";
        String message = "";
        emailService.sendEmail(recipient, message);
    }
}