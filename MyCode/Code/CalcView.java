package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalcView {
    private JFrame frame;
    private JTextField display;
    private JGradientButton[] numberButtons;
    private JGradientButton[] operatorButtons;
    private JGradientButton equalsButton;

    public CalcView() {
        frame = new JFrame("AT 4-operations calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Ubuntu", Font.PLAIN, 24));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        numberButtons = new JGradientButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JGradientButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        operatorButtons = new JGradientButton[4];
        operatorButtons[0] = new JGradientButton("+");
        operatorButtons[1] = new JGradientButton("-");
        operatorButtons[2] = new JGradientButton("*");
        operatorButtons[3] = new JGradientButton("/");

        buttonPanel.add(new JGradientButton(""));

        equalsButton = new JGradientButton("=");
        buttonPanel.add(equalsButton);

        for (int i = 0; i < 4; ++i) {
            buttonPanel.add(operatorButtons[i]);
        }

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setFocusable(true);
    }

    public void addNumberButtonListener(int index, ActionListener listener) {
        numberButtons[index].addActionListener(listener);
    }

    public void addOperatorButtonListener(int index, ActionListener listener) {
        operatorButtons[index].addActionListener(listener);
    }

    public void addEqualsButtonListener(ActionListener listener) {
        equalsButton.addActionListener(listener);
    }

    public String getDisplay() {
        return display.getText();
    }

    public void setDisplay(String text) {
        display.setText(text);
    }

    private static class JGradientButton extends JButton {
        public JGradientButton(String text) {
            super(text);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g.create();
            g2.setPaint(new GradientPaint(
                    new Point(0, 0),
                    getBackground(),
                    new Point(0, getHeight()/3),
                    Color.GREEN.darker()));
            g2.fillRect(0, 0, getWidth(), getHeight()/3);
            g2.setPaint(new GradientPaint(
                    new Point(0, getHeight()/3),
                    Color.GREEN.darker(),
                    new Point(0, getHeight()),
                    getBackground()));
            g2.fillRect(0, getHeight()/3, getWidth(), getHeight());
            g2.dispose();

            super.paintComponent(g);
        }
    }
}