package Zadanie3;

public interface IBoat {
    //metoda default'owa — wiec może mieć ciało!
    default void move(){
        System.out.println("Swim, swim!");
    }
}
