import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    private JLabel statusLabel; // etykieta wyswietlajaca status gry
    private JTextArea textArea; // pole tekstowe do wyswietlania wyników poszczególnych prób
    private Game game; // obiekt gry przekazany do okna

    public Window(Game game) {
        this.game = game; // przechowuje odniesienie do gry


        // ustawienie menadżera rozkładu
        setLayout(new GridLayout(2, 2, 10, 10));

        // tworzenie przyciskow
        JButton btn1 = new JButton("Kliknij tutaj!!");
        JButton btn2 = new JButton("A może tutaj?!");

        // inicjalizacja poczatkowego komunikatu "zacznij grać"
        statusLabel = new JLabel("Zacznij grać!");
        textArea = new JTextArea(); // przypisanie do zmiennej "textArea" nowego obiektu klasy "JTextArea"
        textArea.setEditable(false); // ustawienie "false" aby użytkownik nie mógł pisać w polu tekstowym

        // dodanie przycisków i etkiet do okna
        add(btn1);
        add(btn2);
        add(statusLabel);
        add(textArea);

        // ustawienie tytułu i parametrów okna
        setTitle("Bomba czy Diament! Gra: " + game.getPlayerName() + ", 20 prób");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zakończenie działania programu po zamknięciu okienka
        setVisible(true);


        // dodanie słuchaczy do przycisków
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isDiamond = game.attempt(1);
                updateStatus(isDiamond);
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isDiamond = game.attempt(2);
                updateStatus(isDiamond);
            }
        });
    }

        // aktualizacja statusu gry, wyswietlanie odpowiednich komunikatów
        private void updateStatus ( boolean isDiamond){

            if (game.isGameOver()) {
                endGame();
            }
            else{
                if (isDiamond) {
                    textArea.setText("Brawo! Masz Diament.\n");
                } else {
                    textArea.setText("Bomba! Nie tym razem :(.\n");
                }
                statusLabel.setText("Próba: " + game.getAttempts() + ", Liczba diamentów: " + game.getDiamonds());
            }


        }

        private void endGame () {
            // po zakończeniu gry wyświetl wynik i komunikat „Zagraj jeszcze raz”
            statusLabel.setText("Twój wynik: " + game.getDiamonds() + " diamentów.");


            // reset gry i wyświetlenie komunikatu
            game.resetGame();
            textArea.setText("Zagraj jeszcze raz!");
        }

    }

