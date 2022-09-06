package com.tushar.booksale;

public class TwentyPercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.2;
    }
}
