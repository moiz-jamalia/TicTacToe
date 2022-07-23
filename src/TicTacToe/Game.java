package TicTacToe;

/**
 * Diese Klasse dient dazu, um die Stopuhr und das Spielfeld, mit ihren
 * zuständen und funktionen zu starten und zu überprüfen, ob jemand Gewonnen hat
 * oder Unentschieden ist.
 * 
 * @author Moiz Jamalia, Andrin Träger, Janis Papageorgiou
 * @version 1.0
 */

public class Game {

	/**
	 * Variable um zu definieren, wann das Spiel vorbei ist
	 */
	private boolean finish = false;

	/**
	 * Variable für die Stopuhr
	 */
	private final StopWatch stopWatch = new StopWatch();

	/**
	 * Variable um den Gewinner zu speichern
	 */
	public String winner;

	/**
	 * In dieser Methode wird ein Objekt des Boardes erstellt und ausgedruckt. In
	 * einer Do-While Schleife wird es immer nach einem Spielzugabfragen bis der
	 * Gewinner festgelegt wird. Zu letzt wird einmal abgefragt, ob man das Spiel
	 * Beenden, neustarten oder den die Spielzüge rückgängig machen wollen.
	 * 
	 * @throws Exception
	 */
	public void play() throws Exception {
		Board board = new Board();
		board.printboard();

		do {
			board.move(stopWatch);
			winner = board.getWinner();

			if (winner != null)
				finish = true;

			if (finish) {

				board.getTotalPlayerTime(stopWatch, "Player 1");
				board.getTotalPlayerTime(stopWatch, "Player 2");
				board.getGameTime(stopWatch);
				String s = board.lastInput();

				System.out.println();

				if (s.equals("NEW")) play();
				else if (s.equals("UNDO")) {
					board.memento(stopWatch);
					board.printboard();
					board.undo(stopWatch);
					finish = false;
				} else if (s.equals("END")) {
					System.out.println("\nGoodbye have a nice day");
					System.exit(0);
				}
			}
		} while (!finish);
	}
}