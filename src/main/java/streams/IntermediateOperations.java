package streams;

import com.google.common.collect.ImmutableList;
import common.Address;
import common.AddressType;
import common.Person;
import common.Sex;
import terminaloperations.ImmutableCollectors;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class IntermediateOperations {


    Predicate<Address> isHomeAddresInGdynia = address -> address.getType() == AddressType.HOME && address.getCity().equals("Gdynia");

    Predicate<Person> hasHomeAddressInGdyna = person -> person.getAddresses().stream().anyMatch(isHomeAddresInGdynia);

    Comparator<Person> byId = Comparator.comparingLong(Person::getId);


    public List<Person> peopleWithHomeAddressAtGdyniaSortedById() {
        return people.stream().filter(
                hasHomeAddressInGdyna).sorted(byId)
                .collect(ImmutableCollectors.toList());
    }

    public List<Person> peopleWithHomeAddressAtGdyniSortedByIdNoLambda() {
        ArrayList<Person> resultList = new ArrayList<Person>();
        for (Person person : people) {
            boolean homeAddressInGdynia = false;
            for (Address address : person.getAddresses()) {
                if (address.getType() == AddressType.HOME && address.getCity().equals("Gdynia")) {
                    homeAddressInGdynia = true;
                    break;
                }
            }
            if (homeAddressInGdynia) {
                resultList.add(person);
            }
        }
        Collections.sort(resultList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Long.compare(o1.getId(), o2.getId());
            }
        });
        return resultList;
    }


    static final Address address1 = new Address(9L, "Al. Zwyciestwa", "256", "Gdansk", AddressType.WORK);
    static final Address address2 = new Address(10L, "Swietojanska", "12/3", "Gdynia", AddressType.OTHER);
    static final Address address3 = new Address(11L, "Al. Zwyciestwa", "256", "Gdansk", AddressType.HOME);
    static final Person person1 = new Person(1L, "John", "Smith", Sex.M, ImmutableList.of(address1, address2));
    static final Person person2 = new Person(2L, "Jan", "Kowalski", Sex.M, ImmutableList.of(address3));
    static final Person person3 = new Person(3L, "Janina", "Nowak", Sex.F, ImmutableList.of());
    static final List<Person> people = ImmutableList.of(person1, person2, person3);


    public void testCollect() {

        Map<Boolean, List<Person>> partitionByIsMale = people.stream().collect(Collectors.partitioningBy(person -> person.getSex() == Sex.M));

        //
        Map<Person, Sex> mapPersonToTheirSex = people.stream().collect(Collectors.toMap(Function.identity(), Person::getSex));


        Map<String, String> mapSurnameToCommaSeparatedListOfNames = people.stream().collect(Collectors.toMap(Person::getSurname,
                Person::getName,
                (s, a) -> s + ", " + a));


    }

}
