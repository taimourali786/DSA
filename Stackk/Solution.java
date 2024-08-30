public class Solution {

    public static void main(String[] args) {
        Stackk<String> s = new Stackk<>(10, String.class);
        s.push("H");
        s.push("E");
        s.push("L");
        s.push("L");
        s.push("O");

        // System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
