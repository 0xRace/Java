package studentCode;

public class Universe {

	public static enum Outcomes { WIN, LOSE, DRAW }
	
	public static int THRESHOLD = 17;
	
	public static Battleable fight(Battleable player1, Battleable player2) {
		int result = 
				player1.getLevel()*player1.getStrength() 
				   -
				player2.getLevel()*player2.getStrength();
		
		if (result < 0) {
			player1.inform(Outcomes.LOSE);
			player2.inform(Outcomes.WIN);
			return player2;
		}
		
		if (result > 0) {
			player1.inform(Outcomes.WIN);
			player2.inform(Outcomes.LOSE);
			return player1;
		}
		
		player2.inform(Outcomes.DRAW);
		player2.inform(Outcomes.DRAW);
		
		return null;
	}
	
}
