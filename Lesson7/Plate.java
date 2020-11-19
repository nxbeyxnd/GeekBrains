class Plate {

    private int food;

    int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood() {
        this.food += 400;
        System.out.println("Added 400");
    }

    public boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}