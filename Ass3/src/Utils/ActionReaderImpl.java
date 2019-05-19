package Utils;

import java.util.Scanner;

public class ActionReaderImpl implements ActionReader {

    private Scanner userInput = new Scanner(System.in);
    private boolean isD;

    public ActionReaderImpl(boolean d) {
        isD = d;
    }

    @Override
    public String nextAction() {
        if (isD)
            return userInput.next();
        else
            return;
    }
}
