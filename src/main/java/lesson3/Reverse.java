package lesson3;

public class Reverse {
    public static String reverse(String str) {
        MyStack<Character> stack = new MyStack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() ; i++) {
            stack.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
          sb.append(stack.pop());
        }
        return sb.toString();
    }
}
