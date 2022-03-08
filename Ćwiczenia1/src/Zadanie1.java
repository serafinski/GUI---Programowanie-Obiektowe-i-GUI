public class Zadanie1 {
    public static void main(String[] args) {

        Hero h1 = new Hero ("Jan",50);
        Leader l1 = new Leader ("Eagle",20);
        Hero h3 = (Hero)l1;

        h1.sayHelloTo(h3);
        h3.sayHelloTo(h1);

        Squad s = new Squad ("DELTA");

        s.setLeader(l1);
        try{
            s.addHero(h1);
            s.addHero(h3);
        } catch (TooManyHeroesException e){
            e.printStackTrace();
        }

        System.out.println(s);
    }
}
class Hero{
    public String name;
    public int power;

    Hero (String name, int power){
        this.name = name;
        this.power = power;
    }

    public String sayHelloTo(Hero h0){
        return "Hello " + h0.name;
    }

    public String getName() {
        return name;
    }
}

class Leader
        extends Hero{

    Leader(String name, int power) {
        super(name, power);
    }

}
class Squad{
    public String squad_name;
    public int ilosc = 1;
    public Leader leader;
    public Hero[] tab = new Hero[ilosc];
    public int counter = 0;

    Squad(String squad_name){
        this.squad_name = squad_name;
    }

    public String getSquad_name() {
        return squad_name;
    }

    public void setLeader (Leader l0){
        leader = l0;
    }

    public void addHero(Hero h0) throws TooManyHeroesException{
        counter+=1;

        for(int i =0; i<tab.length;i++)
            while (tab[i]==null){
            tab[i]=h0;
            }

        if (counter>tab.length)
            throw new TooManyHeroesException();
    }

    public String toString(){
        return getSquad_name()+", Leader "+ leader.name +", Hero "+tab[0].name;
    }

}