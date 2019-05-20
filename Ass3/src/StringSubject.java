import java.util.ArrayList;

/**
 * This class will manage all the printing from the Gameplay
 */
public class StringSubject {
    public interface StringObserver{
        void update(String s);
    }
    private final ArrayList<StringObserver> observers = new ArrayList<>();
    private static StringSubject ourInstance = new StringSubject();

    public static StringSubject getInstance() {
        return ourInstance;
    }
    public void addObserver(StringObserver stringObserver){
        observers.add(stringObserver);
    }
    private void notifyObservers(String s){
        for (StringObserver so:observers
             ) {
            so.update(s);
        }
    }
    private StringSubject() {
    }

}