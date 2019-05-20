import Gameplay.Gameplay;
import Gameplay.Level;
import IO.ActionReader;
import IO.ActionReaderImpl;
import IO.CLI;

import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main (String[] args){
        List<Level> levels = new LinkedList<>();
        for (int i=1;i<=4;i++) {
            levels.add(new Level(args[0]+"/level "+i+".txt"));
        }
        Gameplay gameplay =new Gameplay(levels);
        ActionReader ar = new ActionReaderImpl(args.length>=2&&args[1].equals("-D"));
        CLI cli = new CLI(gameplay,ar);
        cli.startGame();
    }
}
