package ru.unn.agile.temperatureconverter.view;
import ru.unn.agile.temperatureconverter.viewmodel.ViewModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
    private JTextField fromField;

    private ViewModel viewModel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("temperatureconverter");
        frame.setContentPane(new temperatureconverter(new ViewModel()).MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public temperatureconverter(final ViewModel viewModel) {
        this.viewModel = viewModel;
        ViewModel.ListOfTemperatures[] operations = ViewModel.ListOfTemperatures.values();
        comboBoxFrom.setModel(new JComboBox<>(operations).getModel());
        comboBoxTo.setModel(new JComboBox<>(operations).getModel());

        backBind();
        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bind();
                temperatureconverter.this.viewModel.calculate();
                backBind();
            }
        });

        KeyAdapter keyListener = new KeyAdapter() {
            public void keyReleased(final KeyEvent e) {
                bind();
                temperatureconverter.this.viewModel.processInput();
                backBind();
            }
        };
        fromField.addKeyListener(keyListener);
    }
    private void backBind() {
        buttonConvert.setEnabled(viewModel.isConvertButtonEnabled());
        labelResult.setText(viewModel.getResultTemperature());
        labelStatus.setText(viewModel.getStatusText());
    }

    private void bind() {
        viewModel.setFromTemperature(fromField.getText());
        viewModel.setFrom((ViewModel.ListOfTemperatures) comboBoxFrom.getSelectedItem());
        viewModel.setTo((ViewModel.ListOfTemperatures) comboBoxTo.getSelectedItem());
    }
}
