public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        System.out.println("Run:");
        dog.run(150);
        cat.run(150);

        System.out.println("Jump:");
        dog.jump(0.5);
        cat.jump(11);

        System.out.println("Swim:");
        dog.swim(3);
        cat.swim(0);
    }
}
