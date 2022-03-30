package Zadanie1;

public class Main {
    public static void main(String[] args) {


        //można użyć tego -> opcja bez lambda

        /*
        ICalc myAdd = new ICalc() {
            @Override
            public int Method(int a, int b) {
                return a+b;
            }
        };
         */

        //przykład pokazujący, że lambda nie zawsze musi być pojedynczą funkcją -> mając nawiasy klamrowe możemy mieć dalej kolejne instrukcje oddzielone średnikami
        ICalc myAddLambda = (a, b) -> {return a+b;};

        ICalc mySubtractLambda = (a,b) -> a-b;
        ICalc myMultiplyLambda = (a,b) -> a*b;
        ICalc myDivideLambda = (a,b) -> a/b;

        System.out.println(myAddLambda.Method(5,5));
        System.out.println(mySubtractLambda.Method(5,5));
        System.out.println(myMultiplyLambda.Method(5,5));
        System.out.println(myDivideLambda.Method(5,5));
    }
}
