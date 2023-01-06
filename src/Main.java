import MRA.DSA.QueueArray;
import MRA.DSA.StackArray;

public class Main {
    public static void main(String[] args) {
        QueueArray q = new QueueArray(5);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        System.out.println(q.dequeue());
        q.enqueue(10);
        q.display();
        System.out.println(q.dequeue());
        q.enqueue(11);
        q.display();
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());
//        System.out.println(q.dequeue());

    }
}