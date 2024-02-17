package location.battleLocation;

import monster.Monster;
import monster.Vampire;
import player.Player;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Wood",3);
    }
}
