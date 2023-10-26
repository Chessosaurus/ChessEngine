package chessosaurus.UCI;
import java.util.Scanner;

/**
 * Die Klasse UCI ist für die Implementierung des UCI Protokolls zuständig.
 * <p>
 * Version: 1.0
 * Autor: Fabian Eilber
 */

public class UCI {

    static String ENGINENAME = "Chessosaurus";

    /**
     * uciCommunication() ist dafür zuständig, Befehle des UCI-Protokolls von der UI entgegenzunehmen und sie nach
     * den Vorgaben des UCI-Protokolls weiterzuverarbeiten.
     * Kann evtl. Multithreaded ausgeführt werden, für entsprechenden Anwendungsfall.
     */
    public static void uciCommunication() {

        while (true) {

            Scanner inputScanner = new Scanner(System.in);
            String inputString = inputScanner.nextLine();

            if ("uci".equals(inputString))
            {
                inputUCI();
            }
            else if ("isready".equals(inputString))
            {
                inputIsReady();
            }
            else if (inputString.startsWith("setoption"))
            {
                inputSetOption(inputString);
            }
            else if ("ucinewgame".equals(inputString))
            {
                inputUCINewGame();
            }
            else if (inputString.startsWith("position"))
            {
                inputPosition(inputString);
            }
            else if ("go".equals(inputString))
            {
                inputGo();
            }
            else if ("print".equals(inputString))
            {
                inputPrint();
            }
        }
    }

    /**
     * inputUCI ist für den initialen Start der Engine verantwortlich. Nachdem der Befehl "uci" empfangen wird, muss
     * sich die Engine identifizieren. Dafür muss die ID der Engine übermittelt werden. Optional können Optionen der
     * Engine und der ID Author übertragen werden.
     * Abschließend wird uciok übermittelt, um den UCI-Modus zu bestätigen.
     */
    private static void inputUCI() {
        System.out.println("id name " + ENGINENAME);
        System.out.println("id author Chessosaurus Ltd.");
        //Weitere Einstellungen der Engine (optional)
        System.out.println("uciok");
    }

    /**
     * inputIsRead ist für die Synchronisation der Engine und der GUI angedacht. Sollte die GUI mehrere Befehle gesendet
     * haben, mit diesem Befehl wird auf die Engine gewartet bis sie bereit ist. Auf diesen Befehl muss die Engine immer
     * mit "readyok" antworten.
     */
    private static void inputIsReady() {
        System.out.println("readyok");
    }

    /**
     * inputSetOption wird dazu verwendet, um innere Parameter der Engine zu verändern
     * @param inputString ist der Parameter, der bestimmt welche Änderung vorgenommen werden soll.
     */
    private static void inputSetOption(String inputString) {
        //Einstellungen treffen
    }

    /**
     * inputUCINewGame wird dazu verwendet, wenn die nächste Suche von einem anderen Spiel ist. Sprich ein neues Spiel,
     * welches die Engine analysieren soll.
     */
    private static void inputUCINewGame() {
        //Starten eines neuen Spiels
    }

    /**
     * inputPosition wird dazu verwendet, Positionen und Spielzüge in FEN-Notation zu erhalten und diese in ein internes
     * Schachbrett umzuwandeln. Somit kann die Engine Züge bewerten oder Empfehlen.
     * @param inputString Positionen und Züge in FEN-Notation
     */
    private static void inputPosition(String inputString) {

        String input = inputString.substring(9).concat(" ");

        //Wenn das übertragene Spiel von der Startposition ausgeht.
        if (input.contains("startpos ")) {
            input = input.substring(9);
            //Wandle FEN-Notation in Array um
        }
        //Positionen der Schachfiguren auf dem Feld
        else if (input.contains("fen")) {
            input = input.substring(4);
            //Wandle die FEN-Notation in Array um
        }
        //Spielzüge die getätigt wurden
        if (input.contains("moves")) {
            input = input.substring(input.indexOf("moves")+6);
            //make each of the moves
        }
    }

    /**
     * inputGo wird dazu verwendet, der Engine mitzuteilen, den besten Zug zu bestimmen.
     */
    private static void inputGo() {
        //Aufruf um besten Zug zu bestimmen
    }

    /**
     * inputPrint wird dazu verwendet, das Spielfeld in der Konsole auszugeben.
     */
    private static void inputPrint() {
        //Array des Feldes ausgeben
    }
}
