package com.tushar.booksale;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cart {

    public static final double COST_PER_BOOK = 8.0;
    private final List<Book> books;

    private List<DiscountStrategy> discountStrategies;

    public Cart(List<DiscountStrategy> discountStrategies) {
        this.books = new ArrayList<>();
        this.discountStrategies = discountStrategies;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public double totalValue() {
        Map<Book, Long> bookQuantityMap = createIndividualGroupByBooks();
        double total = 0.0;
        while (!bookQuantityMap.isEmpty()) {
            int distinctBooks = bookQuantityMap.size();
            double price = reduceQuantityOfEachTypeAndSumThePriceAtEachIteration(bookQuantityMap);
            total += (1.0 - this.discountStrategies.get(distinctBooks - 1).discount()) * price;
        }
        return total;
    }

    private static double reduceQuantityOfEachTypeAndSumThePriceAtEachIteration(Map<Book, Long> cloneMap) {
        double price = 0;
        for (Book key: new HashSet<>(cloneMap.keySet())) {
            price += key.getPrice();
            if (cloneMap.get(key) == 1) {
                cloneMap.remove(key);
            } else {
                cloneMap.put(key, cloneMap.get(key) - 1);
            }
        }
        return price;
    }

    private Map<Book, Long> createIndividualGroupByBooks() {
        return this.books.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
/**
 *                  i
 *  1 2 1 3 2 4 1 3 5
 *  List<Set<Book>> bookset
 *  i = 0 index = 0, bookset = [[1]]
 *  i = 1, index = 0 bookset=[[1, 2]]
 *  i = 2, index = 1, bookset=[[1, 2], [1]]
 *  i = 3, index = 0, bookset[[1, 2, 3], [1]]
 *  i = 4, index = 1, bookset[[1, 2, 3], [1, 2]]
 *  i = 5, index = 0, bookset[[1, 2, 3, 4], [1, 2]]
 *  i = 6, index = 2, bookset[[1, 2, 3, 4], [1, 2], [1]]
 *  i = 7, index = 1, bookset[[1, 2, 3, 4], [1, 2, 3], [1]]
 *  i = 8, index = 0, bookset[[1, 2, 3, 4, 5], [1, 2, 3], [1]]
 *    8 * 5 * .75  + 8 * 3 * .9 = 30 +  21.6  + 8 = 59.6
 *     2* 8 * 4 * .2 + 8 = 59.2
 *
 *
 *   1 2 1 3 2 4 1 3 5
 *
 *   1 - 3, 2 - 2, 3 - 2, 4 - 1, 5 - 1
 *
 *   1 2 3 4 5
 *   1 2 3
 *   1
 */