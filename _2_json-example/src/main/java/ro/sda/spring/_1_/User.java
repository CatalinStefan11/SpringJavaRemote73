package ro.sda.spring._1_;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor  // -> this generates constructor without params
@AllArgsConstructor // -> this generates constructor with params
public class User {
    private String firstName;
    private String lastName;
    private int age;
}
