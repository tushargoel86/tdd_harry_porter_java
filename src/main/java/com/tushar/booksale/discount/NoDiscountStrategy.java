package com.tushar.booksale.discount;

public class NoDiscountStrategy implements DiscountStrategy{

    @Override
    public double discount() {
        return 0.0;
    }
}
