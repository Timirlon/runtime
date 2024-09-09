package Lesson45_unit_test.classwork.task1;

public class DiscountCalculator {
    public int sumAfterDiscount(int sum) {
        if (sum < 1000) {
            return sum;
        } else {
            return (int) (sum * 0.98);
        }
    }
}