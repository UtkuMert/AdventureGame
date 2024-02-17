package location.battleLocation;

import monster.Bear;
import monster.Monster;
import player.Player;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), "Water",2);
    }
}
