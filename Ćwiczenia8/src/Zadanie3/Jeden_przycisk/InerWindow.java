package Zadanie3.Jeden_przycisk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InerWindow extends JPanel {

    JButton button;
    ActionListener showWordAction = new ShowWord();
    ActionListener backAction = new Back();

    public InerWindow(){
        generateFrame();
    }

    private void generateFrame() {
        //JTextArea — pozwala nam na dodawanie enterów!
        JTextArea jTextArea = new JTextArea(30, 30);

        //nowy typ kontenera — opakuje jTextArea
        JScrollPane scrollableTextArea = new JScrollPane(jTextArea);

        //i będzie się rozszerzał w obrębie JScrollPane'a, wraz z paskami przewijania
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollableTextArea);

        button = new JButton(stringShowWord);
        button.setPreferredSize(new Dimension(150,20));
        this.add(button);

        //dodanie listener'a do przycisku — tego, który będzie inicjowany, przy uruchomieniu programu
        //nie musimy dodawać drugiego, bo przejście jest zawarte w samym ActionListener
        button.addActionListener(this.showWordAction);

    }

    //to będzie wypisywane na konsoli po kliknięciu przycisku i zamienianie na przycisku
    private String stringShowWord = "ShowWord";
    private String stringBack = "Back";

    private class ShowWord implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //wypisanie ShowWord
            System.out.println(stringShowWord);
            //usunięcie listener'a do showWordAction
            button.removeActionListener(showWordAction);
            //zmiana tekstu przycisku na Back
            button.setText(stringBack);
            //dodanie listner'a do akcji dla back
            button.addActionListener(backAction);
        }
    }

    private class Back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //wypisanie Back
            System.out.println(stringBack);
            //usunięcie listener'a do backAction
            button.removeActionListener(backAction);
            //ustawienie tekstu przycisku na ShowWord
            button.setText(stringShowWord);
            ////dodanie listner'a do akcji dla show word
            button.addActionListener(showWordAction);
        }
    }

}