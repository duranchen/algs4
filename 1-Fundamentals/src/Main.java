import java.util.Random;

public class Main {

    private static double testQueue(Queue<Integer> q, int count) {
        Stopwatch sw = new Stopwatch();

        Random rd = new Random();

        for (int i = 0; i < count; i++) {
            q.enqueue(rd.nextInt());
        }

        for (int i = 0; i < count; i++) {
            q.dequeue();
        }

        double escapedTime = sw.elapsedTime();

        return escapedTime;
    }

    public static void main(String[] args) {
        ResizingArrayQueue<Integer> raq = new ResizingArrayQueue<>();

        LinkedListQueue<Integer> llq = new LinkedListQueue<>();

        int count = 10000000;

        double time = testQueue(raq, count);
        double time2 = testQueue(llq, count);

        System.out.println("ResizingArrayQueue time: " + time);
        System.out.println("LinkedListQueue time: " + time2);
    }
}
