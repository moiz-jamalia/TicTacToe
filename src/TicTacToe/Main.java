package TicTacToe;

/**
 * Dies ist die Main Klasse des TicTacToe-Programmes. In ihr wird das ganze
 * Programm gestartet.
 * 
 * @author Moiz Jamalia, Andrin Träger, Janis Papageorgiou
 * @version 1.0
 */
public class Main {

	/**
	 * Erstellt neues Main und initiiert das Spiel
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("\nWelcome to TicTacToe \n");
		new Main().start();
	}

	/**
	 * Diese Methode erstellt ein neues Spiel und startet diese auch.
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		Game game = new Game();
		game.play();
	}
}