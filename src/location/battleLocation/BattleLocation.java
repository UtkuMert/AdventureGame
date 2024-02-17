package location.battleLocation;

import location.Location;
import monster.Monster;
import player.Player;

import java.util.Locale;
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
        String select = scan.nextLine();
        select =select.toLowerCase();
        if(select.equals("f")){
            System.out.println("Time to fight warrior!");
            //Fight
        }else{

        }
        return true;
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
