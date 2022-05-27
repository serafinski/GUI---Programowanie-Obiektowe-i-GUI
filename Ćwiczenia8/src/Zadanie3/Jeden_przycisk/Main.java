package Zadanie3.Jeden_przycisk;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //robiąc to w taki sposób należy pamiętać, by zmienić Window na odpowiednie Window dla naszego katalogu (zadania)
        SwingUtilities.invokeLater(Window::new);
    }
}
