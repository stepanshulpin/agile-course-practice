package ru.unn.agile.temperatureconverter.view;

import javax.swing.*;

public class temperatureconverter {
    private JLabel labelHello;
    private JPanel MainPanel;
    private JLabel labelFrom;
    private JComboBox comboBoxFrom;
    private JLabel labelTo;
    private JComboBox comboBoxTo;
    private JLabel labelResult;
    private JButton buttonConvert;
    private JLabel labelStatus;
    private JTextField textField1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("temperatureconverter");
        frame.setContentPane(new temperatureconverter().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
