package com.tushar.booksale;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    public static final double COST_PER_BOOK = 8.0;
    private Map<Book, Integer> bookQuantityMapping;

    public Cart() {
        this.bookQuantityMapping = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
        this.bookQuantityMapping.put(book, quantity +
                    this.bookQuantityMapping.getOrDefault(book, 0));
    }

    public double totalValue() {
        return COST_PER_BOOK * this.bookQuantityMapping.values().stream()
                            .reduce(Integer::sum)
                            .orElse(0);
    }

}
