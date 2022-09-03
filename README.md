# tdd_harry_porter_java


To try and encourage more sales of the 5 different Harry
Potter books they sell, a bookshop has decided to offer
discounts of multiple-book purchases.

One copy of any of the five books costs 8 EUR.

If, however, you buy two different books, you get a 5%
discount on those two books.

If you buy 3 different books, you get a 10% discount.

If you buy 4 different books, you get a 20% discount.

If you go the whole hog, and buy all 5, you get a huge 25%
discount.

Note that if you buy, say, four books, of which 3 are
different titles, you get a 10% discount on the 3 that
form part of a set, but the fourth book still costs 8 EUR.

Your mission is to write a piece of code to calculate the
price of any conceivable shopping basket (containing only
Harry Potter books), giving as big a discount as possible.

For example, how much does this basket of books cost?

2 copies of the first book
2 copies of the second book
2 copies of the third book
1 copy of the fourth book
1 copy of the fifth book

Answer: 51.20 EUR. We apply 2 times a discount for four books. 4 * 8 * 0.8 * 2 = 51.20.


Test cases:
1. 3 copies of same book purchase no discount and cost 8 * 3
2. 3 copies of first book, 1 copy of the second book purchase get 5% discount, 8 * 2 * 0.05 + 8 * 2
3. 2 copies of first book, 2 copies of the second book purchase get 5% discount, 8 * 2 * 0.05 * 2
4. 3 copies of first book, 2 copies of the second book and 1 copy of 3rd book purchase cost=8 * 3 * 0.1 + 8 * 2 * .05 + 8 * 1
5. 3 copies of first book, 2 copies of the second book and 2 copies of 3rd book purchase cost=8 * 3 * 0.1 * 2 + 8 * 1
6. 3 copies of first book, 2 copies of the second book, 2 copies of 3rd book and 1 copies of 4th book purchase, cost=8 * 4 * 0.2 + 8 * 3 * .1 + 8
7. 3 copies of first book, 2 copies of the second book, 2 copies of 3rd book and 2 copies of 4th book purchase and 1 vopy of 5th book,
     cost=8 * 5 * 0.25 + 8 * 4 * .2 + 8
