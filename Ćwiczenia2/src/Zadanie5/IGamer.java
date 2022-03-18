package Zadanie5;

public interface IGamer {
    int play();

    default String name(){
        //ta linijka rozdziela to w taki sposób, że dostajemy nazwę gracza
        return this.getClass().getName().split("\\.") [ this.getClass().getName().split("\\.").length-1 ];
    }
}
