package ro.sda.spring.with_di;

public class MessageValidatorAndSender {

    private MessageService messageService;

    public MessageValidatorAndSender(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String msg, String rcv) {
        if (msg == null || msg.isEmpty())
            throw new RuntimeException("Message should not be null or empty!");
        // validate msg & validate receiver
        this.messageService.sendMessage(msg, rcv);
    }
}
