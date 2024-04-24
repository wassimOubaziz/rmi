import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MathEquations extends Remote {
    // Here will define API.
    public double add(double a, double b) throws RemoteException;

    public double subtract(double a, double b) throws RemoteException;

    public double multiply(double a, double b) throws RemoteException;

    public double divide(double a, double b) throws RemoteException;

    public double power(double a, double b) throws RemoteException;

    public double squareRoot(double a) throws RemoteException;

    public double cubeRoot(double a) throws RemoteException;

    public double factorial(double a) throws RemoteException;

    public double absolute(double a) throws RemoteException;

    public double mod(double a, double b) throws RemoteException;

    public double max(double a, double b) throws RemoteException;

    public double min(double a, double b) throws RemoteException;

    public void crediter(double amount) throws RemoteException;

    public void debiter(double amount) throws RemoteException;

    public double lire_solde() throws RemoteException;

}