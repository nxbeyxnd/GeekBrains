public class Main {

    private static int TIME = 0;

    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("John", 150, 3);
        cat[1] = new Cat("Igor", 100, 4);
        cat[2] = new Cat("Maxim", 30, 1);
        Plate plate = new Plate(700);
        System.out.println(plate.getFood() + " food");
        do {
            for (Cat i : cat) {
                if (i.getSatiety() == 0) {
                    if (!plate.checkFood(i.getAppetite())) {
                        plate.increaseFood();
                    }
                    i.eat(plate);
                    System.out.println("Cat " + i.getName() + " eats " + i.getAppetite() + " food, after " + (i.getSatiety()) + " hours he want eat again");
                }
                i.setSatiety(i.getSatiety() - 1);
            }
            System.out.println("\nTime " + TIME + " hours, remaining " + plate.getFood() + " food.\n");
            TIME++;

        } while (TIME <= 24);
    }
}