package machine;

import java.util.Scanner;

enum Coffee {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    int water;
    int milk;
    int coffeeBeans;
    int cost;

    Coffee(int water, int milk, int coffeeBeans, int cost) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cost = cost;
    }

}

public class CoffeeMachine {

    public final Scanner scanner = new Scanner(System.in);
    public int validWater, validMilk, validCoffee, disposableCups, money;

    public CoffeeMachine() {
        this.validWater = 400;
        this.validMilk = 540;
        this.validCoffee = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        while (true) {
            machine.chooseAction();
        }
    }

    public void chooseAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String choice = scanner.nextLine();
        if (choice.equals("buy")) {
            buy();
        } else if (choice.equals("fill")) {
            fill();
        } else if (choice.equals("take")) {
            System.out.println("I gave you $" + money);
            money = 0;
        } else if (choice.equals("exit")) {
            Runtime.getRuntime().exit(0);
        } else if (choice.equals("remaining")) {
            printStatus();
        } else {
            System.out.println("Invalid Input!");
            chooseAction();
        }
    }

    public void printStatus() {
        System.out.println("The coffee machine has:");
        System.out.println(validWater + " of water");
        System.out.println(validMilk + " of milk");
        System.out.println(validCoffee + " of coffee beans");
        System.out.println(disposableCups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String  choice = scanner.nextLine();
        switch (choice) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                chooseAction();
            default:
                System.out.println("Invalid Input!");
                buy();
        }
    }

    public void makeEspresso() {
        if (validWater >= Coffee.ESPRESSO.water && validCoffee >= Coffee.ESPRESSO.coffeeBeans && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            validWater -= Coffee.ESPRESSO.water;
            validCoffee -= Coffee.ESPRESSO.coffeeBeans;
            disposableCups--;
            money += Coffee.ESPRESSO.cost;
        } else if (validWater < Coffee.ESPRESSO.water) {
            System.out.println("Sorry, not enough water!");
        } else if (validCoffee < Coffee.ESPRESSO.coffeeBeans) {
            System.out.println("Sorry, not enough coffee!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void makeLatte() {
        if (validWater >= Coffee.LATTE.water && validMilk >= Coffee.LATTE.milk && validCoffee >= Coffee.LATTE.coffeeBeans && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            validWater -= Coffee.LATTE.water;
            validMilk -= Coffee.LATTE.milk;
            validCoffee -= Coffee.LATTE.coffeeBeans;
            disposableCups--;
            money += Coffee.LATTE.cost;

        } else if (validWater < Coffee.LATTE.water) {
            System.out.println("Sorry, not enough water!");
        } else if (validMilk < Coffee.LATTE.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (validCoffee < Coffee.LATTE.coffeeBeans) {
            System.out.println("Sorry, not enough coffee!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void makeCappuccino() {
        if (validWater >= Coffee.CAPPUCCINO.water && validMilk >= Coffee.CAPPUCCINO.milk && validCoffee >= Coffee.CAPPUCCINO.coffeeBeans && disposableCups > 0) {
            System.out.println("I have enough resources, making you a coffee!");
            validWater -= Coffee.CAPPUCCINO.water;
            validMilk -= Coffee.CAPPUCCINO.milk;
            validCoffee -= Coffee.CAPPUCCINO.coffeeBeans;
            disposableCups--;
            money += Coffee.CAPPUCCINO.cost;
        } else if (validWater < Coffee.CAPPUCCINO.water) {
            System.out.println("Sorry, not enough water!");
        } else if (validMilk < Coffee.CAPPUCCINO.milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (validCoffee < Coffee.CAPPUCCINO.coffeeBeans) {
            System.out.println("Sorry, not enough coffee!");
        } else {
            System.out.println("Sorry, not enough disposable cups!");
        }
    }

    public void fill() {
        String addedWater, addedMilk, addedCoffee, addedCups;

        do {
            System.out.println("Write how many ml of water do you want to add:");
            addedWater = scanner.nextLine();
        }
        while (!isNumeric(addedWater));
        validWater += Integer.parseInt(addedWater);

        do {
            System.out.println("Write how many ml of milk do you want to add:");
            addedMilk = scanner.nextLine();
        }
        while (!isNumeric(addedMilk));
        validMilk += Integer.parseInt(addedMilk);

        do {
            System.out.println("Write how many grams of coffee beans do you want to add:");
            addedCoffee = scanner.nextLine();
        }
        while (!isNumeric(addedCoffee));
        validCoffee += Integer.parseInt(addedCoffee);

        do {
            System.out.println("Write how many disposable cups of coffee do you want to add:");
            addedCups = scanner.nextLine();
        }
        while (!isNumeric(addedCups));
        disposableCups += Integer.parseInt(addedCups);

    }

    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}