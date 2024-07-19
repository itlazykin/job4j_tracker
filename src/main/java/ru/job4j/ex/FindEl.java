package ru.job4j.ex;

public class FindEl {
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

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abus : abuses) {
            if (value.contains(abus)) {
                throw new ElementAbuseException("The key is included in the keys of prohibited keys");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
