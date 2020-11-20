import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class MainFrame extends JFrame {
    private BigDecimal result;
    private String resultCommand;
    private String valueArgument;


    public MainFrame() {
        setTitle("Calculator");
        setResizable(false);
        setLayout(new BorderLayout());
        setBounds(500, 200, 500, 500);

        result = BigDecimal.ZERO;
        resultCommand = "=";

        JPanel top = new JPanel();
        add(top, BorderLayout.CENTER);
        top.setLayout(new GridLayout(4, 3));
        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(new BorderLayout());


        JTextField inputField = new JTextField();
        doDigitButtonListener digitButtonListener = new doDigitButtonListener(inputField);
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(digitButtonListener);
            top.add(btn);
        }

        JButton add = new JButton("+");
        add.addActionListener(new doCommandAction(inputField));
        top.add(add);
        JButton minus = new JButton("-");
        minus.addActionListener(new doCommandAction(inputField));
        top.add(minus);
        JButton multiply = new JButton("*");
        multiply.addActionListener(new doCommandAction(inputField));
        top.add(multiply);
        JButton divide = new JButton("/");
        divide.addActionListener(new doCommandAction(inputField));
        top.add(divide);
        JButton pow = new JButton("^");
        pow.addActionListener(new doCommandAction(inputField));
        top.add(pow);
        JButton submit = new JButton("=");
        submit.addActionListener(new doCommandAction(inputField));
        top.add(submit);

        bottom.add(inputField, BorderLayout.CENTER);
        JButton clear = new JButton("C");
        clear.addActionListener(new doClearButtonListener(inputField));
        bottom.add(clear, BorderLayout.EAST);

        new doClearButtonListener(inputField);
    }

    private void calculate() {
        BigDecimal x = new BigDecimal(valueArgument);

        switch (resultCommand) {
            case "+":
                result = result.add(x);
                break;
            case "-":
                result = result.subtract(x);
                break;
            case "/":
                result = result.divide(x);
                break;
            case "^":
                result = result.pow(x.intValue());
                break;
        }
    }

    private class doClearButtonListener implements ActionListener {
        private JTextField inputField;

        public doClearButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            inputField.setText("");
            result = BigDecimal.ZERO;
        }
    }

    private class doDigitButtonListener implements ActionListener {
        private JTextField inputField;

        public doDigitButtonListener(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder sb = new StringBuilder(inputField.getText());
            JButton btn = (JButton) e.getSource();
            sb.append(btn.getText());
            valueArgument = btn.getText();
            inputField.setText(sb.toString());
        }
    }

    private class doCommandAction implements ActionListener {
        private JTextField inputField;

        public doCommandAction(JTextField inputField) {
            this.inputField = inputField;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (command.equals("+") || command.equals("-") || command.equals("*") || command.equals("/") || command.equals("^")) {
                resultCommand = command;
                result = new BigDecimal(inputField.getText());
                inputField.setText(inputField.getText() + command);
            } else {
                calculate();
                inputField.setText(result.toString());
            }
        }
    }
}