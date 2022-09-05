package com.tushar.booksale;

public class TenPercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.1;
    }
}
