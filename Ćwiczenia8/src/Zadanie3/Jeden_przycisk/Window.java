package Zadanie3.Jeden_przycisk;

import javax.swing.*;

public class Window extends JFrame {

    public Window(){
        generateFrame();
    }

    public void generateFrame(){
        //tworzymy obiekt klasy InerWindow
        InerWindow inerWindow = new InerWindow();
        //dodajemy go do naszego JPanel'u
        this.getContentPane().add(inerWindow);
        this.pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
