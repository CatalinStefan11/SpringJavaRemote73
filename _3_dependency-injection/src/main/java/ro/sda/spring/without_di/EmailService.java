package ro.sda.spring.without_di;

public class EmailService {

    public void sendEmail(String msg, String rcv) {
        // logic to send email
        System.out.println("Email sent to " + rcv + " with message " + msg);
    }
}
