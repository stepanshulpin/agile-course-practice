package ru.unn.agile.complexnumbercalculator.view;

import ru.unn.agile.complexnumbercalculator.viewmodel.ViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private ViewModel viewModel;

    public static void main(final String[] args) {
        JFrame frame = new JFrame("CalculatorComplexNumbers");
        frame.setContentPane(new CalculatorComplexNumbers(new ViewModel()).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private CalculatorComplexNumbers(final ViewModel viewModel){
        this.viewModel = viewModel;
        backBind();
        loadOperations();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void loadOperations(){
        ViewModel.Operations[] operations = ViewModel.Operations.values();
        operationsComboBox.setModel(new JComboBox<>(operations).getModel());
    }

    private void backBind(){
        calculateButton.setEnabled(viewModel.isCalculateBottonEnabled());
    }
}
