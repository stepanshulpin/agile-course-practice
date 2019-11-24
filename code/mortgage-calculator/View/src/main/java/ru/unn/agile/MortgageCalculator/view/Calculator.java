package ru.unn.agile.mortgagecalculator.view;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.unn.agile.mortgagecalculator.viewmodel.ViewModel;

public class Calculator {

    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField ApartmentPrice;
    @FXML
    private TextField FirstPayment;
    @FXML
    private TextField LoanPeriod;
    @FXML
    private TextField InterestRate;
    @FXML
    private TextField MothlyComissions;
    @FXML
    private TextField OneTimeComissions;
    @FXML
    private TextArea Result;
    @FXML
    private ChoiceBox<String> LoanPeriodType;
    @FXML
    private ChoiceBox<String> InterestRateType;
    @FXML
    private ChoiceBox<String> MothlyComissionType;
    @FXML
    private ChoiceBox<String> OneTimeComissionType;
    @FXML
    private ChoiceBox<String> TypeOfPayment;
    @FXML
    private DatePicker StartDate;
    @FXML
    private Button calculate;

    @FXML
    void initialize() {
        ApartmentPrice.textProperty().bindBidirectional(viewModel.apartmentPriceProperty());
        FirstPayment.textProperty().bindBidirectional(viewModel.firstPaymentProperty());
        LoanPeriod.textProperty().bindBidirectional(viewModel.loanPeriodProperty());
        InterestRate.textProperty().bindBidirectional(viewModel.interestRateProperty());
        MothlyComissions.textProperty().bindBidirectional(viewModel.monthlyComissionsProperty());
        OneTimeComissions.textProperty().bindBidirectional(viewModel.oneTimeComisionsProperty());
        Result.textProperty().bindBidirectional(viewModel.resultProperty());
        LoanPeriodType.valueProperty().bindBidirectional(viewModel.loanPeriodTypeProperty());
        InterestRateType.valueProperty().bindBidirectional(viewModel.interestRateTypeProperty());
        MothlyComissionType.valueProperty().bindBidirectional(viewModel.monthlyComissionsTypeProperty());
        OneTimeComissionType.valueProperty().bindBidirectional(viewModel.oneTimeComisionsTypeProperty());
        TypeOfPayment.valueProperty().bindBidirectional(viewModel.typeOfPaymentProperty());
        //StartDate.converterProperty().bindBidirectional(viewModel.startDateProperty());
        calculate.setOnAction(event -> viewModel.calculate());
    }
}
