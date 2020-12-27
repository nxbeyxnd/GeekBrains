import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SwapElements<T> implements Swapable<T> {
    private T[] arr;

    @Override
    public void putAndSwap(T... arr) {
        this.arr = arr;
        swapArray(arr);
    }

    public T[] swapArray(T[] arr) {
        T safe = arr[0];
        arr[0] = arr[arr.length-1];
        arr[arr.length-1] = safe;
        return arr;
    }

    @Override
    public T[] get() {
        return arr;
    }

    public ArrayList<T> refactorToArrayList (T[] arr){
        ArrayList<T> refactoredList = new ArrayList<>();
        Collections.addAll(refactoredList, arr);

        return refactoredList;
    }

    @Override
    public String toString() {
        return "SwapElements{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
