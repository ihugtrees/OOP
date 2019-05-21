import Gameplay.Gameplay;
import Gameplay.Level;
import IO.ActionReader;
import IO.ActionReaderImpl;
import IO.CLI;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main (String[] args){
        List<Level> levels = new LinkedList<>();
        //String path = args[0];
        File dir = new File(args[0]);
        File[] directoryListing = dir.listFiles();
        //int count = directoryListing.length;

        if(directoryListing==null)
            return;
        for (File file : directoryListing)
            levels.add(new Level(file.getPath()));

//        for (int i = 1; i<=count; i++)
//            levels.add(new Level(path+"level "+i+".txt"));

        Gameplay gameplay =new Gameplay(levels);
        ActionReader ar = new ActionReaderImpl(args.length>=2&&args[1].equals("-D"));
        CLI cli = new CLI(gameplay,ar);
        cli.startGame();
    }
}