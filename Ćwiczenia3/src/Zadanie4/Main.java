package Zadanie4;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet <Integer> hashSet= new HashSet<>();

        hashSet.add(31);
        hashSet.add(28);
        hashSet.add(31); // w hashset wartości nie mogą się powtarzać!
        hashSet.add(30);

        System.out.println(hashSet);
    }
}
