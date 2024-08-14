package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class BankServiceTest {
    @Test
    void whenUserWasFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        User rsl = new BankService(users).findByPassport("123");
        User expected = new User("123", "name_1");
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenUserWasNotFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        User rsl = new BankService(users).findByPassport("1233");
        assertThat(rsl).isNull();
    }

    @Test
    void whenAccountWasFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        Account rsl = new BankService(users).findByRequisite("123", "321123");
        Account expected = new Account("321123", 200D);
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void whenAccountWasNoFound() {
        Map<User, List<Account>> users = Map.of(
                new User("123", "name_1"), List.of(
                        new Account("321123", 200D),
                        new Account("123321", 100D)
                )
        );
        Account rsl = new BankService(users).findByRequisite("122313", "31233");
        assertThat(rsl).isNull();

    }
}