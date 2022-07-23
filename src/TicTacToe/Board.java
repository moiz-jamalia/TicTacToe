package TicTacToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Dies ist die Board Klasse des TicTacToe-Programmes Sie enth�lt die Erstellung
 * des Spielfeldes und alle direkten Interaktionen die dieses betreffen
 * 
 * @author Moiz Jamalia, Andrin Traeger, Janis Papageorgiou
 * @version 1.0
 */
public class Board {

	/**
	 * Variable f�r Spieler 1 Liste Die Feldbezeichnungen werden in dieser Liste
	 * abgespeichert
	 */
	private ArrayList<String> p1 = new ArrayList<>();

	/**
	 * Variable f�r Spieler 2 Liste Die Feldbezeichnungen werden in dieser Liste
	 * abgespeichert
	 */
	private ArrayList<String> p2 = new ArrayList<>();

	/**
	 * Variable f�r die Bezeichnung der Spielfelder
	 */
	private String[] field = { "A0", "A1", "A2", "B0", "B1", "B2", "C0", "C1", "C2" };

	/**
	 * Variable f�r die Spielfeld-Liste
	 */
	private Field[][] gameboard;

	/**
	 * Variable f�r die X & Y-Koordinate
	 */
	private int x = 3, y = 3;

	/**
	 * Variable f�r das Feldsymbol
	 */
	private char symbol;

	/**
	 * Variable f�r den Spieler
	 */
	private String player = null;

	/**
	 * Variable f�r den Sieger
	 */
	private String winner = "";

	/**
	 * Variable f�r die Eingabe
	 */
	private final Scanner sc;

	/**
	 * Variable f�r das abspeichern der Boards
	 */
	private History history = new History();

	/**
	 * Variable f�r das Ende des Spieles bestimmen
	 */
	private boolean finish = false;

	/**
	 * Variable f�r das speichern des ersten Spielfeldes
	 */
	private boolean firstPrint = false;

	/**
	 * Getter Methode f�r die P1 Liste
	 * 
	 * @return die Liste auf welchem Feld Spieler 1 sein Zug gesetzt hat
	 */
	public ArrayList<String> getP1() {
		return p1;
	}

	/**
	 * Getter Methode f�r die P2 Liste
	 * 
	 * @return die Liste auf welchem Feld Spieler 2 sein Zug gesetzt hat
	 */
	public ArrayList<String> getP2() {
		return p2;
	}

	/**
	 * Setter Methode f�r den Spieler
	 * 
	 * @param setzt Player 1 oder Player 2
	 */
	public void setPlayer(String player) {
		this.player = player;
	}

	/**
	 * Getter Methode f�r den Spieler
	 * 
	 * @return gibt den Spieler zur�ck
	 */
	public String getPlayer() {
		return player;
	}

	/**
	 * Setter Methode f�r den Gewinner
	 * 
	 * @param der Gewinner des Spiels wird gesetzt
	 */
	public void setWinner(String winner) {
		this.winner = winner;
	}

	/**
	 * Getter Methode f�r den Gewinner
	 * 
	 * @return Gibt den Gewinner zur�ck
	 */
	public String getWinner() {
		return winner;
	}
	
	/**
	 * Getter Methode f�r die History
	 * 
	 * @return gibt die History zur�ck
	 */
	public History getHistory() {
		return history;
	}

	/**
	 * Getter Methode f�r die X-Koordinate
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
	 * Setter Methode f�r das erste Board
	 * 
	 * @param firstPrint
	 */
	public void setIsFirstPrinted(boolean firstPrint) {
		this.firstPrint = firstPrint;
	}

	/**
	 * Getter Methode f�r das erste Board
	 * 
	 * @return gibt den boolischen Wert zur�ck
	 */
	public boolean isFirstPrinted() {
		return firstPrint;
	}

	/**
	 * Konstruktor des Boardes. Erstellt das Spielfeld und erstellt den Scanner f�r
	 * die Eingabe
	 */
	public Board() {
		this.sc = new Scanner(System.in);
		this.gameboard = new Field[getX()][getY()];

		for (int i = 0; i < getX(); i++) {
			for (int j = 0; j < getY(); j++) gameboard[i][j] = new Field(i, j);
		}
	}

