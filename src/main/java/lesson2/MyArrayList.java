package lesson2;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <=0 " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[capacity];
    }

    public void add(T item) {
        // доделать проверку на превышение лоад фактора 0.75
        if (calculateLoadFactor(size,capacity) > 0.75)
            list = ensureCapacity(this.list);
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        // доделать проверку на превышение лоад фактора 0.75
        if (calculateLoadFactor(size,capacity) > 0.75)
            list = ensureCapacity(this.list);
        // доделать проверку на допустимость индекса
        checkIndex(index);

        if (size - index >= 0)
            System.arraycopy(list, index, list, index + 1, size - index);
        list[index] = item;
        size++;
    }

    private T[] ensureCapacity(T[] list){
        capacity*=2;
        T[] newList = (T[]) new Comparable[capacity];
        System.arraycopy(this.list,0,newList,0,size);
        return newList;
    }

    public final T remove(int index) {
        // доделать проверку на допустимость индекса
        checkIndex(index);

        T temp = list[index];
        System.arraycopy(list, index + 1, list, index, size - index);
        size--;
        list[size] = null;
        return temp;
    }

    public boolean remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        // доделать проверку на допустимость индекса
        checkIndex(index);
        return list[index];
    }

    public void set(int index, T item) {
        // доделать проверку на допустимость индекса
        checkIndex(index);
        list[index] = item;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private void checkIndex(int index){
        if (index > size - 1)
            throw new IllegalArgumentException("Out of bounds for size: " + this.size);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(" ]");
        return sb.toString();
    }


    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    public void selectionSort() {
        int iMin;
        for (int i = 0; i < size - 1; i++) {
            iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(list[j], list[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        T key;
        for (int i = 1; i < size; i++) {
            int j = i;
            key = list[i];
            while (j > 0 && less(key, list[j - 1])) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = key;
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                }
            }
        }
    }

    public void bubbleSortO() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(list[j + 1], list[j])) {
                    swap(j + 1, j);
                    isSwap = true;
                }
            }
            if( !isSwap){
                break;
            }
        }
    }

    private float calculateLoadFactor(int size, int capacity){
        float a = size;
        float b = capacity;
        return a/b;
    }
}

