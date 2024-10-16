package ro.sda.spring.without_di;

public class MessageValidatorAndSender {

    private EmailService emailService;

    public MessageValidatorAndSender() {
        this.emailService = new EmailService();
    }

    public void processMessage(String msg, String rcv) {
        if (msg == null || msg.isEmpty())
            throw new RuntimeException("Message should not be null or empty!");
        // validate msg & validate receiver
        this.emailService.sendEmail(msg, rcv);
    }
}
