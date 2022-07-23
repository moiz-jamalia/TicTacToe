package TicTacToe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Diese Klasse dient als Memento-Klasse, in der die wichtigsten Spiel- Infos
 * gespeichert werden, damit sie sp�ter wiederhergestellt werden k�nnen
 * 
 * @author Moiz Jamalia, Andrin Tr�ger, Janis Papageorgiou
 * @version 1.0
 */

public class BoardState {

	/**
	 * Konstante ArrayListe f�r die beiden Spieler des BackUps
	 */
	private final ArrayList<String> p1, p2;

	/**
	 * Konstante Liste, der Felder in der Tabelle des BackUps
	 */
	private final Field[][] gameboard;

	/**
	 * Konstante X & Y-Koordinaten f�r das Feld des BackUps
	 */
	private final int x, y;

	/**
	 * Konstante Variable f�r das Spielersymbol des BackUps
	 */
	private final char symbol;

	/**
	 * Konstante Variable f�r den Gewinner des BackUps
	 */
	private final String winner;

	/**
	 * Konstante Variabel f�r das bestimmen des Spielende des BackUps
	 */
	private final boolean finish;
	
	/**
	 * Konstante Variable f�r das speichern des ersten Spielfeldes
	 */
	private final boolean isFirstPrint;

	/**
	 * Getter Methode f�r das Spielfeld
	 * 
	 * @return gibt das Spielfeld zur�ck
	 */
	public Field[][] getGameBoard() {
		return gameboard;
	}

	/**
	 * Getter Methode f�r X-Koordinate
	 * 
	 * @return gibt die X-Koordinate zur�ck
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter Methode f�r die Y-Koordinate
	 * 
	 * @return gibt die Y-Koordinate zur�ck
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter Methode f�r das Spielersymbol
	 * 
	 * @return gibt das Spielersymbol zur�ck
	 */
	public char getSymbol() {
		return symbol;
	}

	/**
	 * Getter Methode f�r den Gewinner
	 * 
	 * @return gibt den Gewinner oder das Unentschieden zur�ck
	 */
	public String getWinner() {
		return winner;
	}

	/**
	 * Getter Methode f�r das beenden
	 * 
	 * @return gibt den boolischen Wert zur�ck
	 */
	public boolean isFinish() {
		return finish;
	}

	/**
	 * Getter Methode f�r das Ausdrucken des ersten Spielfeldes
	 * 
	 * @return gibt den boolischen Wert zur�ck
	 */
	public boolean isFirstPrinted() {
		return isFirstPrint;
	}
	
	/**
	 * Getter Methode f�r die Liste von Spieler 1
	 * 
	 * @return gibt die Liste zur�ck
	 */
	public ArrayList<String> getP1() {
		return p1;
	}

	/**
	 * Getter Methode f�r die Liste von Spieler 2
	 * 
	 * @return gibt die Liste zur�ck
	 */
	public ArrayList<String> getP2() {
		return p2;
	}

	/**
	 * Konstruktor f�r die Klasse BoardState Setzt die Konstanten, um den Spielstand
	 * zu speichern
	 * 
	 * @param p1           Liste f�r die Felder die von Spieler 1 besetzt wurden zu
	 *                     speicherndes p1
	 * @param p2           Liste f�r die Felder die von Spieler 2 besetzt wurden zu
	 *                     speicherndes p2
	 * @param gameboard    Spielfeld zu speicherndes gameboard
	 * @param x            X-Koordinate zu speichernde X-Koordinate
	 * @param y            Y-Koordinate zu speichernde Y-Koordinate
	 * @param symbol       zu speichernde Symbol
	 * @param winner       zu speichernde winner
	 * @param finish       zu speichernde finish
	 * @param isFirstPrint zu speichernde isFirstPrint
	 */
	public BoardState(ArrayList<String> p1, ArrayList<String> p2, Field[][] gameboard, int x, int y, char symbol, String winner, boolean finish, boolean isFirstPrint) {
		this.gameboard = gameboard;
		this.x = x;
		this.y = y;
		this.p1 = deepRestorePlayer(p1);
		this.p2 = deepRestorePlayer(p2);
		this.symbol = symbol;
		this.winner = winner;
		this.finish = finish;
		this.isFirstPrint = isFirstPrint;
	}

	/**
	 * Kopiert die �bergebende Liste eines Spielers und gibt diese Kopie zur�ck
	 * 
	 * @param p zu kopierende gesetzte Feld eines Spielers
	 * @return Gibt die kopierte Liste eines Spielers zur�ck
	 */
	public ArrayList<String> deepRestorePlayer(ArrayList<String> p) {
		final ArrayList<String> copy = new ArrayList<>();
		Iterator<String> it = p.iterator();
		while (it.hasNext()) copy.add(it.next());
		return copy;
	}

	/**
	 * Kopiert das �bergebene Board und gibt diese Kopie zur�ck
	 * 
	 * @param fields zu kopierende Spielfeld
	 * @return Gibt die kopierte Spielfeld zur�ck
	 */
	public Field[][] deepRestoreGameBoard(Field[][] fields) {
		Field[][] gameboard = new Field[x][y];
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard.length; j++) {
				Field f = fields[i][j];
				gameboard[i][j] = new Field(f.getX(), f.getY(), f.getFieldsymbol());
			}
		}
		return gameboard;
	}
}