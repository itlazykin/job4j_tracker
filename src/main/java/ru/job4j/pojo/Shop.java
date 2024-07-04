package ru.job4j.pojo;

public class Shop {
    /**
     * Метод, который вернет индекс первой пустой ячейки.
     *
     * @param products список, в котором будем искать.
     * @return индекс первой пустой ячейки.
     */
    public static int indexOfNull(Product[] products) {
        int result = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }
}
