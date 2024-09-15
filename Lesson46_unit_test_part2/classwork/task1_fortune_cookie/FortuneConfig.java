package Lesson46_unit_test_part2.classwork.task1_fortune_cookie;

/** Хранит конфигурацию фабрики по производству печенек с предсказаниями.*/
public class FortuneConfig {
    private final boolean isPositive;

    public FortuneConfig(boolean isPositive) {
        this.isPositive = isPositive;
    }

    public boolean isPositive() {
        return isPositive;
    }
}
