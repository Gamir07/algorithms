package algorithm1;

public class StringListImpl implements StringList {

    private final String[] list;
    private int size;

    public StringListImpl(int capacity) {
        list = new String[capacity];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        if (size < list.length) {
            list[size] = item;
            size++;
        } else {
            throw new ListIsFullException();
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        if (index < 0 || index >= size || size == list.length) {
            throw new ListIndexOutOfBoundsException();
        }

        for (int i = size; i > index; i--) {
            list[i] = list[i - 1];
        }
        size++;
        return list[index] = item;

    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        if (index < 0 || index >= size) {
            throw new ListIndexOutOfBoundsException();
        }
        return list[index] = item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFoundException();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        String object = get(index);
        for (int i = index; i < size; i++) {
            list[i] = list[i + 1];
        }
        size--;
        return object;
    }

    @Override
    public boolean contains(String item) {
        validateItem(item);
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ListIndexOutOfBoundsException();
        } else {
            return list[index];
        }
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!list[i].equals(otherList.get(i))) {
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
//        for (int i = 0; i < size; i++) {
//            list[i] = null;
//        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = get(i);
        }
        return newArray;
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException();
        }
    }
}
