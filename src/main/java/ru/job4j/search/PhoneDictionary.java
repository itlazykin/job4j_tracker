package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (key.contains(person.surname())
                    || key.contains(person.name())
                    || key.contains(person.phone())
                    || key.contains(person.address())) {
                result.add(person);
            }
        }
        return result;
    }
}
