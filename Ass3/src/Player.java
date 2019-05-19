public class Player extends ActiveGameUnit {

	private int experience = 0;
	private int level = 1;

	@Override
	public void unitApproach(Gameplay gameplay, ActiveGameUnit unit) {
		gameplay.handleCombat(unit,this);
	}


}