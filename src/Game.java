import java.util.Random;

public class Game {
    // utworzenie obiektu klasy "Random" do generowania losowo bomby lub diamentu
    private Random random = new Random();

    // liczba prób
    private int attempts = 0;
    // liczba zdobytych diamentów
    private int diamonds = 0;
    // imię gracza
    private String playerName;

    // kostruktor, ustawiający imię gracza
    public Game(String playerName) {
        this.playerName = playerName;

    }

    // metoda wykonująca jedną próbę gry, zwraca true lub false w zależności od wylosowanej wartości i wciśniętego guzika
    public boolean attempt(int btnNr) {
        var rndValue = random.nextBoolean(); // losowanie
        boolean isDiamond = btnNr == 1 ? rndValue : !rndValue; // przypisanie do zmiennej wartości w zależności od przycisku
        updateGameState(isDiamond);
        return isDiamond;
    }


    // aktualizacja liczników prób i diamentów
    private void updateGameState(boolean isDiamond) {
        attempts++;
        if (isDiamond) {
            diamonds++;
        }
    }

    // resetowanie stanu gry
    public void resetGame() {
        attempts = 0;
        diamonds = 0;
    }

    // pobranie liczby prób
    public int getAttempts() {
        return attempts;
    }

    // pobranie liczby diamentów
    public int getDiamonds() {
        return diamonds;
    }

    //sprawdzenie czy wykonano juz 20 prób
    public boolean isGameOver() {
        return attempts > 20;
    }

    // komunikat końcowy
    public String getGameResult() {
        return "Koniec gry! Twój wynik: " + diamonds + " diamentów.";
    }

    // pobranie imienia gracza
    public String getPlayerName() {
        return playerName;
    }
}
