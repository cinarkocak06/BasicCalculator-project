import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    
    @FXML
    private Button calculatorNumberButton;

    @FXML
    private ArrayList<String> numberList;

    private String currentNumber = "";
    private double firstNumber;
    private double secondNumber;

    @FXML
    private TextField displayField;
    
    private String currentOperation;


    public void initialize() {
        numberList = new ArrayList<>();
    }

    public void numberPressed(ActionEvent event) {
        Button button = (Button) event.getSource();

        currentNumber += button.getText();

        displayField.setText(displayField.getText() + button.getText());
    }


    public void operationPressed(ActionEvent event) {
        Button button = (Button) event.getSource();

        firstNumber = Double.parseDouble(currentNumber);

        currentOperation = button.getText();

        currentNumber = "";

        displayField.setText(displayField.getText() + currentOperation);
}

    public void clearList(ActionEvent event) {
        displayField.setText("");
        firstNumber = 0;
        secondNumber = 0;
        currentNumber = "";
        currentOperation = "";
    }

    public void changeSign(ActionEvent event) {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number *= -1;

            currentNumber = String.valueOf(number);
            displayField.setText(currentNumber);
        }
    }

    public void squareRoot(ActionEvent event) {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number = Math.sqrt(number);

            currentNumber = String.valueOf(number);
            displayField.setText(currentNumber);
        }
    }

    public void deleteDigit(ActionEvent event) {
        if (currentNumber != null && currentNumber.length() > 0) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
        }

        displayField.setText(currentNumber);
    }

    public void calculateResult(ActionEvent event) {

        secondNumber = Double.parseDouble(currentNumber);

        double result = 0;

        if ("+".equals(currentOperation)) {
            result = firstNumber + secondNumber;
            currentNumber = String.valueOf(result);
        }
        else if ("-".equals(currentOperation)) {
            result = firstNumber - secondNumber;
            currentNumber = String.valueOf(result);
        }
        else if ("x".equals(currentOperation)) {
            result = firstNumber * secondNumber;
            currentNumber = String.valueOf(result);
        }
        else if ("/".equals(currentOperation)) {
            if (secondNumber == 0) {
                displayField.setText("ERROR");
                return;
            } else {
                result = firstNumber / secondNumber;
                currentNumber = String.valueOf(result);
            }
        }
        else if ("&".equals(currentOperation)) {
            result = firstNumber % secondNumber;
            currentNumber = String.valueOf(result);
        }
        else if ("+/-".equals(currentOperation)) {
            result = firstNumber * -1;
            currentNumber = String.valueOf(result);
        }
        
        displayField.setText(String.valueOf(result));
    }
}
