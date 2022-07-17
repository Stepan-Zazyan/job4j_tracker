package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(x-> x.getStandard()-x.getActual() <= 3)
                .filter(x-> x.getStandard()-x.getActual() >= 0)
                .map(x-> "Label{"
                        + "name='" + x.getName() + '\''
                        + ", price=" + x.getPrice()*0.5
                        + '}')
                .collect(Collectors.toList());


    }
}
