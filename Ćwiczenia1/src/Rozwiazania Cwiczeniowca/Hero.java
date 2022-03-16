public class Hero {
    private String name;
    private int skill;

    public Hero(String name, int skill) {
        this.name = name;
        this.skill = skill;
    }

    public void sayHelloTo(Hero h){
        System.out.println("Hi " + h.getName() + "!");
    }

    public String getName() {
        return name;
    }

    public int getSkill() {
        return skill;
    }
}
