package lesson2;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> integers = new MyArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 100000; i++) {
            integers.add(r.nextInt(100));
        }
       long time = System.currentTimeMillis();
       //integers.bubbleSort(); // 40883
        // integers.bubbleSortO(); // 37965
       // integers.insertionSort();  // 3790
       // integers.selectionSort(); // 16824
        System.out.println(System.currentTimeMillis() - time);

    }
}
