package com.tushar.booksale.discount;

public class FivePercentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return 0.05;
    }
}
