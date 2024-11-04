import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            int targetNumber = random.nextInt(100) + 1; // Generate number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                String input = scanner.nextLine();

                // Validate input
                if (!input.matches("\\d+")) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    roundsWon++;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all your attempts. The number was " + targetNumber + ".");
            }
            totalAttempts += attempts;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        // Display final score
        System.out.println("\nGame Over! You played " + roundsWon + " rounds and made a total of " + totalAttempts + " attempts.");
        scanner.close();
    }
}
