package Zadanie4;

public class Main {
    public static void main(String[] args) {
        //za każdym razem tworząc nowego śpiewaka nadpisujemy metodę śpiewaj
        Spiewak s1 = new Spiewak("Madeon") {
            @Override
            public String spiewaj() {
                return "All my friends are watching, I can hear them talking";
            }
        };

        Spiewak s2 = new Spiewak("The 1975") {
            @Override
            public String spiewaj() {
                return "I don't want your body But I hate to think about you with somebody else";
            }
        };

        Spiewak s3 = new Spiewak("Childish Gambino") {
            @Override
            public String spiewaj() {
                return "No matter what you say or what you do. When I'm alone, I'd rather be with you";
            }
        };

        //tworzymy tablice śpiewaków
        Spiewak spiewacy[] = {s1,s2,s3};

        //advance for -> wypisujemy wszystkich śpiewaków
        for(Spiewak s: spiewacy)
            System.out.println(s);

        System.out.println();

        //wypisujemy najgłośniejszego -> metoda .najgłośniej()
        System.out.println("Najgłosniej spiewa: " +Spiewak.najgłosniej(spiewacy));
    }
}
