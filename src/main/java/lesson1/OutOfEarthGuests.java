package lesson1;

import java.io.PrintWriter;
import java.util.Scanner;

public class OutOfEarthGuests {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        if ( a >= b + c) {
            out.println("YES");
        }
        else {
            out.println("NO");
        }
        out.flush();
    }
}