	/**
	 * erstellt die Umrandung und die Beschriftung rund um die einzelne Felder
	 */
	public void printboard() {
		char c = 65;
		for (int i = 0; i < getX(); i++) {
			if (i == 0) System.out.print("   | ");
			if (i > 3) System.out.print((char) c + "| ");
			else System.out.print((char) c + " | ");
			c++;
		}

		drawLine();

		for (int i = 0; i < getY(); i++) {
			System.out.print(" " + i + " | ");
			for (int j = 0; j < getX(); j++) System.out.print(gameboard[j][i].getFieldsymbol() + " | ");
			drawLine();
		}
	}

	/**
	 * erstellt die Linien um die Felder zu unterteilen
	 */
	private void drawLine() {
		System.out.println();
		for (int i = 0; i < (getX() * 5) + 1; i++) System.out.print("-");
		System.out.println();
	}

	/**
	 * Hier wird die ganze Eingabe vewertet. Es �berpr�ft, ob die Eingabe korrekt
	 * ist. Bei einer Korrekten Eingabe wird der Spielzug ausgef�hrt. Bei einer
	 * falschen Eingabe kommt ein Hinweis, dass die Eingabe nicht richtig sei und
	 * man kann wieder etwas eingeben. Bei einem besetzen Feld kommt eine Meldung
	 * die besagt, dass das Feld schon besetzt ist. Es fragt ab, ob man seinen Zug
	 * r�ckg�ngig machen will und diese Abfrage geht dann an beide Spieler bis hin
	 * zum Anfang oder bis jemand nein schreibt. Man kann jeder Zeit 'END' & 'NEW'
	 * schreiben f�r beenden oder neustarten des Spiels.
	 * 
	 * @param stopWatch um die zeiten der Spieler zu messen.
	 * @throws Exception
	 * @throws NullPointerException
	 */
	public void move(StopWatch stopWatch) throws Exception, NullPointerException {
		if (!isFirstPrinted()) save();
		setIsFirstPrinted(true);
		boolean bn = false;
		String pos = null;

		while (!finish) {
			if (p1.size() == p2.size()) {
				setPlayer("Player 1");
				stopWatch.startRoundTime();
			} else {
				setPlayer("Player 2");
				stopWatch.startRoundTime();
			}

			while (!bn) {
				System.out.print("\nEnter the Position for " + player + " (e.g. a0 or A0): ");
				pos = sc.next().toUpperCase();
				System.out.println();

				for (int i = 0; i < field.length; i++) {
					if (pos.equals(field[i])) bn = true;
				}

				if (pos.equals("NEW")) {
					System.out.println("Welcome to TicTacToe \n");
					new Main().start();
				} else if (pos.equals("END")) {
					System.out.println("\nGoodbye have a nice day");
					System.exit(0);
				}

				if (bn) {
					while (p1.contains(pos) || p2.contains(pos)) {
						System.out.print("Position is taken please enter another position: ");
						pos = sc.next().toUpperCase();
						System.out.println();
					}

					setSymbol(pos, player);

					printboard();

					undo(stopWatch);

				} else {
					System.out.println("Please enter a correct input! \n");
					printboard();
					move(stopWatch);
				}
			}
			checkWinner();
			checkGame();
			if (!finish) save();
			bn = false;
			stopWatch.stopRoundTime(getPlayer());
		}
	}

	/**
	 * Setzt das Symbol des Spielers auf dem ausgew�hlten Feld
	 * 
	 * @param pos
	 * @param player
	 */
	public void setSymbol(String pos, String player) {
		if (player.equals("Player 1")) {
			symbol = 'X';
			p1.add(pos);
		} else {
			symbol = 'O';
			p2.add(pos);
		}

		switch (pos) {
		case "A0" -> gameboard[0][0].setFieldsymbol(symbol);
		case "A1" -> gameboard[0][1].setFieldsymbol(symbol);
		case "A2" -> gameboard[0][2].setFieldsymbol(symbol);
		case "B0" -> gameboard[1][0].setFieldsymbol(symbol);
		case "B1" -> gameboard[1][1].setFieldsymbol(symbol);
		case "B2" -> gameboard[1][2].setFieldsymbol(symbol);
		case "C0" -> gameboard[2][0].setFieldsymbol(symbol);
		case "C1" -> gameboard[2][1].setFieldsymbol(symbol);
		case "C2" -> gameboard[2][2].setFieldsymbol(symbol);
		}
	}

