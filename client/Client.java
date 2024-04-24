import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Application {

    private MathEquations mathEq;

    @Override
    public void start(Stage primaryStage) {
        try {
            // Connect to RMI server
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            mathEq = (MathEquations) registry.lookup("MathEquations");

            // Create UI components
            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10));
            gridPane.setVgap(5);
            gridPane.setHgap(5);

            TextField num1Field = new TextField();
            TextField num2Field = new TextField();
            Label resultLabel = new Label();

            // Buttons for mathematical operations
            Button addButton = new Button("Add");
            Button subtractButton = new Button("Subtract");
            Button multiplyButton = new Button("Multiply");
            Button divideButton = new Button("Divide");
            Button powerButton = new Button("Power");
            Button squareRootButton = new Button("Square Root");
            Button cubeRootButton = new Button("Cube Root");
            Button factorialButton = new Button("Factorial");
            Button absoluteButton = new Button("Absolute");
            Button modButton = new Button("Mod");
            Button maxButton = new Button("Max");
            Button minButton = new Button("Min");

            // Buttons for banking operations
            Button creditButton = new Button("Credit");
            Button debitButton = new Button("Debit");
            Button checkBalanceButton = new Button("Check Balance");

            // Add event handlers for mathematical operations
            addButton.setOnAction(
                    e -> calculateAndDisplayResult("Add", num1Field.getText(), num2Field.getText(), resultLabel));
            subtractButton.setOnAction(
                    e -> calculateAndDisplayResult("Subtract", num1Field.getText(), num2Field.getText(), resultLabel));
            multiplyButton.setOnAction(
                    e -> calculateAndDisplayResult("Multiply", num1Field.getText(), num2Field.getText(), resultLabel));
            divideButton.setOnAction(
                    e -> calculateAndDisplayResult("Divide", num1Field.getText(), num2Field.getText(), resultLabel));
            powerButton.setOnAction(
                    e -> calculateAndDisplayResult("Power", num1Field.getText(), num2Field.getText(), resultLabel));
            squareRootButton.setOnAction(e -> {
                String num1Str = num1Field.getText().trim();
                if (!num1Str.isEmpty()) {
                    calculateAndDisplayResult("Square Root", num1Str, null, resultLabel);
                } else {
                    resultLabel.setText("Error: Please enter a number.");
                }
            });
            cubeRootButton.setOnAction(e -> {
                String num1Str = num1Field.getText().trim();
                if (!num1Str.isEmpty()) {
                    calculateAndDisplayResult("Cube Root", num1Str, null, resultLabel);
                } else {
                    resultLabel.setText("Error: Please enter a number.");
                }
            });
            factorialButton.setOnAction(e -> {
                String num1Str = num1Field.getText().trim();
                if (!num1Str.isEmpty()) {
                    calculateAndDisplayResult("Factorial", num1Str, null, resultLabel);
                } else {
                    resultLabel.setText("Error: Please enter a number.");
                }
            });
            absoluteButton.setOnAction(e -> {
                String num1Str = num1Field.getText().trim();
                if (!num1Str.isEmpty()) {
                    calculateAndDisplayResult("Absolute", num1Str, null, resultLabel);
                } else {
                    resultLabel.setText("Error: Please enter a number.");
                }
            });
            modButton.setOnAction(
                    e -> calculateAndDisplayResult("Mod", num1Field.getText(), num2Field.getText(), resultLabel));
            maxButton.setOnAction(
                    e -> calculateAndDisplayResult("Max", num1Field.getText(), num2Field.getText(), resultLabel));
            minButton.setOnAction(
                    e -> calculateAndDisplayResult("Min", num1Field.getText(), num2Field.getText(), resultLabel));

            // Add event handlers for banking operations
            creditButton.setOnAction(e -> performCredit(Double.parseDouble(num1Field.getText()), resultLabel));
            debitButton.setOnAction(e -> performDebit(Double.parseDouble(num1Field.getText()), resultLabel));
            checkBalanceButton.setOnAction(e -> performCheckBalance(resultLabel));

            // Add components to grid pane
            gridPane.add(new Label("Number 1:"), 0, 0);
            gridPane.add(num1Field, 1, 0);
            gridPane.add(new Label("Number 2:"), 0, 1);
            gridPane.add(num2Field, 1, 1);

            gridPane.add(addButton, 0, 2);
            gridPane.add(subtractButton, 1, 2);
            gridPane.add(multiplyButton, 2, 2);
            gridPane.add(divideButton, 3, 2);
            gridPane.add(powerButton, 0, 3);
            gridPane.add(squareRootButton, 1, 3);
            gridPane.add(cubeRootButton, 2, 3);
            gridPane.add(factorialButton, 3, 3);
            gridPane.add(absoluteButton, 0, 4);
            gridPane.add(modButton, 1, 4);
            gridPane.add(maxButton, 2, 4);
            gridPane.add(minButton, 3, 4);

            gridPane.add(creditButton, 0, 5);
            gridPane.add(debitButton, 1, 5);
            gridPane.add(checkBalanceButton, 2, 5);

            gridPane.add(resultLabel, 0, 6, 4, 1);

            // Set scene and show stage
            Scene scene = new Scene(gridPane, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("RMI Client UI");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAndDisplayResult(String operation, String num1Str, String num2Str, Label resultLabel) {
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = 0;
            if (num2Str != null) {
                num2 = Double.parseDouble(num2Str);
            }
            double result = 0;
            switch (operation) {
                case "Add":
                    result = mathEq.add(num1, num2);
                    break;
                case "Subtract":
                    result = mathEq.subtract(num1, num2);
                    break;
                case "Multiply":
                    result = mathEq.multiply(num1, num2);
                    break;
                case "Divide":
                    result = mathEq.divide(num1, num2);
                    break;
                case "Power":
                    result = mathEq.power(num1, num2);
                    break;
                case "Square Root":
                    result = mathEq.squareRoot(num1);
                    break;
                case "Cube Root":
                    result = mathEq.cubeRoot(num1);
                    break;
                case "Factorial":
                    result = mathEq.factorial(num1);
                    break;
                case "Absolute":
                    result = mathEq.absolute(num1);
                    break;
                case "Mod":
                    result = mathEq.mod(num1, num2);
                    break;
                case "Max":
                    result = mathEq.max(num1, num2);
                    break;
                case "Min":
                    result = mathEq.min(num1, num2);
                    break;
                default:
                    result = 0;
            }
            resultLabel.setText("Result: " + result);
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void performCredit(double amount, Label resultLabel) {
        try {
            mathEq.crediter(amount);
            resultLabel.setText("Credited successfully.");
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void performDebit(double amount, Label resultLabel) {
        try {
            mathEq.debiter(amount);
            resultLabel.setText("Debited successfully.");
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    private void performCheckBalance(Label resultLabel) {
        try {
            double balance = mathEq.lire_solde();
            resultLabel.setText("Balance: " + balance);
        } catch (Exception ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
