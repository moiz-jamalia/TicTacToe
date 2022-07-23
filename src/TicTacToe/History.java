package TicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse beinhaltet einen Stack der es ermöglicht, Spielstände zu
 * speichern, bevor ein Zug gemacht wird Somit kann ein BackUp einfach
 * wiederhergestellt werden.
 * 
 * @author Moiz Jamalia, Andrin Träger, Janis Papageorgiou
 * @version 1.0
 */

public class History {

	/**
	 * Konstante Liste mit Stack-Aufbau für BackUp-Spielstände
	 */
	private final List<BoardState> boards = new ArrayList<>();

	/**
	 * Pusht einen BackUp-Spielstand in den Stack
	 * 
	 * @param board BackUp-Spielstand
	 */
	public void push(BoardState board) {
		boards.add(board);
	}

	/**
	 * Popt den obersten BackUp-Spielstand auf dem Stack, also wird er zurückgegeben
	 * und dann gelöscht
	 * 
	 * @return Oberster BackUp-Spielstand
	 */
	public BoardState pop() throws Exception {
		int LastIndex = boards.size() - 1;
		BoardState lastBoard = null;

		lastBoard = boards.get(LastIndex);
		if (LastIndex >= 0) boards.remove(lastBoard);

		return lastBoard;
	}

	/**
	 * Getter Methode für gespeicherte Spielfeld-Liste
	 * 
	 * @return gibt die Spielfeld-Liste zurück
	 */
	public List<BoardState> getBoards() {
		return boards;
	}
}