package Code;

import static org.junit.Assert.*;
import org.junit.Test;
import Code.CalcModel;

public class CalcModelTest {

    @Test
    public void testAddition() {
        CalcModel model = new CalcModel();
        model.setFirstOperand(5.0);
        model.setSecondOperand(3.0);
        model.setOperator("+");
        double result = model.calculate();
        assertEquals(8.0, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        CalcModel model = new CalcModel();
        model.setFirstOperand(10.0);
        model.setSecondOperand(4.0);
        model.setOperator("-");
        double result = model.calculate();
        assertEquals(6.0, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        CalcModel model = new CalcModel();
        model.setFirstOperand(6.0);
        model.setSecondOperand(2.0);
        model.setOperator("*");
        double result = model.calculate();
        assertEquals(12.0, result, 0.001);
    }

    @Test
    public void testDivision() {
        CalcModel model = new CalcModel();
        model.setFirstOperand(8.0);
        model.setSecondOperand(2.0);
        model.setOperator("/");
        double result = model.calculate();
        assertEquals(4.0, result, 0.001);
    }

    @Test
    public void testDivisionByZero() {
        CalcModel model = new CalcModel();
        model.setFirstOperand(5.0);
        model.setSecondOperand(0.0);
        model.setOperator("/");
        double result = model.calculate();
        assertEquals(Double.POSITIVE_INFINITY, result, 0.001);
    }
}
