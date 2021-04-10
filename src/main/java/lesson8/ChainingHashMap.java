package lesson8;

import java.util.LinkedList;

public class ChainingHashMap<Key, Value> {
    private int capacity;
    private int size;
    private int loadFactor = 3;
    private LinkedList<Node>[] st;

    public ChainingHashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        st = new LinkedList[capacity];
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
    }

    private class Node {
        Key key;
        Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
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

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }
        }
        st[i].addLast(new Node(key, value));
        size++;
        checkCapacity(i);
    }

    public Value get(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        for (Node node : st[i]) {
            if (key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacity; i++) {
            for (Node node : st[i]) {
                sb.append(node.key).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    //реализовать метод удаления.
    public Value remove(Key key) {
        checkKeyNotNull(key);
        int i = hash(key);
        Value tmp = get(key);
        if(st[i].removeIf(h -> h.key == key)){
            size--;
        }
        return tmp;
    }
    public void changeCapacity() {
        LinkedList<Node>[] tmp = st;
        capacity *= 2;
        st = new LinkedList[capacity];
        size = 0;
        for (int i = 0; i < st.length; i++) {
            st[i] = new LinkedList<>();
        }
        Node tmpNode;
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].size(); j++) {
                tmpNode = tmp[i].get(j);
                put(tmpNode.key, tmpNode.value);
            }
        }
    }
    public void checkCapacity(int i) {
        if (st[i].size() >= loadFactor) {
            changeCapacity();
        }
    }
}
