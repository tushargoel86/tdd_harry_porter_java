package com.tushar.booksale;

public class FivePercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.05;
    }
}
