package Zadanie7;

public class Worker {
    private String name;

    //zawsze musi być konstruktor
    public Worker(String name) {
        this.name = name;
    }

    //geter, by uzyskać imię
    public String getName() {
        return name;
    }

    public void cleanAnimal(AAnimal animal){
        System.out.println("Myje " + animal);
    }
    public void feedAnimal (AAnimal animal){
        System.out.println("Sprzatam " + animal);
    }

    @Override
    public String toString(){
        return "Worker{name='" + name + "'}";
    }
}
