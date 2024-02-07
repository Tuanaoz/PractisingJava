import java.util.Random;
import java.util.Scanner;

public class ScaryForestGameUltimate {

    public static class Backpack {
        int productQuantity;
        String category;
        String[] inventory;
        String allInventory;

        public Backpack() {
            inventory = new String[5];
        }
    }

    public static int healthPoints = 100;

    public static void main(String[] args) {
        scaryForestGame();
        scaryForestGameName();
        String decisionAnsw1 = getPlayerDecision();
        makeDecision(decisionAnsw1);
        String decisionAnsw2 = getPlayerDecision2();
        decisionStatements(decisionAnsw2);
        printStoryline();
        parkour("", healthPoints);
        healthPoints = storyLine3(healthPoints);
        displayFruits();

        Backpack playerBackpack = createBackpack();
        chooseMagicalFruits(playerBackpack.inventory);
        System.out.println(gameInventory(playerBackpack));
        pickingUpStuff(playerBackpack);
    }

    public static void scaryForestGame() {
        // Prints a scary welcome message.
        System.out.println("After a thousand years, you are the first person who found this forest place, and now you have to play my game!");
        System.out.println("To play my game, all you have to do is choose the right option between the choices. If your judgment is accurate, you will live >:)");
    }

    public static void scaryForestGameName() {
        // Asks the user's name then greets them by name
        String playerName;
        Scanner scanner = new Scanner(System.in);
        System.out.println("First, tell me your name");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + ". Let's see if you will be able to survive my game :)");
    }

    public static String getPlayerDecision() {
        // Prints the first question and gets the decision
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do? 'Follow the sound' or 'Take the other way'?");
        return scanner.nextLine();
    }

    public static String makeDecision(String decisionAnsw1) {
        // Shows the conditions according to the player's first decision and declares their final health status
        if (decisionAnsw1.equals("Follow the sound")) {
            System.out.println("After following the sound, you see a woman at the end of the road who looks distressed.");
        } else if (decisionAnsw1.equals("Take the other way")) {
            System.out.println("You decided to take the other way. While walking on the path, a bear attacked you, and now you are wounded. -10 health points.");
            healthPoints -= 10;
        } else {
            System.out.println("You should either 'Follow the sound' or 'Take the other way.'");
        }

        System.out.println("Your final health bar is " + healthPoints);
        return "Your final health bar is " + healthPoints;
    }

    public static String getPlayerDecision2() {
        // Prints the rest of the storyline and gets input for other methods.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Now you and the woman are walking together. You tried to talk with her, but she didn't answer you.");
        System.out.println("Suddenly, you encounter a bear, and it looks like it's about to attack.");
        System.out.print("Are you going to 'act dead' or 'attack with your hands'? ");
        return scanner.nextLine();
    }

    public static String decisionStatements(String decisionAnsw2) {
        // Executes if else statements according to the input
        Scanner scanner = new Scanner(System.in);

        if (decisionAnsw2.equals("act dead")) {
            System.out.println("You acted dead, and the bear didn't attack (+10 health points).");
            healthPoints += 10;
            System.out.println("Your current health is " + healthPoints);
            return "Your current health is " + healthPoints;
        } else if (decisionAnsw2.equals("attack with your hands")) {
            System.out.println("That was not a wise choice. The bear attacks stronger than you. -10 health points.");
            healthPoints -= 10;
            System.out.println("The bear is attacking, so are you going to turn right or left to dodge the attack?");
            String chooseDirection = scanner.nextLine();

            if (chooseDirection.equals("right")) {
                System.out.println("You lost an arm (-10 HP), but at least the bear is calmer now.");
                System.out.print("It looks like the bear is about to leave. Will you attack again? (yes or no): ");
                String attackAgain = scanner.nextLine();

                if (attackAgain.equals("yes")) {
                    System.out.println("Congratulations! You just got killed by a bear.");
                    System.out.println("Game Over");
                    return "Game Over";
                } else if (attackAgain.equals("no")) {
                    System.out.println("The bear decided to leave. Luckily, the woman had first aid, and now you can patch yourself up (+10 HP).");
                    healthPoints += 10;
                }
            } else if (chooseDirection.equals("left")) {
                System.out.println("That was risky!! you just got away with getting your arm ripped.");
                System.out.println("You got a chance to push the bear, and you roar at it. Now it's scared and running away.");
            }
        } else {
            System.out.println("You should either 'act dead' or 'attack with your hands'.");
            System.out.println("Invalid Decision");
            return "Invalid Decision";
        }

        System.out.println("Your current health is " + healthPoints);
        return "Your current health is " + healthPoints;
    }

    public static void printStoryline() {
        // This method prints the continuation of the story
        System.out.println("After surviving the bear attack, you decided to find a place where you and the woman can rest.");
        System.out.print("The first reasonable place had a pack of wolves, so to get far away from them you decided to go to the other side of the forest");
        System.out.println("Now you need to pass a long lake by stepping on the stones");
        System.out.println("The woman mentions that some of the stones are actually water creatures and you shouldn't step on them");
    }

    public static String parkour(String answerp, int healthPoints) {
        // Simulates jumping on stones with a random chance of being attacked
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        final String choice1 = "Left";
        final String choice2 = "Right";
        int i = 0;

        while (i <= 4 && healthPoints > 0) {
            String random = rand.nextBoolean() ? choice1 : choice2;
            System.out.println("It looks like you need to step on the stones to get to the other side. Which one are you going to jump on? (Left or Right)");
            answerp = scanner.nextLine();

            if (("Left".equals(answerp) && random.equals("Left")) || ("Right".equals(answerp) && random.equals("Right"))) {
                System.out.println("Congrats you were not attacked!!");
                i++;
            } else {
                System.out.println("Well, it was not a stone, you were attacked.(-10HP)");
                healthPoints -= 10;
            }
        }

        while (healthPoints <= 0) {
            System.out.println("Do you want to play again? (yes/no)");
            String playAgain = scanner.nextLine();

            if (playAgain.equals("no")) {
                System.out.println("Sad.");
            } else if (playAgain.equals("yes")) {
                healthPoints = 100;
                i = 0;
            }
        }

        System.out.println("Your current health is " + healthPoints);
        return "Your current health is " + healthPoints;
    }

    public static int storyLine3(int healthPoints) {
        // After passing the lake, this is the continuation of the storyline
        System.out.println("You and the woman successfully passed across the lake, after walking a while you were able to find a place to stay.");
        System.out.println("+10HP");
        healthPoints += 10;
        return healthPoints;
    }

    public static void displayFruits() {
        // Method representing a story line that utilizes Arrays and a loop
        System.out.println("After a successful overnight, you decided to collect some equipment around the forest. Suddenly you come across a mystical tree with five magical fruits.");
        System.out.println("You can only carry three of these fruits. Choose wisely!");
    }

    public static void chooseMagicalFruits(String[] chosenFruits) {
        // Gets the names of the magical fruits they want to keep and stores them in an array
        Scanner scanner = new Scanner(System.in);
        final String[] magicalFruits = {"Golden Apple", "Silver Berry", "Crystal Orange", "Ruby Grape", "Emerald Banana"};

        for (String fruit : magicalFruits) {
            System.out.println("- " + fruit);
        }

        for (int j = 0; j < 3; j++) {
            System.out.print("Enter the name of fruit " + (j + 1) + ": ");
            chosenFruits[j] = scanner.nextLine();
        }

        System.out.println("These magical fruits will aid you in your journey!");
    }

    public static Backpack createBackpack() {
        // Create a method to declare initial values for the record backpack
        Backpack backpack = new Backpack();
        backpack.productQuantity = 0;
        backpack.category = "";
        backpack.allInventory = "";
        return backpack;
    }

    public static String gameInventory(Backpack backpack) {
        // Returns a string statement about inventory limitations
        return "After getting the fruits, you walked more and found a mysterious backpack in the forest.\n" +
                "Now you can only store 5 things at the same time (not including fruits).";
    }

    public static String pickingUpStuff(Backpack backpack) {
        // It allows the naming of the equipment they found and adds it to the backpack for it to later print it out
        final Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < backpack.inventory.length; i++) {
            System.out.print("You found a useful item, what would you like to name it: ");
            backpack.inventory[i] = scanner.nextLine();
            backpack.productQuantity++;
        }

        for (String item : backpack.inventory) {
            result.append(item).append(", ");
        }

        System.out.println("You have collected the following items in your " + backpack.category + " backpack: " + result.toString());
        return "You have collected the following items in your " + backpack.category + " backpack: " + result.toString();
    }
}
