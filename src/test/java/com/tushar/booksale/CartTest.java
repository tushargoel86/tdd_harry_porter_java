package com.tushar.booksale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    @DisplayName("Should not get a any discount for a 1 copy of a single book purchase")
    public void testForSingleBook() {
        Cart cart = new Cart();
        cart.addBook(BookTitle.TITLE1, 1);

        double price = cart.totalValue();

        assertEquals(8, price);
    }
}
