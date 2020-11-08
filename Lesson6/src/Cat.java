class Cat extends Animal{
    private double maxRun, maxSwim, maxJump;

    Cat() {
        maxRun = Math.random() > 0.5 ? 100 : 300;
        maxSwim = 0;
        maxJump = Math.random() > 0.5 ? 1 : 3;
    }

    void swim(double lenght) {
        boolean result = lenght <= maxSwim;
        if (result) _lenghtSwim = lenght;
        showResult(this, result);
    }

    void run(double length) {
        boolean result = length <= maxRun;
        if (result) _lenghtRun = length;
        showResult(this,result);
    }

    void jump(double height) {
        boolean result = height <= maxJump;
        if (result) _heightJump = height;
        showResult(this,result);
    }
}