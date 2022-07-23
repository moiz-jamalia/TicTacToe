package TicTacToe;

/**
 * Diese Klasse stellt ein Feld im Spielfeld dar. Alle n�tigen Variablen f�r die
 * Verwaltung dieser Felder sind unter Beachtung der Datenkapselung zug�ngig.
 * 
 * @author Moiz Jamalia, Andrin Traeger, Janis Papageorgiou
 * @version 1.0
 */

public class Field {

	/**
	 * Variabel f�r die X-Koordinate des Feldes
	 */
	private int x;

	/**
	 * Variabel f�r die Y-Koordinate des Feldes
	 */
	private int y;

	/**
	 * Variabel f�r die darstellung der Spieler nach jedem Spielzug
	 */
	private char fieldsymbol = ' ';

	/**
	 * Getter Methode f�r die X-Koordinate
	 * 
	 * @return Gibt X-Koordinate zur�ck
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter Methode f�r die Y-Koordinate
	 * 
	 * @return Gibt Y-Koordinate zur�ck
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter Methode f�r das Feldsymbol
	 * 
	 * @return Gibt Feldsymbol zur�ck
	 */
	public char getFieldsymbol() {
		return fieldsymbol;
	}

	/**
	 * Setter Methode f�r das Setzen das Feldsymbol Es setzt das angebene Symbol auf
	 * dem ausgew�hltem Feld
	 * 
	 * @param Spielersymbol X oder O
	 */
	public void setFieldsymbol(char symbol) {
		this.fieldsymbol = symbol;
	}

	/**
	 * Konstruktor f�r die Klasse Field Setzt die Koordinaten f�r ein neues Feld
	 * 
	 * @param x X-Koordinate
	 * @param y Y-Koordinate
	 */
	public Field(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Erweiterter Konstruktor f�r die Klasse Field Setzt s�mtliche Werte f�r ein
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