package TicTacToe;

import java.util.Date;

/**
 * Diese Klasse kann eine Konstante Startzeit für das Spiel und für jeden
 * Spieler einzel speichern und auf Abruf die verstrichene Zeit seit dem Start
 * zurückgeben
 * 
 * @author Moiz Jamalia, Andrin Träger, Janis Papageorgiou
 * @version 1.0
 */

public class StopWatch {

	/**
	 * Variable, die die Zeit die Spieler 1 für seinen Spielzügen verbraucht,
	 * speichert
	 */
	private long timeP1 = 0;

	/**
	 * Variable, die die Zeit die Spieler 2 für seinen Spielzügen verbraucht,
	 * speichert
	 */
	private long timeP2 = 0;

	/**
	 * Variable, die die die Startzeit der Stopuhr speichert
	 */
	private long roundStartTime;
	
	/**
     * Getter Methode für Startzeit
     * 
     * @return gibt die Startzeit zurück
     */
    public long getRoundStartTime() {
        return roundStartTime;
    }

	/**
	 * Startet die Stoppuhr
	 */
	public void startRoundTime() {
		roundStartTime = new Date().getTime();
	}

	/**
	 * Stoppt die Stopuhr und speichert die Zeit beim jeweiligen Spielervariable ab
	 * 
	 * @param player Spieler 1 oder Spieler 2
	 */
	public void stopRoundTime(String player) {
		if (player.equals("Player 1")) timeP1 += (new Date().getTime() - roundStartTime);
		else if (player.equals("Player 2")) timeP2 += (new Date().getTime() - roundStartTime);
	}

	/**
	 * Gibt die verstrichene Zeit seit der Konstruktor dieser Klasse aufgerufen
	 * wurde in einer lesbaren Formatierung zurück
	 * 
	 * @return Gibt formatierte verstrichene Zeit eines Spielers zurück
	 */
	public String getFormattedPlayerTime(String player) {
		long timeInSec = 0;
		if (player.equals("Player 1")) timeInSec = (timeP1 / 1000);
		else if (player.equals("Player 2")) timeInSec = (timeP2 / 1000);

		if (timeInSec < 60) return timeInSec + " seconds";
		else return (timeInSec / 60) + " minutes, " + (timeInSec % 60) + " seconds";
	}

	/**
	 * Gibt die verstrichene Zeit seit der Konstruktor dieser Klasse aufgerufen
	 * wurde in einer lesbaren Formatierung zurück
	 * 
	 * @return Gibt formatierte verstrichene Gesamtzeit zurück
	 */
	public String getElapsedGameTime() {
		long elapsedTimeInSec = ((timeP1 / 1000) + (timeP2 / 1000));
		if (elapsedTimeInSec < 60) return elapsedTimeInSec + " seconds";
		else return (elapsedTimeInSec / 60) + " minutes, " + (elapsedTimeInSec % 60) + " seconds";
	}
}