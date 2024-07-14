import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int maximumAttempts = 10;
            int totalScore = 0;
            int turn = 1;

            System.out.println("Welcome to Guess the Number Game!");
            System.out.println("You have " + maximumAttempts + " attempts to guess the correct number.");
            System.out.println("Let's start the game!");

            while (true) {
                int randomNumber = random.nextInt(100) + 1;
                int attempts = 0;
                boolean guessed = false;

                System.out.println("\nRound " + turn + " begins!");
                while (attempts < maximumAttempts) {
                    System.out.print("Enter your guess (1-100): ");
                    int userGuess = scanner.nextInt();
                    attempts++;

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the number correctly.");
                        guessed = true;
                        break;
                    } else if (userGuess < randomNumber) {
                        System.out.println("Your guess is too low.");
                    } else {
                        System.out.println("Your guess is too high.");
                    }
                }

                if (!guessed) {
                    System.out.println("Sorry! You've used all attempts. The number was " + randomNumber);
                }

                int points = maximumAttempts - attempts + 1;
                totalScore += guessed ? points : 0;
                System.out.println("Round " + turn + " score: " + (guessed ? points : 0));
                System.out.println("Total score: " + totalScore);

                System.out.print("Do you want to play another round? (yes/no): ");
                String playAgain = scanner.next();
                if (!playAgain.equalsIgnoreCase("yes")) {
                    break;
                }
                turn++;
            }

            System.out.println("Thank you for playing! Your final score is: " + totalScore);
            scanner.close();
        }
    }

