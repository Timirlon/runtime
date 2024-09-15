package Lesson46_unit_test_part2.classwork.task1_fortune_cookie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FortuneFactoryTest {
    FortuneCookieFactory cookieFactory;

    @BeforeEach
    public void beforeEach() {
        cookieFactory = new FortuneCookieFactory(
                new FortuneConfig(true),
                singletonList("positive"),
                singletonList("negative")
        );
    }

    @Test
    public void shouldIncrementCountByOneAfterOneCookieBaked() {
        cookieFactory.bakeFortuneCookie();

        assertEquals(1, cookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldIncrementCountByTwoAfterTwoCookiesBaked() {
        cookieFactory.bakeFortuneCookie();
        cookieFactory.bakeFortuneCookie();

        assertEquals(2, cookieFactory.getCookiesBaked());
    }

    @Test
    public void shouldSetCounterToZeroAfterResetCookieCallCreated() {
        cookieFactory.bakeFortuneCookie();

        assertEquals(1, cookieFactory.getCookiesBaked());

        cookieFactory.resetCookiesCreated();

        assertEquals(0, cookieFactory.getCookiesBaked());
    }
}
