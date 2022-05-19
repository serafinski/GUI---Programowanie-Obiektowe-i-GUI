package Zadanie2.Opcja3_Bonusowa;

import javax.swing.*;
import java.awt.*;

//dziedziczy po JFrame
public class MyWindow extends JFrame{
    public MyWindow(){
        //zadeklarowanie JPanel w MyWindow
        MyJPanel jPanel = new MyJPanel();

        //ustawiamy wielkość JPanel'u
        jPanel.setPreferredSize(new Dimension(1024,768));

        //KLUCZOWE — dodanie JPanel'u do naszego JFrame
        this.add(jPanel);

        //automatyczne skalowanie -> ustalona wielkość przez nas nie ma znaczenia,
        //bo i tak zostanie nadpisana przez pack()
        this.pack();

        //ustawiamy tytuł
        this.setTitle("Zadanie 2 - BONUS z JPanel");
        //ustawiamy zamykanie
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //stworzenie wątku gdzie pracuje na JPanel'u
        Thread thread =  new Thread(jPanel);

        //uruchomienie wątku
        thread.start();

        //ustawiamy widoczność okna
        setVisible(true);
    }
}