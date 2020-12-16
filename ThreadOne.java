import java.util.Arrays;

public class ThreadOne {
    static final int size = 10000000;
    static final int h = size / 2;
    private float[] arr = new float[size];

    private float[] a1 = new float[h];
    private float[] a2 = new float[h];

    private long a = System.currentTimeMillis();

    public void startTask() {
        fillArray(arr);

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        new Thread(() -> {
            calculator(a1);
            System.out.println("Time thread1 : " + (System.currentTimeMillis() - a));
        }).start();

        new Thread(() ->{
            calculator(a2);
            System.out.println("Time thread2 : " + (System.currentTimeMillis() - a));
        }).start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        calculator(arr);
        System.out.println("Time: " + (System.currentTimeMillis() - a));

    }

    private float[] fillArray(float[] arr){
        Arrays.fill(arr, 1);
        return arr;
    }

    private float[] calculator(float[] arr /*int increment*/){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return arr;
    }


}
