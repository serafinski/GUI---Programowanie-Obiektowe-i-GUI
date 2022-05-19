package Zadanie3;

import javax.swing.*;
import java.awt.*;

//dziedziczy po JFrame
public class MyWindow extends JFrame {
    //tworzymy 1 pole tekstowe
    private JTextField textField1;

    //tworzymy 2 pole tekstowe
    private JTextField textField2;

    //tworzymy przycisk
    private JButton button;

    //konstruktor MyWindow
    public MyWindow(){
        //ustawiamy wielkość
        this.setSize(500,200);
        //ustawiamy tytuł
        this.setTitle("Zadanie 3");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ustawiamy layout na FlowLayout
        this.setLayout(new FlowLayout());

        //funkcja inicjująca komponenty
        initComponents();

        //ustawiamy widoczność okna
        setVisible(true);
    }

    public void initComponents(){
        //zadeklarowanie textField1 oraz textField2 polem tekstowym JTextField
        textField1 = new JTextField();
        textField2 = new JTextField();

        //zadeklarowanie button JButton'em
        button = new JButton("Dodaj liczby");

        //ustawienie szerokości textField1 - pokazanie, że można na różne sposoby
        textField1.setColumns(5);

        //ustawienie wymiarów textField2 - pokazanie, że można na różne sposoby
        textField2.setPreferredSize(new Dimension(50,20));


        //dodanie komponentów do JFrame'a
        this.add(textField1);
        this.add(textField2);
        this.add(button);

        //tutaj definicja tego, co się stanie jak się kliknie przycisk
        button.addActionListener((e) -> {
            try {
                //czytaj liczbę z 1 pola tekstowego (ona będzie pierwotnie w formacie String'a)
                //i parsuj ją do double
                double numer1 = Double.parseDouble(textField1.getText());
                //czytaj liczbę z 2 pola tekstowego (ona będzie pierwotnie w formacie String'a)
                //i parsuj ją do double
                double numer2 = Double.parseDouble(textField2.getText());

                //rezultat
                double rezultat = numer1 + numer2;

                //ustal tytuł na otrzymany rezultat
                this.setTitle(Double.toString(rezultat));

            }catch (Exception exception){
                this.setTitle("Podawaj tylko liczby w polach tekstowych!");
            }
        });
    }
}