package com.tushar.booksale.discount;

public class TwentyPercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.2;
    }
}
