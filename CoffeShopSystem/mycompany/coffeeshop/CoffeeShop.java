/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.coffeeshop;

import java.util.ArrayList;
import java.util.Scanner;
import com.coffeeshop.model.Coffee;
import com.coffeeshop.model.MenuItem;
import com.coffeeshop.model.Size;

public class CoffeeShop {

    private static final Scanner scanner = new Scanner(System.in);
    private static double wallet = 1000.00;

    // ARRAY OF OBJECTS 
    private static final MenuItem[] orderArray = new MenuItem[10];
    private static int orderCount = 0;

    // ARRAYLIST (still kept)
    private static final ArrayList<MenuItem> myOrders = new ArrayList<>();

    // 2D ARRAY
    private static final String[][] menuData = {
        {"[1]" + " " + "Mocha", "120"},
        {"[2]" + " " + "Latte", "130"},
        {"[3]" + " " + "Americano", "100"},
        {"[4]" + " " + "Cappuccino", "140"}
    };

    public static void main(String[] args) {

        boolean isRunning = true;

        while (isRunning) {
    
    // --- ADD THIS BLOCK ---
    System.out.println("\n--------------------------------");
    System.out.println("CURRENT WALLET: PHP " + wallet);
    System.out.println("--------------------------------");
    // ----------------------

    displayMenu();
            int flavorIndex = getValidNumber("Select Flavor [1-4]: ", 1, 4);

            String name = menuData[flavorIndex - 1][0];
            double price = Double.parseDouble(menuData[flavorIndex - 1][1]);

            System.out.println("[1] Small [2] Medium [3] Large");
            int sizeChoice = getValidNumber("Choose size: ", 1, 3);

            Size size;
            switch (sizeChoice) {
                case 1:
                    size = Size.SMALL;
                    break; //  EXPLICIT BREAK
                case 2:
                    size = Size.MEDIUM;
                    break;
                default:
                    size = Size.LARGE;
                    break;
            }

            Coffee coffee = new Coffee(name, price, size);

            if (wallet >= coffee.calculatePrice()) {
                wallet -= coffee.calculatePrice();
                myOrders.add(coffee);
                orderArray[orderCount++] = coffee;
            }

            isRunning = askToContinue();
        }

        printReceipt();
    }

    // NESTED FOR LOOP 
    private static void displayMenu() {
        System.out.println("MENU:");
        for (int i = 0; i < menuData.length; i++) {
            for (int j = 0; j < menuData[i].length; j++) {
                System.out.print(menuData[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getValidNumber(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
            } catch (NumberFormatException e) {
                System.out.println("Numbers only!");
            }
        }
    }

    private static boolean askToContinue() {
        System.out.print("Order more? [Y/N]: ");
        return scanner.nextLine().equalsIgnoreCase("Y");
    }

    // NESTED FOR-EACH LOOP
    private static void printReceipt() {
        System.out.println("\n===========================");
        System.out.println("OFFICIAL RECEIPT");
        System.out.println("===========================");
        
        double totalSpent = 0; // 1. Create a variable to count the total

        for (MenuItem item : myOrders) {
            for (int i = 0; i < 1; i++) { // 2. Your nested loop structure
                double price = item.calculatePrice();
                
                // Print the individual item
                System.out.println(item + " - PHP " + price);
                
                // 3. Add this item's price to the total
                totalSpent += price; 
            }
        }

        System.out.println("---------------------------");
        // 4. Print the final summary
        System.out.println("TOTAL SPENT:      PHP " + totalSpent);
        System.out.println("REMAINING WALLET: PHP " + wallet);
        System.out.println("===========================");
    }
}
