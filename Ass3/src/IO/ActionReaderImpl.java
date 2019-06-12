package IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ActionReaderImpl implements ActionReader {

    private Scanner userInput = new Scanner(System.in);
    private boolean isD;
    private File userActions;
    private String nextDetMove;
    BufferedReader br;

    public ActionReaderImpl(boolean d, File userActions) {
        this.isD = d;
        this.userActions = userActions;
        try {
            this.br = new BufferedReader(new FileReader(userActions));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.nextDetMove = "";
    }

    @Override
    public String nextAction() {
        if (!isD)
            return userInput.next();
        else {
            try {
                if ((nextDetMove = br.readLine()) != null) {
                    return nextDetMove;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
    }
}