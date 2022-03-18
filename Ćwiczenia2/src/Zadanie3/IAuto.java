package Zadanie3;

public interface IAuto {
    //metoda default'owa — wiec może mieć ciało!
    default void move(){
        System.out.println("Drive, drive!");
    }
}
