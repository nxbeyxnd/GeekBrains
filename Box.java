import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    private List<T> getFruits() {
        return fruits;
    }

    public void put(T... fruit){
        for (int i = 0; i < fruit.length; i++)
        {
            fruits.add(fruit[i]);
        }
    }

    public boolean compare(Box<?> other){
        try {
            return fruits.get(0).getWeight() * fruits.size() == other.getFruits().get(0).getWeight() * other.getFruits().size();
        } catch (IndexOutOfBoundsException e){
            System.out.println("Error:" + e);
            return false;
        }
    }

    public void changeAnyBox(Box<T> other) {
        fruits.addAll(other.getFruits());
        other.fruits.clear();
    }

    public String showWeight(){
        return String.format("%s weight: %d",getClass().getName(),fruits.size());
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
