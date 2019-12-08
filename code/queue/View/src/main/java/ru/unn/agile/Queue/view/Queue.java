package ru.unn.agile.Queue.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.unn.agile.Queue.viewmodel.ViewModel;

public class Queue {

    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField queueNewElement;
    @FXML
    private Button addElement;
    @FXML
    private Button popElement;
    @FXML
    private Button clearQueue;
    @FXML
    private Button getHead;
    @FXML
    private Button getTail;
    @FXML
    private Label queueResult;
    @FXML
    private Label status;

    @FXML
    void initialize() {
        queueNewElement.textProperty().bindBidirectional(viewModel.queueElementProperty());
        queueResult.textProperty().bindBidirectional(viewModel.queueResultProperty());
        status.textProperty().bindBidirectional(viewModel.queueStatusProperty());

        addElement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.pushProcess();
            }
        });
    }
}
