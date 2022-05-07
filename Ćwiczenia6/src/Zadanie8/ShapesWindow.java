package Zadanie8;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
//JFrame dla renderowania wszystkich figur
public class ShapesWindow extends JFrame {

    //dodawanie do listy zgodnie z poleceniem
    List<Renderable> renderableList= new ArrayList<>();

    //ustalenie parametrów JFrame'a
    ShapesWindow(){
        this.setSize(1024,768);
        this.setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //dodawanie elementów do listy, która będzie renderowana
    public void addShape(Renderable r){
        renderableList.add(r);
    }

    //malowanie tego co jest
    public void paint(Graphics g){
        g.clearRect(0,0,getWidth(),getHeight());
        //super.paint(g);

        //iteracja po liście figur za pomocą for each
        for(Renderable r : this.renderableList){
            //wywołanie na rzecz każdej z figur metody render
            r.render(g);
        }
    }
}
