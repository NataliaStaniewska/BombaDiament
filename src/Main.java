import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // tworzenie obieku klasy scanner, aby pobrac dane od uzytkownika
        Scanner scanner = new Scanner(System.in);
        // pobranie od użytkownika imienia i zapisanie go w zmiennej "playerName"
        System.out.print("Podaj swoje imię: ");
        String playerName = scanner.nextLine();

        // tworzenie instancji gry, przekazujemy imie gracza jako argument do konstruktora
        Game game = new Game(playerName);
        Window window = new Window(game);  // utworzenie obiektu "window" klasy "Window" i przekazanie instancji gry do okna
    }
}
