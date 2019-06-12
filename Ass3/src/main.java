import Gameplay.Gameplay;
import Gameplay.Level;
import IO.ActionReader;
import IO.ActionReaderImpl;
import IO.CLI;
import Utils.RandomGeneratorImpl;

import java.io.File;
import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Level> levels = new LinkedList<>();
        File dir = new File(args[0]); // dir path
        File userActions = null;
        File randomNumbers = null;
        File[] directoryListing = dir.listFiles(); // separate files
        Arrays.sort(directoryListing, Comparator.comparing(File::getName));

        if (directoryListing == null) { // if no files
            System.out.println("No files inside directory path");
            return;
        }

        for (File file : directoryListing) {
            if (file.getPath().contains("level"))
                levels.add(new Level(file.getPath()));
            else if(file.getPath().contains("user_actions"))
                userActions = file;
            else if(file.getPath().contains("random_numbers")){
                randomNumbers = file;
            }
        }

        boolean isD = args.length >= 2 && args[1].equals("-D"); // if deterministic
        RandomGeneratorImpl.getInstance().setDeterministic(isD, randomNumbers);
        ActionReader ar = new ActionReaderImpl(isD, userActions);
        Gameplay gameplay = new Gameplay(levels);
        CLI cli = new CLI(gameplay, ar);
        cli.startGame();
    }
}