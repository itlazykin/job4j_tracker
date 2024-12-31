package ru.job4j.lombok;

public class LombokBuilderUsage {
    public static void main(String[] args) {
        var role = new Role.of()
                .id(1)
                .name("ADMIN")
                .accessBy("create")
                .accessBy("update")
                .accessBy("read")
                .accessBy("delete")
                .build();
        System.out.println(role);
        var permission1 = new Permission.of()
                .id(420)
                .name("Main")
                .rules("first rules")
                .rules("second rules")
                .build();
        var permission2 = new Permission.of()
                .id(1)
                .name("Original")
                .rules("third rules")
                .rules("fourth rules")
                .rules("five rules")
                .rules("six rules")
                .rules("seven rules")
                .build();
        System.out.println(permission1);
        System.out.println(permission2);
    }
}
