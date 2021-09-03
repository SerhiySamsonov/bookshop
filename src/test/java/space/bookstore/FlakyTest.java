package space.bookstore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FlakyTest {

    @Test
    public void failRandomly() {
        int rand = (int) (99 / (Math.random())) % 10;
        assertTrue(rand > 3);
    }

}
