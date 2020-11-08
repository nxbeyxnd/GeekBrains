abstract class Animal {
    protected double _lenghtRun;
    protected double _lenghtSwim;
    protected double _heightJump;

    abstract void run(double length);
    abstract void jump(double height);

    static void showResult(Object nameOfClass, boolean result) {
        System.out.println(nameOfClass.getClass().getName() + " : " + result);
    }
}
