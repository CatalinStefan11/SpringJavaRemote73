package ro.sda.spring._3_.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data // -> @Getter, @Setter, @EqualsAndHashCode, @ToString
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    private String name;

    // @Autowired annotation tells spring to injected here a bean/component of type dog
    @Autowired
    private Dog dog;
}
