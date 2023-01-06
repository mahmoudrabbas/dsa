import MRA.DSA.ArrayStack;

public class Main {
    public static void main(String[] args) {
        ArrayStack as = new ArrayStack(5);

        as.display();
        as.push(5);
        as.push(6);
        as.push(7);
        as.push(8);
        as.push(9);

        System.out.println(as.peek());
        System.out.println(as.pop());
        System.out.println(as.peek());

        as.display();
    }
}