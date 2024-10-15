package ro.sda.spring;

import lombok.*;

// @Data -> is a shortcut for @ToString, @EqualsAndHashCode, @Getter & @Setter
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// -> why do we need to override hashcode and equals when this class is used as a KEY in a hashmap or in a hashset
// -> good to know: interview questions about: hashmap under the hood, hashset, linked-list, array-list
@EqualsAndHashCode
public class User {
    private String firstName;
    private String lastName;
    private int age;
}