	/**
	 * �berpr�ft ob eine 3er Reihe mit den gleichen vorhanden ist und setzt diesen
	 * Spieler als Gewinner oder setzt Unentschieden
	 */
	public void checkWinner() {
		List<String> top = Arrays.asList("A0", "B0", "C0");
		List<String> mid = Arrays.asList("A1", "B1", "C1");
		List<String> bot = Arrays.asList("A2", "B2", "C2");
		List<String> left = Arrays.asList("A0", "A1", "A2");
		List<String> midc = Arrays.asList("B0", "B1", "B2");
		List<String> right = Arrays.asList("C0", "C1", "C2");
		List<String> c1 = Arrays.asList("A0", "B1", "C2");
		List<String> c2 = Arrays.asList("C0", "B1", "A2");

		ArrayList<Object> winnerArray = new ArrayList<>();
		winnerArray.add(top);
		winnerArray.add(mid);
		winnerArray.add(bot);
		winnerArray.add(left);
		winnerArray.add(midc);
		winnerArray.add(right);
		winnerArray.add(c1);
		winnerArray.add(c2);

		for (Object list : winnerArray) {
			if (p1.containsAll((Collection<?>) list)) setWinner("Player 1 WON !!!");
			else if (p2.containsAll((Collection<?>) list)) setWinner("Player 2 WON !!!");
			else if (p1.size() + p2.size() == 9) setWinner("TIE !!!");
		}
	}

	/**
	 * gibt das ausgew�hlte Feld zur�ck
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 * @return Spielfeld mit den Koordinaten
	 */
	public Field getField(int x, int y) {
		return gameboard[x][y];
	}

	/**
	 * �berpr�ft wer gewonnen hat und setzt somit finish auf true
	 */
	public void checkGame() {
		switch (winner) {
		case "Player 1 WON !!!", "Player 2 WON !!!", "TIE !!!" -> finish = true;
		default -> finish = false;
		}
	}

	/**
	 * erstellt eine Kopie der Liste mit den Feldern f�r den jeweiligen Spieler
	 * 
	 * @param player die Liste mit den Feldern f�r den jeweiligen Spieler
	 * @return gibt eine Kopie der Liste mit den Feldern zur�ck
	 */
	private ArrayList<String> deepCopyPlayer(ArrayList<String> player) {
		final ArrayList<String> copy = new ArrayList<>();
		Iterator<String> it = player.iterator();
		while (it.hasNext()) copy.add(it.next());
		return copy;
	}

