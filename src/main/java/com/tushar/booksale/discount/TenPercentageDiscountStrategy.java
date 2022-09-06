package com.tushar.booksale.discount;

public class TenPercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.1;
    }
}
