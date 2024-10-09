package Code;

public class CalcModel {
    private double firstOperand;
    private double secondOperand;
    private String operator;

    public void setFirstOperand(double operand) {
        this.firstOperand = operand;
    }

    public void setSecondOperand(double operand) {
        this.secondOperand = operand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double calculate() {
        double result = 0.0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                }
                else {
                    result = Double.POSITIVE_INFINITY;
                }
                break;
        }

        return result;
    }
}