	/**
	 * Kopiert das �bergebene Board und gibt diese Kopie zur�ck
	 * 
	 * @return Gibt die kopierte Spielfeld zur�ck
	 */
	private Field[][] deepCopyBoard() {
		final Field[][] copy = new Field[getX()][getY()];
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy.length; j++) {
				Field f = getField(i, j);
				copy[i][j] = new Field(f.getX(), f.getY(), f.getFieldsymbol());
			}
		}
		return copy;
	}

	/**
	 * Speichert die Werte des Board in die History
	 */
	public void save() {
		history.push(new BoardState(deepCopyPlayer(getP1()), deepCopyPlayer(getP2()), deepCopyBoard(), getX(), getY(), symbol, winner, finish, isFirstPrinted()));
	}

	
	/**
	 * Diese Methode ist daf�r da, um abzufragen, ob der Spieler den Spielzug
	 * r�ckg�ngig machen will. Bei 'YES' fragt es den anderen Spieler, ob er
	 * seinen Spielzug r�ckg�ngig machen will. Das geht solange bis der Spieler nicht
	 * mehr seinen Zug r�ckg�ngig machen will.
	 * 
	 * @param stopWatch um die Zeit zu messen
	 * @throws Exception
	 */
	public void undo(StopWatch stopWatch) throws Exception {
        String undo = null;
        String p = null;
        
        do {
            boolean shouldUndo = false;
            
            if (history.getBoards().size() == 0) {
                System.out.println("You have reached the end! there is nothing left to undo! \n");
                printboard();
                break;
            }
            if (p1.size() != p2.size()) p = "Player 1";
            else p = "Player 2";
            
            System.out.print("\nDo you want to undo your move (" + p + ")? (yes or no): ");
            undo = sc.next().toUpperCase();
            
            switch(undo) {
                case "YES":
                    shouldUndo = true;
                    break;
                case "NO":
                	System.out.println();
                	printboard();
                    return;
                default:
                    System.out.println("\nPlease enter a correct input!");
                    return;
            }
            
            if (shouldUndo) {
                memento(stopWatch);
                System.out.println();
                if (!(history.getBoards().size() == 0)) printboard();
            }
            
        } while (true);
    }

	/**
	 * Methode die daf�r sorgt, einen Spielzug zur�ck zugehen, indem es die Werte
	 * mit dem im History abgespeichertem Werten �berschreibt
	 * 
	 * @param stopWatch um die Zeit zu messen
	 * @throws Exception
	 */
	public void memento(StopWatch stopWatch) throws Exception {
		BoardState backUp = history.pop();

		if (backUp == null) {
			System.out.println("\nundo not possible! \n");
			printboard();
			move(stopWatch);
		} else {
			p1 = backUp.deepRestorePlayer(backUp.getP1());
			p2 = backUp.deepRestorePlayer(backUp.getP2());
			gameboard = backUp.deepRestoreGameBoard(backUp.getGameBoard());
			x = backUp.getX();
			y = backUp.getY();
			symbol = backUp.getSymbol();
			winner = backUp.getWinner();
			finish = backUp.isFinish();
			firstPrint = backUp.isFirstPrinted();
		}
	}

	/**
	 * nach Beendigung des Spiels, wird abgefragt, ob das Programm beendet, neu
	 * gestartet oder der Spielzug r�ckg�ngig gemacht wird.
	 * 
	 * @return gibt entweder 'END', 'NEW' oder 'UNDO' zur�ck
	 */
	public String lastInput() {
		String input = null;
		try {
			while (input == null) {
				System.out.print("\nPlease enter 'New', for starting a new Game, 'End', for ending the game or 'Undo', for undo your last move: ");
				input = sc.next().toUpperCase();
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return input;
	}

	/**
	 * Gibt die �bergebene Anzahl an Dashes ("-") in einem String zur�ck, dies ist
	 * n�tzlich f�r die Erstellung von dynamischen Tabellendesigns.
	 * 
	 * @param size Anzahl Dashes.
	 * @return Ein String, der aus der gew�nschten Anzahl Dashes besteht.
	 */
	public String getPrintedLine(int size) {
		return "-".repeat(Math.max(0, size));
	}

	/**
	 * haltet die Zeit f�r denjenigen Spieler an.
	 * 
	 * @param stopwatch um die Zeit zu messen
	 * @param player    um welchen Spieler es sich gehandelt hat
	 */
	public void getPlayerTime(StopWatch stopwatch, String player) {
		stopwatch.stopRoundTime(player);
	}

	/**
	 * Gibt die Zeit aus, welch ein Spieler ben�tigte �ber das ganze Spiel.
	 * 
	 * @param stopwatch um die Zeit zu messen
	 * @param player    um zu wissen welcher Spieler wieviel Zeit gebraucht hatte
	 */
	public void getTotalPlayerTime(StopWatch stopwatch, String player) {
		System.out.println();
		String time = player + " time: " + stopwatch.getFormattedPlayerTime(player);
		System.out.print(getPrintedLine(time.length()) + "\n");
		System.out.print(time + "\n");
		System.out.print(getPrintedLine(time.length()) + "\n");
	}

	/**
	 * Gibt die Gesamte Spielzeit, die vergangen ist, aus.
	 * 
	 * @param stopwatch um die Zeit zu messen
	 */
	public void getGameTime(StopWatch stopwatch) {
		System.out.println();
		String time = "Game time: " + stopwatch.getElapsedGameTime();
		System.out.print(getPrintedLine(time.length()) + "\n");
		System.out.print(" ".repeat(Math.max(0, time.length() / 10)) + " " + getWinner() + "\n");
		System.out.print(time + "\n");
		System.out.print(getPrintedLine(time.length()) + "\n");
	}
}