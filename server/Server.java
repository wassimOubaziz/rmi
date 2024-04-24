import java.rmi.server.UnicastRemoteObject;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            // Set hostname for the server using javaProperty
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            System.out.println("Server is running on port 9100...");

            MathEquationsImpl math = new MathEquationsImpl();

            MathEquations mathEq = (MathEquations) UnicastRemoteObject.exportObject(math, 0);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            registry.rebind("MathEquations", mathEq);

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Server exception: " + e.toString());
        }
    }
}
