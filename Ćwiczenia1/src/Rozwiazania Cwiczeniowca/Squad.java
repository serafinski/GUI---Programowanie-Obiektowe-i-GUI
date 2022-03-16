import java.util.ArrayList;
import java.util.List;

public class Squad {

    public static final int MAX_HERO_CAPCITY = 1;
    private String name;
    private Leader leader;
    private List<Hero> heroes = new ArrayList<>();

    public Squad(String name) {
        this.name = name;
    }

    public void addHero(Hero h)throws TooManyHeroesException {
        if(heroes.size()< MAX_HERO_CAPCITY){
            heroes.add(h);
        }else{
            throw new TooManyHeroesException();
        }

    }

    @Override
    public String toString(){
        StringBuffer heroesNames = new StringBuffer();
        for (Hero h: heroes) {
            heroesNames.append(h.getName());
            heroesNames.append(" ");

        }
        return this.name + ", leader: " + this.leader.getName() +", heroes: " + heroesNames.toString() ;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
