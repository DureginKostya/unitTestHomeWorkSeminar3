import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void passEvenNumber() {
        Main main = new Main();
        assertTrue(main.evenOddNumber(6));
    }

    @Test
    public void passOddNumber() {
        assertFalse(main.evenOddNumber(5));
    }
}
