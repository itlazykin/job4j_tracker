package ru.job4j.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        System.out.println("Supplier используется для создания какого-либо объекта и при этом ему не требуется входной параметр.");
        Supplier<String> supplier = () -> "New string for interface";
        System.out.println(supplier.get());
        List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> setSupplier = () -> new HashSet<>(list);
        Set<String> strings = setSupplier.get();
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
        System.out.println("Consumer (потребитель) используется в том случае, "
                + "если нам нужно применить какое-то действие или операцию к параметру (для BiConsumer два параметра)"
                + " и при этом у метода нет возвращаемого значения.");
        Consumer<String> consumer = (string) -> System.out.println(string);
        consumer.accept(supplier.get());
        BiConsumer<String, String> biConsumer = (first, second) -> System.out.println(first + second);
        biConsumer.accept(supplier.get(), " and second String");
        BiConsumer<Integer, String> integerStringBiConsumer = (first, second) -> System.out.println(first + second);
        int i = 1;
        for (String string : strings) {
            integerStringBiConsumer.accept(i++, " is " + string);
        }
        System.out.println();
        System.out.println("Predicate (утверждение) наиболее часто применяется в фильтрах и сравнении");
        Predicate<String> predicate = string -> string.isEmpty();
        System.out.println("Строка пустая: " + predicate.test(""));
        System.out.println("Строка пустая: " + predicate.test("test"));
        BiPredicate<String, Integer> condition = (string, number) -> string.contains(number.toString());
        System.out.println("Строка содержит подстроку: " + condition.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + condition.test("Name", 123));
        System.out.println();
        System.out.println("Function используется для преобразования входного параметра или двух параметров "
                + "(для Bi-формы этого функционального интерфейса) в какое-либо значение,"
                + " тип возвращаемого значения может не совпадать с типом входных параметров.");
        Function<String, Character> function = s -> s.charAt(2);
        System.out.println("Третий символ в строке: " + function.apply("first"));
        System.out.println("Третий символ в строке: " + function.apply("second"));
        BiFunction<String, Integer, String> biFunction = ((string, integer) ->
                string.concat(" ").concat(integer.toString()));
        System.out.println("Результат работы бифункции: " + biFunction.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunction.apply("String number", 12345));
        System.out.println();
        System.out.println("UnaryOperator и BinaryOperator – это разновидность Function, "
                + "в которых входные и выходные обобщенные параметры должны совпадать.");
        UnaryOperator<StringBuilder> stringBuilderUnaryOperator = stringBuilder -> stringBuilder.reverse();
        System.out.println("Строка после реверса: "
                + stringBuilderUnaryOperator.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: "
                + stringBuilderUnaryOperator.apply(new StringBuilder("tset rof gnirtS")));
    }
}
