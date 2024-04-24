# 💻 RMI Client-Server Application 💼

## 📝 Description

The RMI Client-Server Application is a Java-based distributed system that utilizes Java RMI (Remote Method Invocation) for communication between a client and a server. It provides functionality for performing mathematical calculations and banking operations remotely.

## 🚀 Features

### 🖥️ Client

- A graphical user interface built with JavaFX for user interaction.
- Ability to perform various mathematical operations such as addition, subtraction, multiplication, division, power, square root, cube root, factorial, absolute value, modulus, maximum, and minimum.
- Capability to perform banking operations including crediting, debiting, and checking balance.
- Error handling for invalid inputs and server errors.

### 🖥️ Server

- Implements a remote interface (`MathEquations`) providing methods for mathematical calculations and banking operations.
- Uses Java RMI to expose these methods to clients over the network.
- Handles client requests by executing the requested operations and returning the results.

## 🛠️ Installation

1. Clone the repository to your local machine.
2. Make sure you have Java Development Kit (JDK) installed.
3. Compile and run the `Server` class to start the server application.
4. Compile and run the `Client` class to launch the client application.

## 📄 Usage

1. Start the server application first to ensure the client can connect to it.
2. Launch the client application.
3. Use the graphical user interface to perform mathematical calculations or banking operations.
4. View the result or error message displayed in the client's interface.

## 🛠️ Technologies Used

- Java
- JavaFX
- Java RMI

## 🤝 Contributing

Contributions to this project are welcome. You can fork the repository, make your changes, and submit a pull request.

## 📝 License

This project is licensed under the [MIT License](LICENSE).
