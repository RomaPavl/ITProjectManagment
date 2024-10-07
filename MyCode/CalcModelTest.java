import static org.junit.Assert.*;
import org.junit.Test;

public class CalcModelTest {

    @Test
    public void testAddition() {
        CalcModel model = new CalcModel();
        double result = model.performCalculation(5, 3, "+");
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        CalcModel model = new CalcModel();
        double result = model.performCalculation(5, 3, "-");
        assertEquals(2.0, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        CalcModel model = new CalcModel();
        double result = model.performCalculation(8, 7, "*");
        assertEquals(56.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        CalcModel model = new CalcModel();
        double result = model.performCalculation(10, 2, "/");
        assertEquals(5.0, result, 0.001);
    }

    @Test
    public void testDivisionByZero() {
        CalcModel model = new CalcModel();
        double result = model.performCalculation(5, 0, "/");
        assertEquals(Double.POSITIVE_INFINITY, result, 0.001);
    }
}
