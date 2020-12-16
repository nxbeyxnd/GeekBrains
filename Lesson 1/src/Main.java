public class Main {

    public static void main(String[] args) {
        boolean varTaskFour;
        boolean varTaskSix;
        String name = "Alexey";
        int a,b,c,d,e,f;

        a = 10;
        b = 2;
        c = 6;
        d = 3;
        e = -1;
        doTaskThree(a,b,c,d);

        varTaskFour = doTaskFour(a,b);
        System.out.println(varTaskFour);

        doTaskFive(c);

        varTaskSix = doTaskSix(e);
        System.out.println(varTaskSix);

        doTaskSeven(name);

        f = 100;
        doTaskEight(f);

        //doTest(f);
    }

    //
    //     Задание 2
    //
    static void doTaskTwo(){
        short var = 1;
        int var1 = 1;
        long var3 = 2222222222222222l;

        float var4 = 0.1f;
        double var5 = 0.5555d;

        char var6 = 's';
        String var7 = "Hello";

        boolean var8 = true;
    }

    //
    //    Задание 3
    //
    static void doTaskThree(int a, int b, int c, int d){
        int reusltTask;
        reusltTask = a * (b + (c / d));
        System.out.println("Ответ: " + reusltTask);
    }

    //
    //    Задание 4
    //
    static boolean doTaskFour(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <=20;
    }

    //
    //    Задание 5
    //
    static void doTaskFive(int c){
        if (c >= 0) System.out.println("Число положительное");
        else System.out.println("Число отрацательное");
    }

    //
    //    Задание 6
    //
    static boolean doTaskSix(int e){
        return e < 0;
    }

    //
    //    Задание 7
    //
    static void doTaskSeven(String name){
        System.out.print("Привет, ");
        System.out.print(name);
        System.out.println("!");
    }

    //
    //    Задание 8
    //
    static void doTaskEight(int year){
        String leapYear = " год - високосный!";
        String notLeapYear = " год - не вискосный!";

        if (year % 100 == 0 && year % 400 != 0) System.out.println(year + notLeapYear);
        else if (year % 4 == 0) System.out.println(year + leapYear);
        else System.out.println(year + notLeapYear);
    }

    // Первый "СТРАШНЫЙ" и первый способ решения
//    static void doTest (int year) {
//
//        if (year % 4 == 0) {
//            if (( year % 100 == 0)){
//                if (year % 400 == 0) System.out.println(year + " год - високосный.");
//                else System.out.println(year + " год - не високосный.");
//            }
//            else System.out.println(year + " год - високосный.");
//        }
//        else System.out.println(year + " год - не високосный.");
//    }

}