package algorithm2;

import algorithm1.ElementNotFoundException;
import algorithm1.ListIndexOutOfBoundsException;
import algorithm1.ListIsFullException;
import algorithm1.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private final int[] list;
    private int size;

    public IntegerListImpl(int capacity) {
        list = new int[capacity];
    }



    @Override
    public Integer add(Integer item) {
        itemValidation(item);
        capacityValidation();
        list[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        itemValidation(item);
        indexValidation(index);
        capacityValidation();
        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        size++;
        return list[index] = item;
    }

    @Override
    public Integer set(int index, Integer item) {
        itemValidation(item);
        indexValidation(index);
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        itemValidation(item);
        int i = indexOf(item);
        if (i < 0) {
            throw new ElementNotFoundException();
        }
        return remove(i);
    }

    @Override
    public Integer remove(int index) {
        indexValidation(index);
        Integer item = get(index);
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        int[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy,item);
    }

    @Override
    public int indexOf(Integer item) {
        itemValidation(item);
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        itemValidation(item);
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        indexValidation(index);
        return list[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (list[i] != otherList.get(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int[] toArray() {
        return Arrays.copyOf(list, size);
    }

    private void itemValidation(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private void indexValidation(int index) {
        if (index >= size || index < 0) {
            throw new ListIndexOutOfBoundsException();
        }
    }

    private void capacityValidation() {
        if (size == list.length) {
            throw new ListIsFullException();
        }
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public boolean binarySearch(int[] arr, Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == arr[mid]) {
                return true;
            }

            if (item < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
