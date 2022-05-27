package Zadanie3.Dwa_przyciski;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InerWindow extends JPanel {

    private JButton button;
    private JTextArea jTextArea;
    private final ActionListener showWordAction = new ShowWord();
    private final ActionListener backAction = new Back();

    private String mainText;

    public InerWindow(){
        generateFrame();
    }

    private void generateFrame() {
        //JTextArea — pozwala nam na dodawanie enterów!
        jTextArea = new JTextArea(30, 30);

        //nowy typ kontenera — opakuje jTextArea
        JScrollPane scrollableTextArea = new JScrollPane(jTextArea);

        //i będzie się rozszerzał w obrębie JScrollPane'a, wraz z paskami przewijania
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        this.add(scrollableTextArea);

        button = new JButton(stringShowWord);
        button.setPreferredSize(new Dimension(150,20));
        this.add(button);
        button.addActionListener(this.showWordAction);

    }

    private final String stringShowWord = "ShowWord";

    private class ShowWord implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            button.removeActionListener(showWordAction);
            button.setText("Back");
            button.addActionListener(backAction);


            String text = jTextArea.getText();
            HashSet<String> words = new HashSet<>();


            Pattern pattern = Pattern.compile("\\b\\w+\\b");
            Matcher matcher = pattern.matcher(text);

            while(matcher.find()) {
                words.add(matcher.group().toLowerCase());
            }

            mainText = text;

            StringBuilder sb = new StringBuilder();
            for (String word :
                    words) {
                sb.append(word);
                sb.append('\n');
            }
            jTextArea.setText(sb.toString());
        }
    }

    private class Back implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextArea.setText(mainText);
            button.removeActionListener(backAction);
            button.setText(stringShowWord);
            button.addActionListener(showWordAction);
        }
    }

}
