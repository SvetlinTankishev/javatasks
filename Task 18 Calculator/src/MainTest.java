import org.junit.*;
import static org.junit.Assert.*;

public class MainTest {
    public void testAdd() {
        int result1 = Main.add(2, 3);
        double result2 = Main.add(2.5, 3.5);
        String result3 = Main.add("2,5", "3,5");
    }

    @Test
    public void testSubtract() {
        int result1 = Main.subtract(5, 3);
        Assert.assertEquals(2, result1);

        double result2 = Main.subtract(5.5, 3.5);
        Assert.assertEquals(2.0, result2, 0.01);

        String result3 = Main.subtract("5,5", "3,5");
        Assert.assertEquals("2,0", result3);
    }

}
