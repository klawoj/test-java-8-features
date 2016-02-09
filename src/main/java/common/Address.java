package common;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    Long id;
    String street;
    String building;
    String city;
    AddressType type;

}
