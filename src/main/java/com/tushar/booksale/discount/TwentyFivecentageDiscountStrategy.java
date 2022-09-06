package com.tushar.booksale.discount;

public class TwentyFivecentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return .25;
    }
}
