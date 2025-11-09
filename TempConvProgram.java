// COMP3520 – Software Engineering
// Assignment 4: Clean Code & Refactoring
// Refactored by: Ashima Bhasin & Abhinav Bhatia
// Date: 8th November 2025

import java.util.Locale;
import java.util.Scanner;

public class TempConvProgram {

    // using constants prevents hidden "magic numbers" and improves maintainability
    private static final double NINE_FIFTHS = 9.0 / 5.0;
    private static final double FIVE_NINTHS = 5.0 / 9.0;
    private static final double KELVIN_OFFSET = 273.15;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // ensures consistent number formatting across systems
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Temperature Conversion App");

        boolean running = true; // descriptive variable name improves clarity
        while (running) {
            printMenu(); // extracted method avoids repeating menu code
            int userChoice = readInt(scanner, "Choose an option (1–4): ");

            // switch-case improves clarity and scalability over multiple if-else conditions
            switch (userChoice) {
                case 1 -> {
                    double celsius = readDouble(scanner, "Enter temperature in Celsius: ");
                    double fahrenheit = convertCelsiusToFahrenheit(celsius);
                    System.out.println("Result: " + fahrenheit + " °F");
                }
                case 2 -> {
                    double fahrenheit = readDouble(scanner, "Enter temperature in Fahrenheit: ");
                    double celsius = convertFahrenheitToCelsius(fahrenheit);
                    System.out.println("Result: " + celsius + " °C");
                }
                case 3 -> {
                    double celsius = readDouble(scanner, "Enter temperature in Celsius: ");
                    double kelvin = convertCelsiusToKelvin(celsius);
                    System.out.println("Result: " + kelvin + " K");
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    running = false; // simple flag-based exit improves readability
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        scanner.close();
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * NINE_FIFTHS + 32.0; // constant-based formula reduces repetition
    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32.0) * FIVE_NINTHS; // improves readability and avoids magic numbers
    }

    private static double convertCelsiusToKelvin(double celsius) {
        // negative Celsius values are physically valid (e.g., -20°C in winter),
        // so we don’t restrict them; adding the offset ensures Kelvin values remain positive
        return celsius + KELVIN_OFFSET;
    }

    private static void printMenu() {
        // extracted to enforce DRY principle and simplify future updates
        System.out.println();
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.println("3. Convert Celsius to Kelvin");
        System.out.println("4. Exit");
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < 1 || value > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number."); // polite, user-friendly error handling
            }
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Double.parseDouble(input); // allows any numeric input, including negatives
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid temperature."); // prevents crashes and confusion
            }
        }
    }
}


