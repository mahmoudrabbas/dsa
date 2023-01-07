import MRA.DSA.PriorityQueueArray;
import MRA.DSA.QueueArray;
import MRA.DSA.StackArray;

public class Main {
    public static void main(String[] args) {
        PriorityQueueArray q = new PriorityQueueArray(5);
        System.out.println(q.isEmpty());
        q.enqueue(6);
        q.enqueue(9);
        q.enqueue(7);
        q.enqueue(5);
        q.enqueue(8);

        System.out.println("Dequeue: "+ q.dequeue());

        q.display();
    }
}