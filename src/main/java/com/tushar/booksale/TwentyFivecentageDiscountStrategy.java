package com.tushar.booksale;

public class TwentyFivecentageDiscountStrategy implements DiscountStrategy {
    @Override
    public double discount() {
        return .25;
    }
}
