package ru.unn.agile.complexnumbercalculator.view;

import javax.swing.*;

public class CalculatorComplexNumbers {
    private JPanel mainPanel;
    private JPanel chooseOperationPanel;
    private JPanel enterDataPanel;
    private JPanel calculationPanel;
    private JLabel chooseLabel;
    private JComboBox operationsComboBox;
    private JLabel enterDataLabel;
    private JLabel resultLabel;
    private JButton calculateButton;
    private JTextField resultTextField;
    private JTextField firstReTextField;
    private JTextField firstImTextField;
    private JTextField secondReTextField;
    private JTextField secondImTextField;
    private JTextField degeeTextField;
    private JLabel fisrtReLabel;
    private JLabel fisrtImLabel;
    private JLabel secondReLabel;
    private JLabel secondImLabel;
    private JLabel degreeLabel;
    private JPanel errorPanel;
    private JLabel errorLabel;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("CalculatorComplexNumbers");
        frame.setContentPane(new CalculatorComplexNumbers().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
