package Code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcModel model;
    private CalcView view;

    public CalcController(CalcModel model, CalcView view) {
        this.model = model;
        this.view = view;

        for (int i = 0; i < 10; ++i) {
            view.addNumberButtonListener(i, new NumberButtonListener(i));
        }

        view.addOperatorButtonListener(0, new OperatorButtonListener("+"));
        view.addOperatorButtonListener(1, new OperatorButtonListener("-"));
        view.addOperatorButtonListener(2, new OperatorButtonListener("*"));
        view.addOperatorButtonListener(3, new OperatorButtonListener("/"));

        view.addEqualsButtonListener(new EqualsButtonListener());
    }

    private class NumberButtonListener implements ActionListener {
        private int number;

        public NumberButtonListener(int number) {
            this.number = number;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getDisplay();
            if (!currentText.isEmpty()) {
                String[] parts = currentText.split("[=]");
                if (parts.length > 1) {
                    currentText = "";
                }
            }

            view.setDisplay(currentText + number);
        }
    }

    private class OperatorButtonListener implements ActionListener {
        private String operator;

        public OperatorButtonListener(String operator) {
            this.operator = operator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getDisplay();
            if (!currentText.isEmpty() && !currentText.endsWith(operator)) {
                String[] parts = currentText.split("[=]");
                if (parts.length > 1) {
                    currentText = parts[parts.length - 1];
                }
                model.setFirstOperand(Double.parseDouble(currentText));
                model.setOperator(operator);
                view.setDisplay(currentText + operator);
            }
        }
    }

    private class EqualsButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getDisplay();
            if (!currentText.isEmpty()) {
                String[] parts = currentText.split("[-+*/]");
                if (parts.length == 2) {
                    double firstOperand = Double.parseDouble(parts[0]);
                    double secondOperand = Double.parseDouble(parts[1]);
                    model.setFirstOperand(firstOperand);
                    model.setSecondOperand(secondOperand);
    
                    double result = model.calculate();
                    view.setDisplay(currentText + " = " + result);
                }
            }
        }
    }
}