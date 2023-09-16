import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void passValidNumberBottomRange() {
        assertTrue(main.numberInInterval(26));
    }

    @Test
    void passValidNumberTopRange() {
        assertTrue(main.numberInInterval(99));
    }

    @Test
    void passNotValidNumberBottomRange() {
        assertFalse(main.numberInInterval(25));
    }

    @Test
    void passNotValidNumberTopRange() {
        assertFalse(main.numberInInterval(100));
    }
}