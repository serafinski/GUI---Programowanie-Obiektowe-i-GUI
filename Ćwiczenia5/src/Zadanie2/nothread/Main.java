package Zadanie2.nothread;

public class Main {
    public static void main(String[] args) {
        //początek pomiaru
        long start = System.currentTimeMillis();
        //pętla zgodnie z poleceniem
        for(int i =0; i<=1000000;i++){
            System.out.print(i);
        }
        //koniec pomiaru
        long end = System.currentTimeMillis();

        //wypisz pomiar
        System.out.println("\nCzas to: " + (end-start)+ "ms");


        //WINDOWS

        //POMIARY
        // 1) 1314 ms
        // 2) 1381 ms
        // 3) 1445 ms

        // Średnia: 1380 ms

        //MAC

        // 1) 1305 ms
        // 2) 935 ms
        // 3) 913 ms

        // Średnia: 1051 ms
    }
}
