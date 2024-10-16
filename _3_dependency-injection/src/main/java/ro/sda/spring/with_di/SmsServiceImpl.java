package ro.sda.spring.with_di;

public class SmsServiceImpl implements MessageService {

    @Override
    public void sendMessage(String msg, String rcv) {
        // logic to send SMS
        System.out.println("SMS sent to " + rcv + " with message " + msg);
    }
}
