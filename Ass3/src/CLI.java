import Gameplay.Gameplay;

public class CLI {

	private Gameplay gameplay;
	public CLI(){
		StringSubject.getInstance().addObserver((s)->System.out.println(s));
	}
}