package ro.sda.spring.without_di;


/*
-> If we want to extend our app and provide additional messaging feature, such as SMS or facebook message then
we would need to write a new MessageValidator for that.

-> Testing the validator will be very difficult since our app is directly creating the email service instance.

-> Validator is responsible to initialize the email service and then use it. This leads to hard-coded dependency.
 */

public class Main {

    public static void main(String[] args) {

        MessageValidatorAndSender app = new MessageValidatorAndSender();
        app.processMessage("ALERT", "Catalin@abc.com");

    }
}
