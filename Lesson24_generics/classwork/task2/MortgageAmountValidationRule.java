package Lesson24_generics.classwork.task2;

public class MortgageAmountValidationRule extends ValidationRule<Integer> {
    public MortgageAmountValidationRule(Integer value) {
        super(value, "Минимальный размер ипотеки - 1.000.000, а максимальный - 10.000.000");
    }

    @Override
    public boolean isValid() {
        return value >= 1000000 && value <= 10000000;
    }
}
