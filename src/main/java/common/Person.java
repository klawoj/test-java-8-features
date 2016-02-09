package common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class Person {
    Long id;
    String name;
    String surname;
    Sex sex;
    List<Address> addresses;
}
