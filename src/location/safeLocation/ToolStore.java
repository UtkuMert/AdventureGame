package location.safeLocation;

import player.Player;
import tools.armors.Armor;
import tools.weapon.Weapon;

public class ToolStore extends SafeLocation {
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--- Welcome to ToolStore ---");
        System.out.println("1 - Guns \n2 - Armors \n3 - Exit");
        System.out.print("What is your choice: ");
        int selectCase = scan.nextInt();

        while (selectCase > 3 || selectCase < 1) {
            System.out.print("Incorret! Select your choice again: ");
            selectCase = scan.nextInt();
        }

        switch (selectCase) {
            case 1:
                printWeapons();
                buyWeapon();
                break;
            case 2:
                printArmors();
                buyArmor();
                break;
            default:
                return true;

        }

        return true;
    }

    private void printArmors() {
        System.out.println("Armors");
        System.out.println();

        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " <Price:" + a.getPrice() + "> " +
                    "<Ignore:" + a.getIgnoreDamage() + ">");
        }
    }

    private void buyArmor(){
        System.out.print("Select an armor warrior! :");
        int selectArmor = scan.nextInt();
        while (selectArmor > Armor.armors().length || selectArmor < 1) {
            System.out.print("Incorret! Select your choice again: ");
            selectArmor = scan.nextInt();
        }

        Armor selectedArmor = Armor.getArmorById(selectArmor);

        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getCoin()){
                System.out.println("You do not have enough money !");
            }else{
                System.out.println("You selected " + selectedArmor.getName() + ". Good Choice!!");
                int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                this.getPlayer().setCoin(balance);
                System.out.println("Your money : " + this.getPlayer().getCoin());
                this.getPlayer().getInventory().setArmor(selectedArmor);
                System.out.println("Your bought an armor !!  : "  + this.getPlayer().getInventory().getArmor().getName());
            }
        }
    }

    private void printWeapons() {
        System.out.println("Guns");
        System.out.println();

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " <Price:" + w.getPrice() + "> " +
                    "<Damage:" + w.getDamage() + ">");
        }

    }
    public void buyWeapon(){
        System.out.print("Select a weapon warrior! :");
        int selectWeapon = scan.nextInt();
        while (selectWeapon > Weapon.weapons().length || selectWeapon < 1) {
            System.out.print("Incorret! Select your choice again: ");
            selectWeapon = scan.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponById(selectWeapon);

        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getCoin()){
                System.out.println("You do not have enough money !");
            }else{
                System.out.println("You selected " + selectedWeapon.getName() + ". Good Choice!!");
                int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                this.getPlayer().setCoin(balance);
                System.out.println("Your money : " + this.getPlayer().getCoin());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
                System.out.println("Your new weapon : "  + this.getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
}
