package lesson5;

public class Degreeing {

    public static int toPower(int k, int n){
        if (n == 1)
            return k;
        return k*toPower(k, n-1);
    }

    public static void main(String[] args) {
        System.out.println(toPower(3,7));
    }
}


