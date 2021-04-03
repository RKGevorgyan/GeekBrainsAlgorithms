package lesson5;

public class BackPack {
    public static void main(String[] args) {
        int[] prices = new int[] {100, 20, 30, 40, 50};  // стоимость
        int[] weights = new int[] {3, 2, 4, 5,9};   // вес
        int size = 5;  // вместимость рюкзака
        int[] tab = new int[size + 1];
        System.out.println("Максимальная стоимость при вместительности: " + size + " : " +
                knapsack(prices, weights, size, tab, 0));
    }


    static int knapsack(int[] prices, int[] weights, int size, int[] tab, int i) {
        if( i >= prices.length)
            return 0;
        if(tab[size] != 0)
            return tab[size];
        int value1 = knapsack(prices, weights, size, tab, i+1);
        int value2 = 0;
        if(size >= weights[i]) {
            value2 = knapsack(prices, weights, size - weights[i], tab, i + 1) + prices[i];
        }
        return tab[size] = Math.max(value1, value2);
    }


}
