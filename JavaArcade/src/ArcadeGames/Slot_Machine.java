package ArcadeGames;
import java.util.*;

public class Slot_Machine {


    public static int getRandomElement(int[] arr){
        Random rand=new Random();
        return arr[rand.nextInt(arr.length)];
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the SLot Machine\n");
        Scanner kb= new Scanner(System.in);
        int account;
        account=200;
        String play=new String();
        String comp=new String("GO");
        int[] nums= new int[]{1, 2, 3, 4, 5, 6, 7};

        while(account>0) {
            System.out.println("Type GO  to play");
            play=kb.next();
            if(play.equalsIgnoreCase(comp)) {
                int randNum=getRandomElement(nums);
                int randNum2=getRandomElement(nums);
                int randNum3=getRandomElement(nums);

                if(randNum==1) {
                    System.out.print(" " + "Cherry");
                } else if(randNum==2) {
                    System.out.print(" " +"Banana");
                } else if(randNum==3) {
                    System.out.print(" " +"Grapes");
                } else if(randNum==4) {
                    System.out.print(" " +"Watermelon");
                } else if(randNum==5) {
                    System.out.print(" " +"Bell");
                } else if(randNum==6) {
                    System.out.print(" " +"BAR");
                } else if(randNum==7) {
                    System.out.print(" " +"7");
                }
                if(randNum2==1) {
                    System.out.print(" " +"Cherry");
                } else if(randNum2==2) {
                    System.out.print(" " +"Banana");
                } else if(randNum2==3) {
                    System.out.print(" " +"Grapes");
                } else if(randNum2==4) {
                    System.out.print(" " +"Watermelon");
                } else if(randNum2==5) {
                    System.out.print(" " +"Bell");
                } else if(randNum2==6) {
                    System.out.print(" " +"BAR");
                } else if(randNum2==7) {
                    System.out.print(" " +"7");
                }
                if(randNum3==1) {
                    System.out.print(" " +"Cherry");
                } else if(randNum3==2) {
                    System.out.print(" " +"Banana");
                } else if(randNum3==3) {
                    System.out.print(" " +"Grapes");
                } else if(randNum3==4) {
                    System.out.print(" " +"Watermelon");
                } else if(randNum3==5) {
                    System.out.print(" " +"Bell");
                } else if(randNum3==6) {
                    System.out.print(" " +"BAR");
                } else if(randNum3==7) {
                    System.out.print(" " +"7");
                }

                if(randNum==randNum2 && randNum==randNum3 && randNum2==randNum3) {
                    if(randNum==1) {
                        account+=115;
                        System.out.println("\n " +"$115");
                    }
                    if(randNum==2) {
                        account+=120;
                        System.out.println("\n " +"$120");
                    }
                    if(randNum==3) {
                        account+=130;
                        System.out.println("\n " +"$130");
                    }
                    if(randNum==4) {
                        account+=150;
                        System.out.println("\n " +"$150");
                    }
                    if(randNum==5) {
                        account+=250;
                        System.out.println("\n " +"$250");
                    }
                    if(randNum==6) {
                        account+=50;
                        System.out.println("\n " +"$50");
                    }
                    if(randNum==7) {
                        account+=1000;
                        System.out.println("\n " +"$1000");
                        System.out.println("\n " +"JACKPOT");
                    }

                }
                account-=10;
            }
            System.out.println("\n " +"Account:" + account);
        }
    }
}