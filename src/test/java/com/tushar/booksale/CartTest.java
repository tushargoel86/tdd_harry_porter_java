package com.tushar.booksale;

import com.tushar.booksale.discount.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    private Cart cart;

    @BeforeEach
    public void setup() {
        List<DiscountStrategy> discountStrategyList =
                List.of(new NoDiscountStrategy(),
                        new FivePercentageDiscountStrategy(),
                        new TenPercentageDiscountStrategy(),
                        new TwentyPercentageDiscountStrategy(),
                        new TwentyFivecentageDiscountStrategy());
        this.cart = new Cart(discountStrategyList);
    }

    @Test
    @DisplayName("Should not get any discount for 1 copy of a single book purchase")
    public void testForSingleBook() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 1);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(8.0, price.doubleValue());
    }

    @Test
    @DisplayName("Should not get any discount for 3 copy of a single book purchase")
    public void testForSingleBook2() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 3);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(24.0, price.doubleValue());
    }

    @Test
    @DisplayName("Should get discount of 5 percent for 2 copies of 1st book and 2 copies of 2nd book")
    public void testForTwoBooks() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 2,
                                          new Book("Title-2", "8"), 2);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(4 * 8.0 * .95, price.doubleValue());
    }

    @Test
    @DisplayName("Should get discount of 5 percent for 3 copies of 1st book and 2 copies of 2nd book")
    public void testForTwoDifferentBooks2() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 3,
                new Book("Title-2", "8"), 2);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(4 * 8.0 * .95 + 8.0, price.doubleValue());
    }

    @Test
    @DisplayName("Should get discount of 10 percent for 3 copies of 1st book, 2 copies of 2nd book" +
            " and 1 copy of 3rd book")
    public void testForThreeDifferentBooks() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 3,
                new Book("Title-2", "8"), 2,
                new Book("Title-3", "8"), 1);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(3 * 8.0 * .9 + 2 * 8.0 * .95 + 8.0, price.doubleValue());
    }

    @Test
    @DisplayName("Should get discount of 20% for 3 copies of first book, 2 copies" +
            " of second book, 2 copies of 3rd book and 1 copy of fourth book")
    public void testForFourDifferentBooks() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 3,
                new Book("Title-2", "8"), 2,
                new Book("Title-3", "8"), 2,
                new Book("Title-4", "8"), 1);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(4 * 8.0 * .8 + 3 * 8.0 * .9 + 8.0, price.doubleValue());
    }
    @Test
    @DisplayName("Should get 25% and 10% discount for 2 copies of 1st book," +
            "2 copies of 2nd book, 2 copies of 3rd book, 1 copy of 4th book and 1 copy of 5th book")
    public void testForFiveDifferentBooks() {
        Map<Book, Integer> data = Map.of(new Book("Title-1", "8"), 2,
                new Book("Title-2", "8"), 2,
                new Book("Title-3", "8"), 2,
                new Book("Title-4", "8"), 1,
                new Book("Title-5", "8"), 1);
        BigDecimal price = calculateValueForGivenItems(data);
        verifyValue(5 * 8.0 * .75 + 3 * 8.0 * .9, price.doubleValue());
    }

    private void verifyValue(double required, double actual) {
        assertEquals(required, actual);
    }

    private BigDecimal calculateValueForGivenItems(Map<Book, Integer> data) {
        for (Map.Entry<Book, Integer> entry: data.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                cart.addBook(entry.getKey());
            }
        }
        return cart.calculate();
    }
}
