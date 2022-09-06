package com.tushar.booksale;

import java.math.BigDecimal;
import java.util.Objects;

public class Book {
    private String name;
    private BigDecimal price;

    public Book(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public BigDecimal getPrice() {
        return price;
    }
}
