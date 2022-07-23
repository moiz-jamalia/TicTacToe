package TicTacToe;

/**
 * Diese Klasse stellt ein Feld im Spielfeld dar. Alle nötigen Variablen für die
 * Verwaltung dieser Felder sind unter Beachtung der Datenkapselung zugängig.
 * 
 * @author Moiz Jamalia, Andrin Traeger, Janis Papageorgiou
 * @version 1.0
 */

public class Field {

	/**
	 * Variabel für die X-Koordinate des Feldes
	 */
	private int x;

	/**
	 * Variabel für die Y-Koordinate des Feldes
	 */
	private int y;

	/**
	 * Variabel für die darstellung der Spieler nach jedem Spielzug
	 */
	private char fieldsymbol = ' ';

	/**
	 * Getter Methode für die X-Koordinate
	 * 
	 * @return Gibt X-Koordinate zurück
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter Methode für die Y-Koordinate
	 * 
	 * @return Gibt Y-Koordinate zurück
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter Methode für das Feldsymbol
	 * 
	 * @return Gibt Feldsymbol zurück
	 */
	public char getFieldsymbol() {
		return fieldsymbol;
	}

	/**
	 * Setter Methode für das Setzen das Feldsymbol Es setzt das angebene Symbol auf
	 * dem ausgewähltem Feld
	 * 
	 * @param Spielersymbol X oder O
	 */
	public void setFieldsymbol(char symbol) {
		this.fieldsymbol = symbol;
	}

	/**
	 * Konstruktor für die Klasse Field Setzt die Koordinaten für ein neues Feld
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 */
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Erweiterter Konstruktor für die Klasse Field Setzt sämtliche Werte für ein
	 * neues Feld
	 * 
	 * @param x             X-Koordinate
	 * @param y             Y-Koordinate
	 * @param Spielersymbol X oder O
	 */
	public Field(int x, int y, char fieldsymbol) {
		this.x = x;
		this.y = y;
		this.fieldsymbol = fieldsymbol;
	}
}