package machine;
import java.util.Scanner;

public class CoffeeMachine {
     static int water = 400;
     static int milk = 540;
     static int coffeeBeans = 120;
     static int disposableCups = 9;
     static int money = 550;

    public static void displayCoffeeMachine(){
        String display = "\nThe coffee machine has:\n" +
                water+" ml of water\n" +
                milk+" ml of milk\n" +
                coffeeBeans+ " g of coffee beans\n" +
                disposableCups+ " disposable cups\n" +
                "$"+money+" of money";
        System.out.println(display);
    }

    public static String userChoice(){
        Scanner scanner = new Scanner(System.in);
        return  scanner.nextLine() ;
    }
    public static int fillChoice(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("\nWrite action (buy,fill,take,remaining,exit):");
            String choice = userChoice();
            if(choice.equals("remaining"))
                displayCoffeeMachine();
            if(choice.equals("exit"))
                break;
        switch (choice){
            case "buy": System.out.println("\nWhat do you want to buy? 1 - espresso," +
                        " 2 - latte, 3 - cappuccino, back - to main menu:");
                        choice = userChoice();

                        if(choice.equals("back"))
                            break;
                        if(choice.equals("1")){

                            if(water-250>=0 && coffeeBeans-16>=0 && disposableCups>=1){
                               water-=250;
                               coffeeBeans-=16;
                               money+=4;
                               disposableCups--;
                               System.out.println("I have enough resources, making you a coffee!");
                            }
                            else{
                                if(water-250>=0)
                                    System.out.println("Sorry, not enough coffee beans!");
                                else
                                    System.out.println("Sorry, not enough water!");
                            }

                        }
                        if(choice.equals("2")){
                            if(water-350>=0 && coffeeBeans-20>=0 && milk-75>=0 && disposableCups>=1){
                               water-=350;
                               milk-=75;
                               coffeeBeans-=20;
                               money+=7;
                               disposableCups--;
                               System.out.println("I have enough resources, making you a coffee!");
                            }
                            else{
                                if(water-350<0)
                                    System.out.println("Sorry, not enough water!");
                                else if(coffeeBeans-20<0)
                                    System.out.println("Sorry, not enough coffee beans!");
                                else if(milk-75<0)
                                    System.out.println("Sorry, not enough milk!");
                            }

                        }
                        if(choice.equals("3")){
                            if(water-200>=0 && coffeeBeans-12>=0 && milk-100>=0 && disposableCups>=1){
                              water-=200;
                              milk-=100;
                              coffeeBeans-=12;
                              money+=6;
                              disposableCups--;
                              System.out.println("I have enough resources, making you a coffee!");
                            }
                            else {
                               if(water-200<0)
                                    System.out.println("Sorry, not enough water!");
                                else if(coffeeBeans-12<0)
                                    System.out.println("Sorry, not enough coffee beans!");
                                else if(milk-100<0)
                                    System.out.println("Sorry, not enough milk!");
                            }

                        }

            break;
            case "fill": System.out.println("\nWrite how many ml of water you want to add:");
                         water+=  fillChoice();
                         System.out.println("Write how many ml of milk you want to add:");
                         milk+= fillChoice();
                         System.out.println("Write how many grams of coffee beans you want to add:");
                         coffeeBeans+= fillChoice();
                         System.out.println("Write how many disposable cups you want to add:");
                         disposableCups+= fillChoice();
                         break;
            case "take": System.out.println("\nI gave you $"+money);
                         money=0;
            break;
        }
        }

    }
}
