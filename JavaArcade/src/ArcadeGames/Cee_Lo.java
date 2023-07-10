package ArcadeGames;

import java.util.*;

public class Cee_Lo
{

    public static int wins = 0;
    public static int loses = 0;
    public static int ties = 0;
    public static int bank = 100;
    public static int bet;
    public static Scanner kb = new Scanner(System.in); //Grabs User Input

    public static void main(String[] args)
    {
        int optionSelected;
        Random dRoll = new Random();

        pHelp(false,false,true);

        do{
            System.out.print(">");
            optionSelected = kb.nextInt();
            switch(optionSelected)
            {
                case 1: //STARTS GAME
                    gameStart(dRoll);
                    pHelp(false,false,false);
                    break;
                case 2: //PRINTS HELP
                    pHelp(true,false,false);
                    break;
                case 3:
                    pStats();
                    break;
                case 4:
                    System.out.println("Bank: $" + bank);
                case 5:
                    break;
                default:
                    System.out.println("Improper Selection - Select an option from the list: ");
                    pHelp(false,true,false);
            }
        }while(optionSelected != 5);

    }

    public static int[] rRoll(Random diceNum)
    {
        int[] rDiceNum = new int[3];

        rDiceNum[0] = diceNum.nextInt(6) + 1;
        rDiceNum[1] = diceNum.nextInt(6) + 1;
        rDiceNum[2] = diceNum.nextInt(6) + 1;

        return rDiceNum;
    }

    public static int rollPoints(int[] diceRolled) //POINT SYSTEM
    {
        Arrays.sort(diceRolled); //Sorts the ARRAY of dice rolls in incrementing order
        if(checkRoll(diceRolled)) //If roll is valid
        {
            //Best Roll you can get (4-5-6) Highest amount of points
            if(diceRolled[0] == 4 && diceRolled[1] == 5 && diceRolled[2] == 6)
                return 13;

            //Triple Roll Adds 6 to the number rolled
            if(diceRolled[0]==diceRolled[1] && diceRolled[1]==diceRolled[2])
                return 6 + diceRolled[0];

            // Pair + Random Number // Random Num is your number
            if(diceRolled[0]==diceRolled[1])
                return diceRolled[2];

            if(diceRolled[1]==diceRolled[2])
                return diceRolled[0];
        }
        return 0;
    }

    public static void pHelp(boolean paste, boolean jList, boolean enter)
    {
        if (paste ==true && jList == false && enter == false)
        {
            System.out.println("Basic Rules:"
                    + "Rolling 4-5-6 = Auto-Win + Win Double Amount Bet"
                    + "\nRoll Pair + Random Num means your number is the random number // Example: 4-4-6, "
                    + "your number is 6"
                    + "\nRoll Snakes Eyes(1-1-1) is an automatic loss and you LOSE TRIPLE your bet!"
                    + "\nRolling (1-2-3) you pay other person double amount of bet"
                    + "\nYou have 3 rolls. Have fun!");
            System.out.println("Select an option to get started:");
            System.out.println("	1.Start Game	");
            System.out.println("	2.Print Help	");
            System.out.println("	3.Print Stats	");
            System.out.println("	4.Check Bank	");
            System.out.println("	5.(PLACEHOLDER) EXIT	");
        }
        else if (paste == false && jList == true && enter == false)
        {
            System.out.println("Select an option to get started:");
            System.out.println("	1.Start Game	");
            System.out.println("	2.Print Help	");
            System.out.println("	3.Print Stats	");
            System.out.println("	4.Check Bank	");
            System.out.println("	5.(PLACEHOLDER) EXIT	");
        }
        else if(enter == true && paste == false && jList == false)
        {
            System.out.println("------------------------------");
            System.out.println("    ===Welcome To Cee-Lo ===");
            System.out.println("------------------------------");
            System.out.println("Select an option to get started:");
            System.out.println("	1.Start Game	");
            System.out.println("	2.Print Help	");
            System.out.println("	3.Print Stats	");
            System.out.println("	4.Check Bank	");
            System.out.println("	5.(PLACEHOLDER) EXIT	");
            System.out.println("------------------------------");
        }
        else
        {
            System.out.println("	1.Start Game	");
            System.out.println("	2.Print Help	");
            System.out.println("	3.Print Stats	");
            System.out.println("	4.Check Bank	");
            System.out.println("	5.(PLACEHOLDER) EXIT	");
        }
    }

    public static boolean checkRoll(int[]diceNum)
    {
        Arrays.sort(diceNum);
        //Highest Score + Double bet win -- IF not tied
        if (diceNum[0] == 4 && diceNum[1] == 5 && diceNum[2] == 6)
        {
            return true;
        }

        //If there's a pair -> means valid
        if (diceNum[0] == diceNum[1] || diceNum[1] == diceNum[2])
        {
            return true;
        }

        //Snake Eyes - Triple Pay
        if (diceNum[0] == diceNum[1] && diceNum[1] == diceNum[2])
        {
            return true;
        }

        //Else roll not valid
        return false;
    }

