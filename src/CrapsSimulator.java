import java.util.Random;
import java.util.Scanner;

public class CrapsSimulator {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        //Variables
        int diceOne;
        int diceTwo;
        int sum;
        int point = 0;
        boolean valid = true;
        boolean contPlayingYN;
        String userInput;
        boolean reroll;

        while (valid) {
            reroll = false;
            contPlayingYN = true;

            diceOne = rand.nextInt(6) + 1;
            diceTwo = rand.nextInt(6) + 1;
            sum = diceOne + diceTwo;

            System.out.println("Roll 1: " + diceOne);
            System.out.println("Roll 1: " + diceTwo);
            System.out.println("Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Sorry, you crapped out.");
                System.out.println();
            } else if (sum == 7 || sum == 11) {
                System.out.println("You win!!!");
                System.out.println();
            } else {
                point = sum;
                System.out.println("You must roll a " + point + " in order to win. Roll a 7 and you lose.");
                System.out.println();
                reroll = true;
            }

            while (reroll) {
                diceOne = rand.nextInt(6) + 1;
                diceTwo = rand.nextInt(6) + 1;
                sum = diceOne + diceTwo;

                System.out.println("Roll 1: " + diceOne);
                System.out.println("Roll 1: " + diceTwo);
                System.out.println("Sum: " + sum);

                if (sum == 7) {
                    System.out.println("Sorry, you crapped out.");
                    reroll = false;
                    System.out.println();
                } else if (sum == point) {
                    System.out.println("You win!!!");
                    reroll = false;
                    System.out.println();
                } else {
                    System.out.println("Reroll. You must roll a " + point + " in order to win. Roll a 7 and you lose.");
                    System.out.println();
                }
            }

            System.out.println("Would you like to play again?[Y or N]");
            do {
                if (scan.hasNextLine()) {
                    userInput = scan.nextLine();
                    if (userInput.equalsIgnoreCase("N") || userInput.equalsIgnoreCase("no")) {
                        contPlayingYN = false;
                        valid = false;
                    } else if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("yes")) {
                        contPlayingYN = false;
                    } else {
                        System.out.println("Error wrong input please try again.");
                    }
                } else {
                    System.out.println("Error wrong input please try again.");
                }
            } while (contPlayingYN);

        }
    }
}
