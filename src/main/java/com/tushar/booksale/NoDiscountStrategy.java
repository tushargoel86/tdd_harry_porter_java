package com.tushar.booksale;

public class NoDiscountStrategy implements DiscountStrategy{

    @Override
    public double discount() {
        return 0.0;
    }
}
