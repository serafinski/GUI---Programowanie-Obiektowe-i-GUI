package Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyActionListener implements ActionListener {

    //tworzymy wątek — chcemy się zabezpieczyć przed tym by był on tylko 1
    Thread myThread;

    @Override
    public void actionPerformed(ActionEvent e) {

        //wyciągnięcie informacji o tym, co będziemy modyfikować

        //sam przycisk wydobywamy za pomocą e.getSource() -> mamy przycisk który wywołał tę akcję
        JButton sourceButton = (JButton) e.getSource();

        //wyciągamy textField -> zwraca object klasy Object, gdzie "pod spodem" znajduje się obiekt klasy TextField,
        //dlatego dokonujemy konwersji za pomocą (TextField)
        TextField textField = (TextField)sourceButton.getClientProperty("textField");

        //utworzenie nowego wątku odbędzie się tylko wtedy gdy:
        //wątek nie został nigdy zainicjalizowany -> było to pierwsze przyciśnięcie przycisku,
        //wątek nie jest żywy -> wątek, który pracował zakończył swoje działanie

        if (myThread == null || !myThread.isAlive()) {
            //tworzymy wątek
            myThread = new Thread() {

                // nadpisanie metody run
                @Override
                public void run() {

                    //pobranie wartości z pola tekstowego
                    String input = textField.getText();

                    try {
                        //parsujemy
                        int number = Integer.parseInt(input);

                        //jak się uda to super
                        while (number >= 0) {
                            textField.setText(Integer.toString(number));
                            number--;
                            try {
                                //w pętli while co sekundę będziemy dekrementować licznik, który udało się wpisać
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    } catch (NumberFormatException exception) {
                        //jak się nie uda z parsować to zwróć informacje
                        textField.setText("TYLKO CYFRY W POLU TEKSTOWYM!");
                    }
                }
            };
            //wystartowanie wątk
            myThread.start();
        }
    }
}
