package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .flatMap(Stream::ofNullable)
                .map(Profile::address)
                .toList();
    }

    public static List<Address> collectSortWithoutDuplicate(List<Profile> profiles) {
        return profiles.stream()
                .flatMap(Stream::ofNullable)
                .map(Profile::address)
                .sorted(Comparator.comparing(Address::city))
                .distinct()
                .toList();
    }
}
