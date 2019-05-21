package Utils;

import Units.Mage;
import Units.Player;
import Units.Rogue;
import Units.Warrior;

import java.util.LinkedList;
import java.util.List;

public class PlayerChooser {
    public static List<Player> getPlayer() {
        List<Player> players = new LinkedList<>();
        players.add(new Warrior('@', null, "Jon Snow", 300, 30, 4, 6));
        players.add(new Warrior('@', null, "The Hound", 400, 20, 6, 4));
        players.add(new Mage('@', null, "Melisandre", 160, 10, 1, 40, 300, 30, 5, 6));
        players.add(new Mage('@', null, "Thoros of Myr", 250, 25, 3, 15, 150, 50, 3, 3));
        players.add(new Rogue('@', null, "Arya Stark", 150, 40, 2, 20));
        players.add(new Rogue('@', null, "Bronn", 250, 35, 3, 60));
        return players;
    }
}