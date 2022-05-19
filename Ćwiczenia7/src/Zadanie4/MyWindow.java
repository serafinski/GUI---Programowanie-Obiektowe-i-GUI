package Zadanie4;

import javax.swing.*;
import java.awt.*;

//dziedziczy po JFrame
public class MyWindow extends JFrame {
    //tworzymy górny JPanel
    private JPanel top;

    //tworzymy środkowy JPanel
    private JPanel center;

    //tworzymy JLabel
    private JLabel label;

    //konstruktor MyWindow
    public MyWindow(){
        //ustawiamy wielkość
        this.setSize(500,200);
        //ustawiamy tytuł
        this.setTitle("Zadanie 3");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //ustawiamy layout na BorderLayout
        this.setLayout(new BorderLayout());

        //funkcja inicjująca komponenty
        initComponents();

        //ustawiamy widoczność okna
        setVisible(true);
    }

    public void initComponents(){
        //zadeklarowanie górnego oraz centralnego panelu za pomocą JPanel
        top = new JPanel();
        center = new JPanel();

        //dodanie komponentów do JFrame'a

        //na górze okna
        this.add(BorderLayout.NORTH, top);

        //na środku okna
        this.add(BorderLayout.CENTER, center);

        //zadeklarowanie label'u
        label = new JLabel();

        //dodanie label do centralnego panelu
        center.add(label);

        //użycie funkcji inicjującej przyciski
        initButtons();

        //ustawienie górnego panelu oraz panelu środkowego na FlowLayout
        top.setLayout(new FlowLayout());
        center.setLayout(new FlowLayout());
    }

    //funkcja służąca stworzeniu i dodaniu przycisków
    private void initButtons(){
        for (int i =0; i<3; i++){
            //tworzymy nowy przycisk
            JButton button = new JButton("Przycisk " + i);
            //funkcjonalność, jeżeli klikniemy przycisk...
            button.addActionListener((e) -> {
                //...ustaw tekst label'u na tekst przycisku
                this.label.setText(button.getText());
            });
            //dodanie przycisku do górnego panelu — KLUCZOWE
            this.top.add(button);
        }
    }
}