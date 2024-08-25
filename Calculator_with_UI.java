import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator implements ActionListener {
    int operationCode, result;
    Frame calculatorFrame;
    Button[] numberButtons = new Button[10];
    Button addButton, subtractButton, multiplyButton, divideButton, clearButton, equalsButton, decimalButton;
    Panel buttonPanel;
    TextField displayField;
    GridLayout gridLayout;
    String operand1, operand2;

    SimpleCalculator() {
        calculatorFrame = new Frame("Simple Calculator");
        buttonPanel = new Panel();
        calculatorFrame.setLayout(new FlowLayout());
        
        displayField = new TextField(20);
        calculatorFrame.add(displayField);
        
        gridLayout = new GridLayout(4, 4, 10, 15);
        buttonPanel.setLayout(gridLayout);

        // Initialize number buttons and add action listeners
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].setBackground(Color.LIGHT_GRAY);
            numberButtons[i].addActionListener(this);
            buttonPanel.add(numberButtons[i]);
        }
        
        addButton = new Button("+");
        addButton.setBackground(Color.LIGHT_GRAY);
        addButton.addActionListener(this);
        subtractButton = new Button("-");
        subtractButton.setBackground(Color.LIGHT_GRAY);
        subtractButton.addActionListener(this);
        multiplyButton = new Button("*");
        multiplyButton.setBackground(Color.LIGHT_GRAY);
        multiplyButton.addActionListener(this);
        divideButton = new Button("/");
        divideButton.setBackground(Color.LIGHT_GRAY);
        divideButton.addActionListener(this);
        clearButton = new Button("C");
        clearButton.setBackground(Color.RED);
        clearButton.addActionListener(this);
        equalsButton = new Button("=");
        equalsButton.setBackground(Color.GREEN);
        equalsButton.addActionListener(this);
        decimalButton = new Button(".");
        decimalButton.addActionListener(this);
        
        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(decimalButton);
        
        calculatorFrame.add(buttonPanel);
        calculatorFrame.setSize(300, 350);
        calculatorFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText() + i);
            }
        }
        
        if (e.getSource() == addButton) {
            operand1 = displayField.getText();
            displayField.setText("");
            operationCode = 1;
        } else if (e.getSource() == subtractButton) {
            operand1 = displayField.getText();
            displayField.setText("");
            operationCode = 2;
        } else if (e.getSource() == multiplyButton) {
            operand1 = displayField.getText();
            displayField.setText("");
            operationCode = 3;
        } else if (e.getSource() == divideButton) {
            operand1 = displayField.getText();
            displayField.setText("");
            operationCode = 4;
        } else if (e.getSource() == clearButton) {
            displayField.setText("");
        } else if (e.getSource() == equalsButton) {
            operand2 = displayField.getText();
            calculateResult();
        } else if (e.getSource() == decimalButton) {
            displayField.setText(displayField.getText() + ".");
        }
    }

    private void calculateResult() {
        try {
            int num1 = Integer.parseInt(operand1);
            int num2 = Integer.parseInt(operand2);

            switch (operationCode) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        displayField.setText("Cannot divide by 0");
                        return;
                    }
                    break;
                default:
                    result = 0;
                    break;
            }
            displayField.setText(String.valueOf(result));
        } catch (Exception ex) {
            displayField.setText("Error");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
