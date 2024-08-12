package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .flatMap(Stream::ofNullable)
                .filter(product -> (product.standard() - product.actual()) >= 0)
                .filter(product -> (product.standard() - product.actual()) <= 3)
                .map(product -> new Label(product.name(), product.price() / 2))
                .map(Label::toString)
                .toList();
    }
}
