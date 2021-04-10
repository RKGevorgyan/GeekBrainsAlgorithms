package lesson8;

import java.util.Random;

public class Main {
    static Random random;
    public static void main(String[] args) {
        random = new Random();
        ChainingHashMap<Integer, String> chm= new ChainingHashMap<>(5);

        chm.put(0, "one");
        chm.put(1, "one");
        chm.put(2, "two");
        chm.put(3, "three");
        chm.put(4, "four");
        chm.put(5, "five");
        chm.put(6, "six");
        chm.put(7, "seven");
        chm.put(8, "eight");
        chm.put(9, "nine");
        chm.put(10, "ten");
        chm.remove(5);
        chm.remove(13);
        chm.remove(8);
        chm.put(11, "three");
        chm.put(12, "three");
        chm.put(13, "three");
        chm.put(14, "three");

        System.out.println(chm);

    }
}
