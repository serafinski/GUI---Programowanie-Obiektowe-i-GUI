package Zadanie7;

public class Main {
    public static void main(String[] args) {
        //tworzymy nowe zoo
        Zoo zoo = new Zoo();

        //tworzymy klatkę dla mięsożerców
        Enclosure<ACarnivore> aCarnivoreEnclosure = new Enclosure<>();

        //dodajemy klatkę do zoo
        zoo.addEnclosure(aCarnivoreEnclosure);

        //w poleceniu podobno miało być napisane, że chcą byśmy utworzyli -> specjalny typ pracownika, który potrafi leczyć zwierzęta

        //tworzymy pracownika, który ma na imie Bob
        Worker workerNormal = new Worker("Bob");

        //tworzymy pracownika, który jest doktorem i ma na imię Dorian

        //KLASA ANONIMOWA!!!
        Worker workerDoc = new Worker("Dorian"){

            //metoda, w której leczy zwierzęta
            public void healAnimal(AAnimal animal){
                System.out.println("Lecze " + animal);
            }

            @Override
            public String toString() {
                return "$classname{" +
                        "name='" + this.getName() + '\'' +
                        "speciality='" + "Doc" + '\'' +
                        '}';
            }
        };

        //dodajemy pracowników do listy pracowników
        zoo.getWorkerList().add(workerNormal);
        zoo.getWorkerList().add(workerDoc);

        //do klatki dla mięsożerców dodajemy Lwa
        aCarnivoreEnclosure.addAnimalToEnclosure(new Lion("HappyLion", Group.MAMMAL));

        //próba dodania do tej klatki Żyrafy kończy się błędem, bo nie jest mięsożercą -> mismatch typów!

        //aCarnivoreEnclosure.addAnimalToEnclosure(new Giraffe("SuperSadGiraff", Group.MAMMAL));

        //tworzymy klatkę dla roślinożerców
        zoo.addEnclosure(new Enclosure<AHerbivore>());

        //TUTAJ POJAWIAJĄ SIĘ BŁĘDY I NIEŚCISŁOŚCI

        //Zamiast się odwoływać bezpośrednio -> do zparametryzowanego obiektu
        //najpierw odwołujemy się do zoo i wyciągamy z niego klatkę.
        //Dodajemy do klatki dla roślinożerców Żyrafę,
        //POWSTAJE RAW TYPING -> spowodowany brakiem parametryzacji w klasie Zoo!
        zoo.getEnclosureList().get(1).addAnimalToEnclosure(new Giraffe("HappyGiraff", Group.MAMMAL));

        //ALE — możemy też dodać do niej Lwa -> co nie powinno mieć miejsca -> NIEBEZPIECZEŃSTWO RAW TYPING'U
        zoo.getEnclosureList().get(1).addAnimalToEnclosure(new Lion("SuperHappyLion", Group.MAMMAL));

        //Możemy pójść nawet dalej -> dodać do klatki również pracownika!
        //gdyby tu było addAnimalToEnclosure — to by się nie udało -> bo ta metoda jest zparametryzowana na typ generyczny dziedziczący po AAnimal
        //przez to, że to odwołanie jest robione w taki sposób -> możemy odwołać się do listy zwierząt, które powinny być w tej klatce,
        //KTÓRA JUŻ NIE JEST ZPARAMETRYZOWANA! A add jest na Object — wiec możemy do tej klatki wrzucić cokolwiek, co jest obiektem
        zoo.getEnclosureList().get(1).getEnclosure().add(workerNormal);


        //wypisanie wszystkich zwierząt
        //jak widać, uznaje pracownika za zwierzę -> co nie powinno mieć miejsca!!!
        zoo.showAllAnimals();

        System.out.println();

        //wypisanie wszystkich pracowników
        zoo.showAllWorkers();


    }
}
