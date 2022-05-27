package Zadanie2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {

    public Window(){
        generateFrame();
    }

    public void generateFrame(){
        //ustawiamy JFrame w taki sposób, bo jest zabawa z klasami anonimowymi przy ActionListener
        JFrame jFrame = this;

        //ustawiamy layout
        jFrame.setLayout(new FlowLayout());

        //tworzy pole tekstowe
        TextField textField = new TextField();
        //ustawiamy szerokość pola tekstowego
        textField.setColumns(25);

        //tworzymy przyciski i ustawiamy na nich tekst
        JButton jButtonL = new JButton("Warszawa");
        JButton jButtonR = new JButton("Zmień tytuł...");

        //dodajemy przyciski do JFrame
        this.getContentPane().add(jButtonL);
        this.getContentPane().add(jButtonR);

        //ActionListener na przycisk z nazwą miasta
        jButtonL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //kliknięcie przycisku wpisuje tekst z przycisku do TextField'a
                textField.setText(jButtonL.getText());
            }
        });

        //KeyListener - metody
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //jeżeli klikniemy ENTER
                if(e.getKeyChar() == '\n')
                    //ustawiamy test przycisku z nazwą miasta na to, co jest w TextField
                    jButtonL.setText(textField.getText());
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //ActionListener na przycisk ze "Zmień tytuł..."
        jButtonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //po kliknięciu przycisku — ustaw tytuł okna na to, co było wpisane w TextField
                jFrame.setTitle(textField.getText());
            }
        });

        //dodaj TextField do JFrame
        this.getContentPane().add(textField);

        //pack by zeskalować wielkość okna do wielkości komponentów
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

