package TicTacToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse beinhaltet einen Stack der es erm�glicht, Spielst�nde zu
 * speichern, bevor ein Zug gemacht wird Somit kann ein BackUp einfach
 * wiederhergestellt werden.
 * 
 * @author Moiz Jamalia, Andrin Tr�ger, Janis Papageorgiou
 * @version 1.0
 */

public class History {

	/**
	 * Konstante Liste mit Stack-Aufbau f�r BackUp-Spielst�nde
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
	 * Popt den obersten BackUp-Spielstand auf dem Stack, also wird er zur�ckgegeben
	 * und dann gel�scht
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
	 * Getter Methode f�r gespeicherte Spielfeld-Liste
	 * 
	 * @return gibt die Spielfeld-Liste zur�ck
	 */
	public List<BoardState> getBoards() {
		return boards;
	}
}