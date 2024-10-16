package ro.sda.spring.with_di;

public class Main {

    public static void main(String[] args) {

        MessageValidatorAndSender validator = new MessageValidatorAndSender(new SmsServiceImpl());
        validator.processMessage("ALERT FOR SMS", "0799999999");

        validator = new MessageValidatorAndSender(new EmailServiceImpl());
        validator.processMessage("ALERT FOR EMAIL", "catalin@yahoo.com");

    }
}
