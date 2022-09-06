package com.tushar.booksale;

import com.tushar.booksale.discount.DiscountStrategy;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cart {
    private final List<Book> books;

    private List<DiscountStrategy> discountStrategies;

    public Cart(List<DiscountStrategy> discountStrategies) {
        this.books = new ArrayList<>();
        this.discountStrategies = discountStrategies;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public BigDecimal calculate() {
        Map<Book, Long> bookQuantityMap = createDistinctGroupOfBooks();
        return calculateTotalValueAfterDiscount(bookQuantityMap);
    }

    private BigDecimal calculateTotalValueAfterDiscount(Map<Book, Long> bookQuantityMap) {
        BigDecimal total = BigDecimal.ZERO;
        while (!bookQuantityMap.isEmpty()) {
            int distinctBooks = bookQuantityMap.size();
            BigDecimal price = calculateValueForPair(bookQuantityMap);
            BigDecimal base = new BigDecimal(calculateDiscountBasedOnDistinctBooks(distinctBooks));
            total = total.add(price.multiply(base));
        }
        return total;
    }

    private double calculateDiscountBasedOnDistinctBooks(int distinctBooks) {
        return 1.0 - this.discountStrategies.get(distinctBooks - 1).discount();
    }

    private static BigDecimal calculateValueForPair(Map<Book, Long> cloneMap) {
        BigDecimal price = BigDecimal.ZERO;
        for (Book key: new HashSet<>(cloneMap.keySet())) {
            price = price.add(key.getPrice());
            if (cloneMap.get(key) == 1) {
                cloneMap.remove(key);
            } else {
                cloneMap.put(key, cloneMap.get(key) - 1);
            }
        }
        return price;
    }

    private Map<Book, Long> createDistinctGroupOfBooks() {
        return this.books.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}