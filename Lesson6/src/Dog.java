class Dog extends Animal{
    private double maxRun, maxSwim, maxJump;
    
    Dog() {
        maxRun = Math.random() > 0.5 ? 400 : 600;
        maxSwim = Math.random() > 0.5 ? 5 : 15;
        maxJump = Math.random() > 0.5 ? 0.1 : 0.5;
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
