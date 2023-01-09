import java.util.Scanner;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your character:");
        System.out.println("1. Warrior 2. Mage 3. Tank");
        int characterChoice = scanner.nextInt();
        Random rand = new Random();

        Player player;
        if (characterChoice == 1) {
            player = new Warrior("Warrior", 100, 50, 3);
        } else if (characterChoice == 2) {
            player = new Mage("Mage", 75, 30, 5);
        } else {
            player = new Tank("Tank", 150, 40, 2);
        }
        System.out.println("Choose your enemy");
        System.out.println("1. Slime 2. Skeleton 3. Dragon");
        int enemyChoice = scanner.nextInt();
        Enemy enemy;
        if (enemyChoice == 1) {
            enemy = new Enemy("Slime", 50, 20);
        } else if (enemyChoice == 2) {
            enemy = new Enemy("Skeleton", 100, 30);
        } else {
            enemy = new Enemy("Dragon", 200, 50);
        }
        while (true) {
            System.out.println("Player HP: " + player.getHp() + "  Enemy HP: " + enemy.getHp());
            System.out.println("What would you like to do?");
            System.out.println("1. Fight 2. Shop 3. Use Item");
            int actionChoice = scanner.nextInt();
            if (actionChoice == 1) {
                player.fight(enemy);
                if (enemy.getHp() <= 0) {
                    System.out.println("You have defeated the enemy!");
                    break;
                }


            } else if (actionChoice == 2) {
                System.out.println("You have " + player.getGold() + " gold.");
                System.out.println("1. Buy Health Potion (25 gold)");
                int shopChoice = scanner.nextInt();
                if (shopChoice == 1) {
                    if (player.getGold() >= 25) {
                        player.setGold(player.getGold() - 25);
                        player.setNumHealthPotions(player.getNumHealthPotions() + 1);
                        System.out.println("You have purchased a health potion!");
                    } else {
                        System.out.println("You do not have enough gold " +
                                "to purchase a health potion.");
                    }
                }


            } else {
                player.useItem();
            }

            enemy.attack(player);
            if (player.getHp() <= 0) {
                System.out.println("You have been defeated!");
                break;
            }
        }


        while (enemy.getHp() > 0) {
            System.out.println("Player HP: " + player.getHp() + "  Enemy HP: " + enemy.getHp());
            System.out.println("1. Fight 2. Shop 3. Use Item");
            int actionChoice = scanner.nextInt();
            if (actionChoice == 1) {
                player.fight(enemy);
                if (enemy.getHp() <= 0) {
                    System.out.println("You have defeated the enemy!");
                    break;
                }
            } else if (actionChoice == 2) {
                System.out.println("You have " + player.getGold() + " gold.");
                System.out.println("1. Buy Health Potion (25 gold)");
                int shopChoice = scanner.nextInt();
                if (shopChoice == 1) {
                    if (player.getGold() >= 25) {
                        player.setGold(player.getGold() - 25);
                        player.setNumHealthPotions(player.getNumHealthPotions() + 1);
                        System.out.println("You have purchased a health potion!");
                    }
                    else {
                        System.out.println("You do not have enough gold " +
                                "to purchase a health potion.");
                    }
                }
            }
            else {
                player.useItem();
            }

            enemy.attack(player);
            if (player.getHp() <= 0) {
                System.out.println("You have been defeated!");
                break;
            }
            System.out.println("Would you like to play again? (y/n)");
            String playAgainChoice = scanner.next();
            if (!playAgainChoice.equals("y")) {
                break;
            }

            enemy.setHp(50);
            player.setHp(100);
            player.setNumHealthPotions(3);
            player.setGold(50);
        }
        }
    }

