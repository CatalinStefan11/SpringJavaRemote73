package ro.sda.spring.with_di;

public class EmailServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rcv) {
        // logic to send email
        System.out.println("Email sent to " + rcv + " with message " + msg);
    }
}
