package location.safeLocation;


import player.Player;

public class SafeHouse extends SafeLocation {

    public SafeHouse(Player player){
        super(player, "Safe House");
    }
    @Override
    public boolean onLocation() {
        System.out.println("You are in safe house now.");
        System.out.println("Your health is full!!");
        return true;
    }
}
