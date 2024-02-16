package location.safeLocation;

import player.Player;
import tools.guns.Weapon;

public class ToolStore extends SafeLocation {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation(){
        System.out.println("--- Welcome to ToolStore ---");
        System.out.println("1 - Guns \n2 - Armors \n3 - Exit");
        System.out.print("What is your choice: ");
        int selectCase = scan.nextInt();

        while (selectCase > 3 || selectCase < 1){
            System.out.print("Incorret! Select your choice again: ");
            selectCase = scan.nextInt();
        }

        switch (selectCase){
            case 1:
                printWeapons();
                break;
            case 2:
                printArmors();
                break;
            default:
                return true;

        }

        return true;
    }

    private void printArmors() {
        System.out.println("Armors");
    }

    private void printWeapons() {
        System.out.println("Guns");
        System.out.println();

        for(Weapon w : Weapon.weapons()){
            System.out.println("1 - " + w.getName() + " <Price:"+w.getPrice()+ "> <Damage:"+ w.getDamage() + ">");
        }
    }
}
