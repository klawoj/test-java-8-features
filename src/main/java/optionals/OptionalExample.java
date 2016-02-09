package optionals;

import com.google.common.collect.ImmutableList;
import common.Address;
import common.Person;
import common.Sex;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

public class OptionalExample {


    static List<Address> withoutOptional() {
        Person person = new NormalService().find();
        if (person != null) {
            if (person.getSex() == Sex.M) {
                if (person.getAddresses() != null) {
                    return person.getAddresses();
                }
            }
        }
        return emptyList();
    }


    static List<Address> withOptional() {
        return new OptionalService().findOptional().filter(person -> person.getSex() == Sex.M).map(Person::getAddresses).orElse(emptyList());
    }


    static class OptionalService {
        Optional<Person> findOptional() {
            //but might as well return Optional.empty()
            return Optional.of(person);
        }
    }

    static class NormalService {
        Person find() {
            //but might return null;
            return person;
        }

    }

    static final Person person = new Person(1L, "John", "Smith", Sex.M, ImmutableList.of());

}
