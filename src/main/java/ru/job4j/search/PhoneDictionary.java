package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> containsSurname = person -> person.surname().contains(key);
        Predicate<Person> containsName = person -> person.name().contains(key);
        Predicate<Person> containsPhone = person -> person.phone().contains(key);
        Predicate<Person> containsAddress = person -> person.address().contains(key);
        Predicate<Person> combine = containsName
                .or(containsSurname)
                .or(containsAddress)
                .or(containsPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
