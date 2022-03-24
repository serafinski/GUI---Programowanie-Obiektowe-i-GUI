package Zadanie7;

public abstract class AAnimal {
    private String name;

    // obiekt "klasy" Enum
    private Group group;

    public AAnimal(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString(){
        return "AAnimal{" + "name='" + name + '\'' + ", group=" + group +'}';
    };
}
