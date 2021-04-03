package lesson6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

       createTree(10000);

    }

    public static void createTree( int tree){
        Random random = new Random();
        int balanced = 0;
        for (int i = 0; i < tree; i++) {
            MyTreeMap1<Integer, Integer> map = new MyTreeMap1<>();
            int randomNumber = 0;
            while (map.height() < 6) {
                randomNumber = random.nextInt(201) - 100;
                map.put(randomNumber, randomNumber);
            }
            map.delete(randomNumber);
            if (map.isBalance()) {
                balanced++;
            }
        }
        System.out.println("Balanced Trees: " + balanced + "\n" + "Percent: " + (double)balanced/tree * 100
                + "%\n" +"Count Trees: " + tree);
    }
}
