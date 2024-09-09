package Lesson45_unit_test.classwork.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiscountCalculatorTest {

    DiscountCalculator discountCalculator = new DiscountCalculator();

    @Test
    public void shouldGiveNoDiscountForValue999() {
        int buySum = 999;
        int expectedSum = 999;

        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        Assertions.assertEquals(expectedSum, resultSum);
    }

    @Test
    public void shouldGiveNoDiscountForValue1() {
        int buySum = 1;
        int expectedSum = 1;

        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        Assertions.assertEquals(expectedSum, resultSum);
    }

    @Test
    public void shouldGiveNoDiscountForValue333() {
        int buySum = 333;
        int expectedSum = 333;

        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        Assertions.assertEquals(expectedSum, resultSum);
    }

    @Test
    public void shouldGive2PercentDiscountForValue1000() {
        int buySum = 1000;
        int expectedSum = 980;

        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        Assertions.assertEquals(expectedSum, resultSum);
    }

    @Test
    public void shouldGive2PercentDiscountForValue2000() {
        int buySum = 2000;
        int expectedSum = 1960;

        int resultSum = discountCalculator.sumAfterDiscount(buySum);

        Assertions.assertEquals(expectedSum, resultSum);
    }
}
