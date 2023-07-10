package ArcadeGames;

import java.util.*;
public class Heads_OR_Tails {

    public static int wins = 0;
    public static int loses = 0;
    public static double bank = 100;
    public static void main(String args[])
    {

        // TODO Auto-generated constructor stub
        Random rand = new Random(); // creates random num gen

        Scanner keyboard = new Scanner(System.in);

        double UserBetAmount;
        int UserCoinFlip;
        boolean ContinuePlaying=true;
        System.out.println("Coin Flip ");
        System.out.println("-------------------");
        System.out.println("Rules: \nUser Enters an Amount\nUser will guess if the coin flip is Heads or Tails. "
                + "\nTo Win, just guess correctly if the coin is Heads or Tails");
        System.out.println("--------------------");

        do
        {
            System.out.println("Current Stats");
            System.out.println("-------------------------");
            System.out.println("Wins: " + wins + "\nLoses: " + loses);
            System.out.println("Current bank amount: $" + bank);
            System.out.print("How much are you betting?: >$");
            UserBetAmount= keyboard.nextDouble();
            System.out.println("Enter '0' for Heads or '1' for Tails:");
            UserCoinFlip = keyboard.nextInt();

            int rCoinFlip = rand.nextInt(100) + 1;

            if (rCoinFlip > 20 && UserCoinFlip == 1)
            {
                System.out.println("It's Tails! Congrats you win $" + UserBetAmount + "!");
                bank = bank + UserBetAmount;
                wins++;
            }
            else if (rCoinFlip<=20 && UserCoinFlip == 0)
            {
                System.out.println("It's Heads! Congrats you win $" + UserBetAmount + "!");
                bank = bank + UserBetAmount;
                wins++;
            }
            else
            {
                System.out.println("Ouch, you guessed wrong! You lost $" + UserBetAmount + "...");
                bank = bank - UserBetAmount;
                loses++;
            }
        }while (ContinuePlaying==true);
    }

}