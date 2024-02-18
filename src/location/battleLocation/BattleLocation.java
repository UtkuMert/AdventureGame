package location.battleLocation;

import location.Location;
import monster.Monster;
import player.Player;

import java.util.Random;


public abstract class BattleLocation extends Location {

    private Monster monster;
    private String award;

    private int maxNumber;

    public BattleLocation(Player player, String locationName, Monster monster, String award, int maxNumber) {
        super(player, locationName);
        this.monster = monster;
        this.award = award;
        this.maxNumber = maxNumber;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("You are here right know : " + this.getLocationName());
        System.out.println("This is " + this.getMonster().getName() + "'s place!!");
        System.out.println("You have " + monsterNumber + " enemies here!!!");

        System.out.println("<F>ight or <L>eave !!!");
        String select = scan.nextLine().toLowerCase();
        if (select.equals("f") && fight(monsterNumber)) {
            System.out.println("####Time to fight warrior!####");

            System.out.println(this.getLocationName() + " all monsters dead!");
            return true;

        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("You are dead!");
            return false;
        }
        return true;
    }

    public boolean fight(int monsterNumber) {
        for (int i = 0; i < monsterNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getDefaultHealth());
            playerStats();
            monsterStats(i);

            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("<H>it or <L>eave");
                String selectCombat = scan.nextLine().toLowerCase();

                if (selectCombat.equals("h")) {
                    System.out.println("You hit");
                    this.getMonster().setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Monster hit you !");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        monsterDamage = Math.max(monsterDamage, 0);
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                }
            }

            if (this.getMonster().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You beat the monster !");
                System.out.println("You earn " + this.getMonster().getReward() + " coins !! ");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getReward());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your health : " + this.getPlayer().getHealth());
        System.out.println("Monster health : " + this.getMonster().getHealth());
    }

    public void playerStats() {
        System.out.println("Warrior Information");
        System.out.println("-------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Damage : " + this.getPlayer().getTotalDamage());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Coin : " + this.getPlayer().getCoin());
    }

    public void monsterStats(int number) {
        System.out.println(number + ". " + this.getMonster().getName() + " Information");
        System.out.println("-------------------------");
        System.out.println("Health : " + this.getMonster().getHealth());
        System.out.println("Damage : " + this.getMonster().getDamage());
        System.out.println("Reward : " + this.getMonster().getReward());
    }

    public int randomMonsterNumber() {
        Random random = new Random();
        return random.nextInt(this.getMaxNumber()) + 1;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


}
