import Gameplay.Gameplay;
import Gameplay.Level;
import IO.ActionReader;
import IO.ActionReaderImpl;
import IO.CLI;
import Utils.RandomGeneratorImpl;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Level> levels = new LinkedList<>();
        File dir = new File(args[0]); // dir path
        File[] directoryListing = dir.listFiles(); // separate files

        if (directoryListing == null) { // if no files
            System.out.println("No files inside directory path");
            return;
        }

        boolean isD = args.length >= 2 && args[1].equals("-D"); // if deterministic
        RandomGeneratorImpl.getInstance().setDeterministic(isD);
        ActionReader ar = new ActionReaderImpl(isD);

        for (File file : directoryListing) {
            if (file.getPath().contains("level"))
                levels.add(new Level(file.getPath()));
        }

        Gameplay gameplay = new Gameplay(levels);
        CLI cli = new CLI(gameplay, ar);
        cli.startGame();
    }
}