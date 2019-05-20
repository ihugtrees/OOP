package IO;

import Gameplay.Gameplay;

public class CLI {

	private Gameplay gameplay;
	ActionReader actionReader;
	public CLI(Gameplay gameplay,ActionReader actionReader)
	{
		this.actionReader=actionReader;
		this.gameplay = gameplay;
		StringSubject.getInstance().addObserver((s)->System.out.println(s));

	}
	public void startGame(){
		StringSubject.getInstance().notifyObservers("Select player:");
		int i=0;
		for (String s:gameplay.getAllCharacters()) {
			StringSubject.getInstance().notifyObservers(i+". "+s);
			i++;
		}
		String player = actionReader.nextAction();

		gameplay.startGame(Integer.valueOf(player));
		StringSubject.getInstance().notifyObservers("You have selected:");
		StringSubject.getInstance().notifyObservers(gameplay.getPlayerStat());
		StringSubject.getInstance().notifyObservers("Use w/s/a/d to move.\n" +
				"Use e for special ability or q to pass.");
		while (!gameplay.isOver()){
			StringSubject.getInstance().notifyObservers(gameplay.boardToString());
			StringSubject.getInstance().notifyObservers(gameplay.getPlayerStat());
			try {
				gameplay.turn(actionReader.nextAction().charAt(0));
			} catch (Exception e) {
				StringSubject.getInstance().notifyObservers(e.getMessage());
			}

		}
	}
}