package com.tushar.booksale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    @DisplayName("Should not get any discount for 1 copy of a single book purchase")
    public void testForSingleBook() {
        Cart cart = new Cart();
        Book book = new Book("Title-1");
        cart.addBook(book, 1);

        double price = cart.totalValue();

        assertEquals(8.0, price);
    }

    @Test
    @DisplayName("Should not get any discount for 3 copy of a single book purchase")
    public void testForSingleBook2() {
        Cart cart = new Cart();
        Book book = new Book("Title-1");
        cart.addBook(book, 3);

        double price = cart.totalValue();

        assertEquals(24.0, price);
    }

//    @Test
//    @DisplayName("Should get discount of 5 percent for 3 copies of 1st book and 2 copies of 2nd book")
//    public void testForTwoBooks() {
//
//    }
}
