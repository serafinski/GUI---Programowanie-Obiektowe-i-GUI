package Zadanie1;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window(){
        generateFrame();
    }

    public void generateFrame(){

        //ustawiamy layout
        this.setLayout(new FlowLayout());

        //tworzy pole tekstowe
        TextField textField = new TextField();
        //ustawiamy szerokość pola tekstowego
        textField.setColumns(30);

        //tworzymy przycisk i ustawiamy na nim tekst
        JButton button = new JButton("To jest przycisk!");

        //dodajemy pole tekstowe i przycisk do JFrame
        this.getContentPane().add(textField);
        this.getContentPane().add(button);

        //dodajemy actionListener'a na przycisk
        button.addActionListener(new MyActionListener());

        //zgodnie z zadaniem stosujemy putClientProperty pozwalająca na umieszczenie wartości na zasadzie klucz-wartość
        //kluczem jest String textField, a wartością jest samo pole tekstowe, z którym chcemy pracować
        button.putClientProperty("textField",textField);

        //pack by zeskalować wielkość okna do wielkości komponentów
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

