package ro.sda.spring;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

//        User retrieved = getUser("Ioan");
//        System.out.println(retrieved.getAge());

        Optional<User> optionalUser = getUserOptional("Catalin");

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user.getAge());
        }

        System.out.println("-------------------------------");

        optionalUser = getUserOptional("Ioan");

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            System.out.println(user.getAge());
        } else {
            System.out.println("Optional is empty");
        }

    }


    public static User getUser(String firstName) {
        if (firstName.equals("Catalin"))
            return new User("Catalin", "Stefan", 26);
        else
            return null;
    }

    public static Optional<User> getUserOptional(String firstName) {
        if (firstName.equals("Catalin"))
            return Optional.of(new User("Catalin", "Stefan", 26));
        else
            return Optional.empty();
    }
}
