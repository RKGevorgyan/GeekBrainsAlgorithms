package lesson8;

public class LinearProbingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private final Object DELETED;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        DELETED = new Object();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(Key key, Value value){
        // проверка на прввышение лоад фактора. Либо просаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;
        while (keys[i] != null){
            if(keys[i].equals(key)){
                values[i]= value;
                return;
            }
            i = (i+step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }
}
