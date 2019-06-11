import Gameplay.Gameplay;
import Gameplay.Level;
import IO.ActionReader;
import IO.ActionReaderImpl;
import IO.CLI;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Level> levels = new LinkedList<>();
        //String path = args[0];
        File dir = new File(args[0]);
        File userActions = null;
        File[] directoryListing = dir.listFiles();
        //int count = directoryListing.length;

        if (directoryListing == null)
            return;

        for (File file : directoryListing) {
            if (file.getPath().contains("level"))
                levels.add(new Level(file.getPath()));
            else if(file.getPath().contains("user_actions")); //maybe txt
                userActions = file;
        }

//        for (int i = 1; i<=count; i++)
//            levels.add(new Level(path+"level "+i+".txt"));

        Gameplay gameplay = new Gameplay(levels);
        ActionReader ar = new ActionReaderImpl(args.length >= 2 && args[1].equals("-D"), userActions);
        CLI cli = new CLI(gameplay, ar);
        cli.startGame();
    }
}