
import algorithm2.IntegerListImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100001);
        }

        long start = System.currentTimeMillis();
        IntegerListImpl.sort(array); //1078
        System.out.println(System.currentTimeMillis() - start);

    }
}
