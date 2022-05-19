package Zadanie5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyWindow extends JFrame {
    //tworzymy górny JPanel
    private JPanel top;
    //tworzymy centralny JPanel
    private JPanel center;
    //tworzymy JLabel
    private JLabel label;
    //tworzymy zegar
    private Clock clock;
    //tworzymy timer
    Timer timer;


    public MyWindow (Clock clock){
        //inicjalzacja zegara
        this.clock = clock;

        //ustawienie rozmiaru okna
        this.setSize(500, 200);
        //zamknięcie okna przy kliknięciu wyjdź
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ustawienie layout JFrame na BorderLayout
        setLayout(new BorderLayout());

        //uruchamiamy funkcję odpowiedzialną za inicjalizacje komponentów
        initComponents();

        //ustawienie timera, który się odświeża actionPerformed co 100 ms -> czyli nasz czas
        timer = new Timer(100,this::actionPerformed);

        //TO SAMO ZA POMOCĄ LAMBDY
        //timer = new Timer(100,(ActionEvent e) -> {this.actionPerformed(e);});

        //uruchomienie wątku dla timer'a
        timer.start();

        //sprawienie by okienko było widoczne
        setVisible(true);
    }

    //funkcja, która pobiera do naszego label aktualną godzinę
    public void actionPerformed(ActionEvent e){
        this.label.setText(this.clock.getTimeInFormat());
    }


    //funkcja odpowiedzialna za inicjalizacje komponentów
    private void initComponents(){
        //deklaracja JPanelu top
        top = new JPanel();
        //deklaracja JPanelu center
        center = new JPanel();

        //przypisanie JPanelu top do góry okna
        this.add(BorderLayout.NORTH, top);
        //przypisanie JPanelu center do środka okna
        this.add(BorderLayout.CENTER, center);

        //label, który pokazuje aktualną godzinę w aktualnie wybranym formacie
        label = new JLabel(clock.getTimeInFormat());

        //dodajemy label do JPanelu na środku okna
        center.add(label);

        //uruchamiamy funkcję odpowiedzialną za inicjalizacje przycisków
        initButtons();

        //ustawiamy FlowLayout dla środkowego i górnego panelu
        top.setLayout(new FlowLayout());
        center.setLayout(new FlowLayout());
    }

    //funkcja odpowiedzialna za inicjalizacje przycisków
    private void initButtons(){
        //tworzymy 3 przyciski
        for(int i = 0; i < 3; i++){

            JButton button = new JButton("Przycisk " + i);

            //podpięcie metody switchFormat pod przycisk
            button.addActionListener((e) -> {
                this.clock.switchFormat();
            });

            //dodanie przycisku do JPanelu na górze
            this.top.add(button);
        }
    }
}
