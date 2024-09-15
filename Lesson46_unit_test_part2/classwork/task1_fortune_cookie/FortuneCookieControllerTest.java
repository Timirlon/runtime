package Lesson46_unit_test_part2.classwork.task1_fortune_cookie;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.*;

public class FortuneCookieControllerTest {
    static FortuneCookieController positiveController;
    static FortuneCookieController negativeController;

    private static FortuneCookieController createController(boolean isPositive) {
        FortuneCookieFactory cookieFactory = new FortuneCookieFactory(
                new FortuneConfig(isPositive),
                singletonList("positive"),
                singletonList("negative")
        );

        return new FortuneCookieController(cookieFactory);
    }

    @BeforeAll
    public static void beforeAll() {
        positiveController = createController(true);
        negativeController = createController(false);
    }

    @Test
    public void shouldReturnPositiveFortune() {
        assertEquals("positive", positiveController.tellFortune().getFortuneText());
    }

    @Test
    public void shouldReturnNegativeFortune() {
        assertEquals("negative", negativeController.tellFortune().getFortuneText());
    }
}
