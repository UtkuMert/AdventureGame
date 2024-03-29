package player;

import inventory.Inventory;
import warrior.Archer;
import warrior.Knight;
import warrior.Samurai;
import warrior.Warrior;

import java.util.Scanner;

public class Player {

    private String userName;
    private Scanner scan = new Scanner(System.in);
    private String warriorName;
    private int damage;
    private int health;
    private int coin;

    private Inventory inventory;

    public Player(String userName) {
        this.userName = userName;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectWarrior() {

        boolean isSelected = true;
        System.out.println("Now, time to select your warrior!");


        while (isSelected) {
            System.out.println("------");
            System.out.println(" 1- Samurai \t Damage:5 \t Health: 21 \t Coin: 15 \n " +
                    "2- Archer  \t Damage:7 \t Health: 18 \t Coin: 20 \n " +
                    "3- Knight  \t Damage:8 \t Health: 24 \t Coin: 5 ");
            System.out.println("------");
            System.out.print("Select your warrior: ");
            int select = scan.nextInt();

            switch (select) {
                case 1:
                    Samurai samurai = new Samurai();
                    addWarriorAttrToPlayer(samurai);
                    isSelected = false;
                    break;
                case 2:
                    Archer archer = new Archer();
                    addWarriorAttrToPlayer(archer);
                    isSelected = false;
                    break;
                case 3:
                    Knight knight = new Knight();
                    addWarriorAttrToPlayer(knight);
                    isSelected = false;
                    break;
                default:
                    System.out.println("Your choice is not an option !!!");
                    isSelected = true;
            }
        }
        this.info();
    }

    public void info (){
        System.out.println("--------------------------");
        System.out.println("Damage: " + this.getDamage() +
                "\nHealth: " + this.getHealth() +
                "\nCoin: " + this.getCoin() + "\nWeapon: " + this.getInventory().getWeapon().getName());
        System.out.println("--------------------------");
    }
    public void addWarriorAttrToPlayer(Warrior warrior) {
        setWarriorName(warrior.getName());
        setDamage(warrior.getDamage());
        setHealth(warrior.getHealth());
        setCoin(warrior.getCoin());
    }

    public String getWarriorName() {
        return warriorName;
    }

    public void setWarriorName(String warriorName) {
        this.warriorName = warriorName;
    }

    public int getDamage() {

        return damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public int getHealth() {

        return health + this.getInventory().getArmor().getIgnoreDamage();
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
