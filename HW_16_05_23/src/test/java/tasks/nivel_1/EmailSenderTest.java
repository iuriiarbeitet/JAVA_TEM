package tasks.nivel_1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EmailSenderTest {
    @Mock
    private EmailSender emailSender;

    @Captor
    private ArgumentCaptor<String> recipientCaptor;

    @Captor
    private ArgumentCaptor<String> messageCaptor;

    @Test
    public void testSendEmail() {
        String recipient = "example@example.com";
        String message = "Test message";

        emailSender.sendEmail(recipient, message);

        verify(emailSender).sendEmail(recipientCaptor.capture(), messageCaptor.capture());

        assertEquals(recipient, recipientCaptor.getValue());
        assertEquals(message, messageCaptor.getValue());
    }

}