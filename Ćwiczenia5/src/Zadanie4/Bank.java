package Zadanie4;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private HashMap<Person,Account> personAccountHashMap = new HashMap<>();

    //konstruktor
    public HashMap<Person, Account> getPersonAccountHashMap() {
        return personAccountHashMap;
    }

    //synchronizacja — bo bez niej nie będzie taka sama kwota — po przelewie środków!
    //metoda przyjmująca konta jako parametry!
    synchronized public void transakcja (Account from, Account to, long wartosc)throws Exception{
        //jeżeli wartość funduszy na koncie, z którego przelewamy jest większa równa kwocie przelewanej
        if(from.getBalance() >= wartosc){
            //ustaw wartość funduszy konta, z którego przelewamy na pomniejszoną o wartość przelewaną
            from.setBalance(from.getBalance()-wartosc);
            //ustaw wartość funduszy konta, do którego przelewamy na powiększoną o wartość przelewaną
            to.setBalance(from.getBalance()+wartosc);
        }
        //jeżeli wartość funduszy jest mniejsza od kwoty
        else
            //wyrzuć exception!
            throw new Exception("Brak funduszy!");
    }

    //synchronizacja — bo bez niej nie będzie taka sama kwota — po przelewie środków!
    //metoda przyjmująca osoby jako parametry!
    synchronized public void transakcja (Person from, Person to, long wartosc) throws Exception{

        //jeżeli wartość funduszy wzięta z Hash Map'y dla konta, z którego przelewamy, jest większa bądź równa kwocie, którą przelewamy
        if(this.getPersonAccountHashMap().get(from).getBalance() >= wartosc){
            //ustaw wartość funduszy konta, z którego przelewamy na pomniejszoną o wartość przelewaną
            this.getPersonAccountHashMap().get(from).setBalance(this.getPersonAccountHashMap().get(from).getBalance() - wartosc);
            //ustaw wartość funduszy konta, do którego przelewamy na powiększoną o wartość przelewaną
            this.getPersonAccountHashMap().get(to).setBalance(this.getPersonAccountHashMap().get(to).getBalance()+ wartosc);
        }
        //jeżeli wartość funduszy jest mniejsza od kwoty
        else
            //wyrzuć exception!
            throw new Exception("Brak funduszy!");
    }

    //sprawdzamy, czy suma końcowa się zgodziła -> czy działa synchronizacja
    public long getSuma(){
        //init
        long rezultat = 0;

        //for loop dla Hash Map'y!
        //dla Hash Map'y bierzemy w niej wystąpienia
        for(Map.Entry<Person,Account> entry: this.getPersonAccountHashMap().entrySet()){
            //dodajemy do zmiennej rezulat -> stany konta
            rezultat+=entry.getValue().getBalance();
        }
        //zwracamy rezultat
        return rezultat;
    }
}
