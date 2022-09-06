package com.tushar.booksale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Book book = new Book("Title-1", 8);
        cart.addBook(book);

        double price = cart.totalValue();

        assertEquals(8.0, price);
    }

    @Test
    @DisplayName("Should not get any discount for 3 copy of a single book purchase")
    public void testForSingleBook2() {
        Book book = new Book("Title-1", 8);
        cart.addBook(book);
        cart.addBook(book);
        cart.addBook(book);

        double price = cart.totalValue();

        assertEquals(24.0, price);
    }

    @Test
    @DisplayName("Should get discount of 5 percent for 2 copies of 1st book and 2 copies of 2nd book")
    public void testForTwoBooks() {
        Book book = new Book("Title-1", 8);
        Book book2 = new Book("Title-2", 8);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book2);
        cart.addBook(book);

        double price = cart.totalValue();

        assertEquals(4 * 8.0 * .95, price);
    }

    @Test
    @DisplayName("Should get discount of 5 percent for 3 copies of 1st book and 2 copies of 2nd book")
    public void testForTwoDifferentBooks2() {
        Book book = new Book("Title-1", 8);
        Book book2 = new Book("Title-2", 8);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book2);
        cart.addBook(book);
        cart.addBook(book);

        double price = cart.totalValue();

        assertEquals(4 * 8.0 * .95 + 8, price);
    }

    @Test
    @DisplayName("Should get discount of 10 percent for 3 copies of 1st book, 2 copies of 2nd book" +
            " and 1 copy of 3rd book")
    public void testForThreeDifferentBooks() {
        Book book = new Book("Title-1", 8);
        Book book2 = new Book("Title-2", 8);
        Book book3 = new Book("Title-3", 8);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book3);
        cart.addBook(book);

        double price = cart.totalValue();

        assertEquals(3 * 8.0 * .9 + 2 * 8.0 * .95 + 8.0, price);
    }

    @Test
    @DisplayName("Should get discount of 20% for 3 copies of first book, 2 copies" +
            " of second book, 2 copies of 3rd book and 1 copy of fourth book")
    public void testForFourDifferentBooks() {
        Book book = new Book("Title-1", 8);
        Book book2 = new Book("Title-2", 8);
        Book book3 = new Book("Title-3", 8);
        Book book4 = new Book("Title-4", 8);
        cart.addBook(book);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book3);
        cart.addBook(book2);
        cart.addBook(book3);
        cart.addBook(book);
        cart.addBook(book4);

        double price = cart.totalValue();

        assertEquals(4 * 8.0 * .8 + 3 * 8.0 * .9 + 8.0, price);
    }
    @Test
    @DisplayName("Should get 25% and 10% discount for 3 copies of 1st book," +
            "2 copies of 2nd book and 1 copy of 3rd book")
    public void testForFiveDifferentBooks() {
        Book book = new Book("Title-1", 8);
        Book book2 = new Book("Title-2", 8);
        Book book3 = new Book("Title-3", 8);
        Book book4 = new Book("Title-4", 8);
        Book book5 = new Book("Title-5", 8);
        cart.addBook(book);
        cart.addBook(book2);
        cart.addBook(book3);
        cart.addBook(book2);
        cart.addBook(book3);
        cart.addBook(book);
        cart.addBook(book4);
        cart.addBook(book5);

        double price = cart.totalValue();

        assertEquals(5 * 8.0 * .75 + 3 * 8.0 * .9, price);
    }
}
