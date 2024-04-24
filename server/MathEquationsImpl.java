import java.rmi.RemoteException;

// Removed unnecessary import statement

public class MathEquationsImpl implements MathEquations {

    private double balance = 0;

    // Constructor

    public MathEquationsImpl() throws RemoteException {
    }

    // Methods of math equations

    // Method to add two numbers
    public double add(double a, double b) {
        return a + b;
    }

    // Method to subtract two numbers
    public double subtract(double a, double b) {
        return a - b;
    }

    // Method to multiply two numbers
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method to divide two numbers
    public double divide(double a, double b) {
        return a / b;
    }

    // Method to calculate power of a number
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Method to calculate square root of a number
    public double squareRoot(double a) {
        return Math.sqrt(a);
    }

    // Method to calculate cube root of a number
    public double cubeRoot(double a) {
        return Math.cbrt(a);
    }

    // Method to calculate factorial of a number
    public double factorial(double a) {
        double result = 1;
        for (int i = 1; i <= a; i++) {
            result = result * i;
        }
        return result;
    }

    // Method to calculate absolute value of a number
    public double absolute(double a) {
        return Math.abs(a);
    }

    // Method to calculate modulus of two numbers
    public double mod(double a, double b) {
        return a % b;
    }

    // Method to calculate maximum of two numbers
    public double max(double a, double b) {
        return Math.max(a, b);
    }

    // Method to calculate minimum of two numbers
    public double min(double a, double b) {
        return Math.min(a, b);
    }

    @Override
    public void crediter(double amount) throws RemoteException {
        balance += amount;
    }

    @Override
    public void debiter(double amount) throws RemoteException {
        if (balance >= amount) {
            balance -= amount;
        } else {
            throw new RemoteException("Insufficient balance");
        }
    }

    @Override
    public double lire_solde() throws RemoteException {
        return balance;
    }
}
