package ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String message) {
        super(message);
    }

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                throw new ElementNotFoundException("The element you are looking for is missing from the array");
            }
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"a", "b", "six", "summer", "cat"};
        try {
            indexOf(array, "hello");
        } catch (ElementNotFoundException exception) {
            exception.printStackTrace();
        }
        try {
            indexOf(array, "cat");
        } catch (ElementNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}
