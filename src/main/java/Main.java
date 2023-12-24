
import algorithm2.IntegerListImpl;

import java.util.Arrays;

import static algorithm2.IntegerListImpl.quickSort;

public class Main {
    public static void main(String[] args) {

//        int[] array = new int[100000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (int) (Math.random() * 100001);
//        }
        int[] array = {5, 8, 7, 4, 1, -9, 6};

        quickSort(array, 0, array.length - 1); //1078
        System.out.println(Arrays.toString(array));
    }
}
