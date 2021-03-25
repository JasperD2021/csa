import java.util.Scanner;

public class RunGame {

    public static void main(String[] args) {
        Scanner readIn = new Scanner(System.in);

        System.out.println("Hello. Welcome to Dice War!");
        System.out.println("");

        // getting input

        System.out.println("Player 1 Die Type (Loaded (1) or Normal (2)):");
        int player1type = readIn.nextInt();

        System.out.println("Player 1 Die Number of Sides:");
        int player1sides = readIn.nextInt();

        System.out.println("Player 2 Die Type (Loaded (1) or Normal (2)):");
        int player2type = readIn.nextInt();

        System.out.println("Player 2 Die Number of Sides:");
        int player2sides = readIn.nextInt();

        System.out.println("How many rounds are played?");
        int numberOfRounds = readIn.nextInt();

        Die player1 = new Die(1);
        Die player2 = new Die(1);

        // assigning die type

        if (player1type == 1) {
            player1 = new LoadedDie(player1sides);
        }
        if (player1type == 2) {
            player1 = new Die(player1sides);
        }
        if (player2type == 1) {
            player2 = new LoadedDie(player2sides);
        }
        if (player2type == 2) {
            player2 = new Die(player2sides);
        }

        int player1score = 0;
        int player2score = 0;

        int player1sum = 0;
        int player2sum = 0;

        // running rounds

        for (int i = 1; i < numberOfRounds + 1; i++) {

            System.out.println("------------------------------------------------------------");

            int num1 = player1.roll();
            int num2 = player2.roll();

            player1sum += num1;
            player2sum += num2;

            boolean player1won = false;
            boolean tie = false;

            if (num1 > num2) {
                player1won = true;
            }

            if (num1 == num2) {
                tie = true;
            }

            String player1typestring;
            String player2typestring;

            if (player1type == 1) {
                player1typestring = "Loaded";
            }
            else {
                player1typestring = "Normal";
            }

            if (player2type == 1) {
                player2typestring = "Loaded";
            }
            else {
                player2typestring = "Normal";
            }

            System.out.println("");
            System.out.println("Player 1 is using a " + player1typestring + " die with " + player1sides + " sides.");
            System.out.println("Player 2 is using a " + player2typestring + " die with " + player2sides + " sides.");
            System.out.println("");
            System.out.println("Player 1 rolled a " + num1 + ".");
            System.out.println("Player 2 rolled a " + num2 + ".");
            System.out.println("");

            if (player1won) {
                player1score += 1;
                System.out.println("Player 1 won this roll.");
            }
            else if (tie) {
                System.out.println("Tie!");
            }
            else {
                player2score += 1;
                System.out.println("Player 2 won this roll.");
            }

            System.out.println("The scores are as follows:");
            System.out.println("Player 1: " + player1score);
            System.out.println("Player 2: " + player2score);

            System.out.println("------------------------------------------------------------");
            System.out.println("");

            // pause

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.println("");

        // score is the rounds won
        // sum is the total points (dice roll values) accumulated through all rounds
        System.out.println("Player 1's score was " + player1score + " and Player 2's score was " + player2score + ".");
        System.out.println("Player 1' averaged " + (double) player1sum/numberOfRounds + " points per round and Player 2 averaged " + (double) player2sum/numberOfRounds + " points per round. ");


        if (player1score > player2score) {
            System.out.println("PLayer 1 won!");
        }
        else if (player2score > player1score) {
            System.out.println("Player 2 won!");
        }
        else {
            System.out.println("It's a tie!");
        }


    }



}