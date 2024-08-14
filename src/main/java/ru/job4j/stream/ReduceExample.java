package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        System.out.println("агрегатный метод сведения - reduce()."
                + " Метод reduce() применяет операцию ко всем элементам потока."
                + " В этом методе понятие агрегации обобщается, так как в нем "
                + "можно самостоятельно задать критерий для получения значения. "
                + "Метод является терминальным.");
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("- reduce(BinaryOperator<T> accumulator) -  стандартный вариант метода reduce()."
                + " Применяет функцию BinaryOperator ко всем элементам потока. "
                + "Метод работает так: Например, есть поток из чисел 1, 2, 3, 4. "
                + "Нам нужно сложить все эти числа. "
                + "Метод reduce() сначала сложит первые 2 элемента - (1 + 2 = 3),"
                + " далее к этому результату будет прибавлен следующий элемент (3 + 3 = 6) и так далее,"
                + " пока не будут сложены все элементы потока."
                + " В результате весь поток будет сведен к единому результату. "
                + "В нашем случае это сумма всех чисел. "
                + "Данная форма метода возвращает Optional<T> (значение в обертке).");
        System.out.println("(left, right) - это первые 2 элемента потока, left + right - это действие, "
                + "которое нужно применить к этим элементам."
                + " На первом шаге эта операция будет выглядеть так: (1, 2) -> 1 + 2. "
                + "Сумма этих элементов становится первым элементом функции на следующем шаге: "
                + "(3, 3) -> 3 + 3 и так далее, "
                + "пока метод не сложит все элементы потока в единую сумму.");
        Optional<Integer> sum = numbers.stream()
                .reduce((left, right) -> left + right);
        System.out.println(sum.get());
        System.out.println();
        System.out.println("Вместо сложения можно применить любую другую функцию, например, умножение и т.д."
                + "Аналогично предыдущему примеру мы можем сложить и строки:");
        List<String> numbersString = List.of("Один", "Два", "Три");
        Optional<String> sumStrings = numbersString.stream()
                .reduce((left, right) -> left + ", " + right);
        System.out.println(sumStrings.get());
        System.out.println();
        System.out.println("- reduce(T identity, BinaryOperator<T> accumulator) - "
                + "эта версия метода похожа на предыдущую, "
                + "только в BinaryOperator первым параметром будет identity - значение, "
                + "к которому будет применяться второй элемент в функции."
                + " Если поток будет пуст, то identity останется значением по умолчанию. "
                + "Данная форма метода возвращает само значение (T).");
        List<Integer> numbersInt = Arrays.asList(1, 2, 3, 4);
        int sumNumbersInt = numbersInt.stream()
                .reduce(2, (Integer::sum));
        System.out.println(sumNumbersInt);
        System.out.println();
        System.out.println("reduce (U identity, BiFunction<U, ? super T,U> accumulator, BinaryOperator<U> combiner) - "
                + "расширенная версия второй формы. "
                + "accumulator здесь позволяет выполнить промежуточное действие над элементами потока, "
                + "после чего к ним будет применена агрегатная операция combiner. "
                + "Данная форма метода аналогична комбинации методов map() и второй формы reduce(),"
                + " то есть если нам нужно вернуть тип данных, отличный от входящего,"
                + " то нужно использовать эту версию метода reduce().");
        List<Person> people = Arrays.asList(
                new Person("Михаил", 35),
                new Person("Ольга", 26),
                new Person("Антон", 20),
                new Person("Виктор", 16),
                new Person("Анна", 29)
        );
        System.out.println("В строке 76 задаем первый параметр метода reduce() - identity,"
                + " равный 0, так как суммировать будем с нуля. "
                + "Если в потоке не будет элементов, заданный identity будет выведен как значение по умолчанию.");
        System.out.println();
        System.out.println("(77-81)Следующий блок кода описывает второй параметр метода reduce(), "
                + "здесь мы получаем из объектов Person промежуточное значение - возраст людей, которым более 25 лет. "
                + "На этом шаге будет создан новый поток с отобранными по условию числами 35, 26 и 29.");
        System.out.println();
        System.out.println("В строке 87 выполняем бинарную операцию по суммированию всех элементов. "
                + "На этом шаге складываются числа из предыдущего шага:");
        int sumPeople = people.stream()
                .reduce(
                        0,
                        (left, right) -> {
                            if (right.age() > 25) {
                                return left + right.age();
                            } else {
                                return left;
                            }
                        },
                        (Integer::sum)
                );
        System.out.println(sumPeople);
    }
}