    public static void gameStart(Random diceRolled)
    {
        if(bank <= 0)
        {
            System.out.println("Sorry, it's time for you to go or you'll be in debt!");
            System.exit(0);
        }
        System.out.println("BANK: $" + bank);
        System.out.print("Bet Amount: $");
        bet = kb.nextInt();

        if (bet > bank)
        {
            System.out.println("Not "
                    + "Enough money to place bet, set a bet within your limit.");
            gameStart(diceRolled);
        }
        int[] userRolls = null;
        int[] computerRolls = null;

        for(int i = 1; i < 4; i++)
        {
            userRolls = rRoll(diceRolled);
            if(checkRoll(userRolls))
                break;
            System.out.println("ATTEMPT #" + i + "!: You rolled a (" + userRolls[0] + ", " + userRolls[1] + ", "
                    + userRolls[2] + ").");
            if (i>3)
                System.out.println("No more rolls");
        }
        System.out.println("Your Final Roll is: " + "(" + userRolls[0] + ", " + userRolls[1] + ", "
                + userRolls[2] + ")");

        for(int i = 1; i < 4; i++)
        {
            computerRolls = rRoll(diceRolled);
            if(checkRoll(computerRolls))
                break;
            System.out.println("Computer ATTEMPT #" + i + "!: Computer rolled a (" + computerRolls[0] + ", " + computerRolls[1] + ", "
                    + computerRolls[2] + ").");
            if (i>3)
                System.out.println("No more rolls");
        }
        System.out.println("Computers Final Roll is: " + "(" + computerRolls[0] + ", " + computerRolls[1] + ", "
                + computerRolls[2] + ")");

        checkWLT(userRolls, computerRolls);
    }

    public static void checkWLT(int[] userRolls, int[] computerRolls)
    {

        int userScore;
        int compScore;

        userScore = rollPoints(userRolls);
        compScore = rollPoints(computerRolls);

        //USER ROLLS 4-5-6 AUTO WIN + WIN DOUBLE BET
        if (userRolls[0] == 4 && userRolls[1] == 5 && userRolls[2] == 6)
        {
            System.out.println("NICE! You GOT (4-5-6), You WIN DOUBLE BET! You win $" + bet*2 + "! ");
            bet = bet*2;
            bank = bank + bet;
            wins++;
        }

        //USER ROLL 1-2-3 AUTO LOSE + LOSE DOUBLE BET
        else if (userRolls[0] == 1 && userRolls[1] == 2 && userRolls[2] == 3)
        {
            System.out.println("Ouch.. You rolled a 1-2-3. You lose $" + bet*2 + "...");
            bet = bet*2;
            bank = bank - bet;
            loses++;
        }

        //USER ROLL SNAKE EYES AUTO LOSE + LOSE TRIPLE BET
        else if (userRolls[0] == 1 && userRolls[1] == 1 && userRolls[2] == 1)
        {
            System.out.println("Ouch, YOU GOT SNAKE EYES! (1-1-1), PAY UP TRIPLE BET! You lost $" + bet*3 + "...");
            bet = bet*3;
            bank = bank -bet;
            loses++;
        }

        // COMPUTER ROLLS SNAKE EYE WIN + WIN TRIPLE BET
        else if (computerRolls[0] == 1 && computerRolls[1] == 1 && computerRolls[2] == 1)
        {
            System.out.println("Ouch, the COMPUTER GOT SNAKE EYES! (1-1-1), You get paid TRIPLE! You Win $" + bet*3 + "!");
            bet = bet*3;
            bank = bank + bet;
            wins++;
        }

        //COMPUTER ROLLS 1-2-3 , WIN + PAID DOUBLE
        else if (computerRolls[0] == 1 && computerRolls[1] == 2 && computerRolls[2] == 3)
        {
            System.out.println("Ouch, the COMPUTER rolled (1-2-3), You get paid DOUBLE! You Win $" + bet*2 + "!");
            bet = bet*2;
            bank = bank + bet;
            wins++;
        }

        //COMPUTER ROLLS 4-5-6 LOSE + PAY DOUBLE
        else if (computerRolls[0] == 4 && computerRolls[1] == 5 && computerRolls[2] == 6)
        {
            System.out.println("Ouch, the AI GOT (4-5-6), You lose DOUBLE BET! You lost $" + bet*2 + "... ");
            bet = bet*2;
            bank = bank - bet;
            loses++;
        }

        //USER WIN
        else if(userScore > compScore)
        {
            System.out.println("Congrats You WIN $" + bet + "!");
            bank = bank + bet;
            wins++;
        }

        //COMPUTER WINS
        else if (userScore < compScore)
        {
            System.out.println("You lost.. You lose $" + bet + "...");
            bank = bank - bet;
            loses++;
        }

        //TIE GAME DO NOTHING
        else
            System.out.println("It's a tie!");
        ties++;
    }


    public static void pStats()
    {

        System.out.println("Wins: " + wins);
        System.out.println("Lost: " + loses);
        System.out.println("Ties: " + ties);

    }
}