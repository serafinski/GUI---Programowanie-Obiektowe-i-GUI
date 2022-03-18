package Zadanie1;

//dodajemy słowo kluczowe implements oraz nazwę interfejsu -> w tym wypadku gotowego interfejsu Comparable
public class Square implements Comparable<Square>{
    private int length;
    private int number;

    //słowo kluczowe static pozwala na to, że będą się zwiększać liczby — a nie cały czas 0
    private static int counter;

    public Square(int length){
        this.length = length;
        //musimy zwiększać counter -> bo tylko on ma słowo kluczowe static
        this.number = counter++;
    }

    public int getArea(){
        return length*length;
    }

    @Override
    public String toString(){
        return "id="+number+", area:"+getArea();
    }


    //należy nadpisać zgodnie z tym, co było mówione na zajęciach na temat metody compareTo
    @Override
    public int compareTo(Square o) {
        if(this.length == o.length)
            return 0;
        else if(this.length > o.length)
            return 1;
        else
            return -1;
    }
}
