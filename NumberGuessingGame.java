import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int totalRounds = 0;
        int totalAttempts = 0;
        String playAgain = "yes";

        while (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")) {
            System.out.println("\n--- New Round ---");
            int attempts = playRound();
            totalRounds++;
            totalAttempts += attempts;

            if (attempts < MAX_ATTEMPTS) {
                System.out.println("You guessed the number in " + attempts + " attempts.");
            } else {
                //System.out.println("You did not guess the number.");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine();
        }

        double averageAttempts = (double) totalAttempts / totalRounds;
        System.out.printf("\nGame Over! You played %d rounds with an average of %.2f attempts per round.%n", totalRounds, averageAttempts);
    }

    private static int playRound() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;

        System.out.println("Guess the number between 1 and 100.");

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = getValidGuess();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Correct! The number was " + numberToGuess + ".");
                return attempts;
            }
        }

        System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The number was " + numberToGuess + ".");
        return MAX_ATTEMPTS;
    }

    private static int getValidGuess() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
