import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        System.out.println("Let's play a game. I'll pick a number between");
        System.out.println("1 and 100, and you try to guess it.");

        Scanner sc = new Scanner(System.in);
        boolean playAgain;

        do {
            playGame();
            System.out.println("Would you like to play again? (Y/N)");
            String playAgainInput = sc.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("Y");
        } while (playAgain);

        System.out.println("Thanks for playing. Goodbye.");
    }

    static void playGame() {
        int rangeStart = 1;
        int rangeEnd = 100;
        int attempts = 0;
        int computersNumber;
        int usersGuess;

        Random random = new Random();
        computersNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;

        System.out.println("I have picked a number between " + rangeStart + " and " + rangeEnd + ".");
        System.out.println("What is your guess?");

        Scanner sc = new Scanner(System.in);

        while (true) {
            if (sc.hasNextInt()) {
                usersGuess = sc.nextInt();
                attempts++;

                if (usersGuess == computersNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempt(s)!");
                    break;
                } else if (usersGuess < computersNumber) {
                    System.out.println("Too low. Try again:");
                } else {
                    System.out.println("Too high. Try again:");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                sc.next(); // Clear the invalid input from the scanner
            }
        }
    }
}
