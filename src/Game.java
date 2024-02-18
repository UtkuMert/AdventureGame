import location.Location;
import location.battleLocation.Cave;
import location.battleLocation.Forest;
import location.battleLocation.River;
import location.safeLocation.SafeHouse;
import location.safeLocation.ToolStore;
import player.Player;

import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Time to start!");
        System.out.println("What's your nickname?");
        //String nickName = input.nextLine();
        String nickName = "uroborus";
        Player player = new Player(nickName);
        System.out.println("Welcome " + player.getUserName() );
        System.out.println("Lets show us, you are a warrior or not.");

        System.out.println("-----------------------------------------");
        player.selectWarrior();

        System.out.println("What a choice! You are a " + player.getWarriorName());

        Location location = null;

        while (true){

            player.info();

            System.out.println("Where do you wanna go?");
            System.out.println("1 - Safe House \n2 - Tool Store \n3 - Cave \n4 - River \n5 - Forest");
            int selectLocation = input.nextInt();
            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                    location = new Forest(player);
                    break;
                default:
                    System.out.println("Go Back !!");

            }

            if(!location.onLocation()){
                System.out.println("---Game Over---");
                break;
            }
        }

    }
}
