package com.javaloop;
import java.util.Random;
import java.util.Scanner;

public class CalcFacApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a non-negative integer to calculate its factorial: ");
           
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            int number = scanner.nextInt();
            
            // Check for negative numbers
            if (number < 0) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                continue; 
            }
            
            // Calculate the factorial
            long factorial = calculateFactorial(number);
            
            System.out.println("The factorial of " + number + " is: " + factorial);
            
            break; 
        }
        
        
        System.out.println();
        System.out.println();

        //add header
        System.out.println("Welcome to the Guess the Number Game!");
        
        guessTheNumberGame(scanner);

        // Close the scanner
        if (scanner != null) {
            scanner.close();
        }
    }
     
    
    public static long calculateFactorial(int number) { 
        // Special case for 0
        if (number == 0) {
            return 1;
        }
        
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void guessTheNumberGame(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; 
        System.out.println("Let's play a game! Guess the number between 1 and 100.");

        System.out.println("Guess the number between 1 and 100:");
        
        while (true) {
            int guess = validateUserInput(scanner);
            
            // Game logic
            if (guess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (guess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            }
        }
    }
    
    
    private static int validateUserInput(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            
            // Check if input is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
                continue;
            }
            
            int guess = scanner.nextInt();
            
            
            if (guess <= 0) {
                System.out.println("Error: Number must be positive.");
                System.out.println("Please enter a positive number between 1 and 100.");
                continue;
            }
            
            
            if (guess < 1 || guess > 100) {
                System.out.println("Error: Number out of range.");
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }
            
            return guess; // Return valid input
        }
    }
}