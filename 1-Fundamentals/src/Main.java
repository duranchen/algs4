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

    private static double testStack(Stack<Integer> s, int count)
    {
        Stopwatch sw = new Stopwatch();

        Random rd = new Random();

        for (int i = 0; i < count; i++) {
            s.push(rd.nextInt());
        }

        for (int i = 0; i < count; i++) {
            s.pop();
        }

        double escapedTime = sw.elapsedTime();

        return escapedTime;
    }

    public static void main(String[] args) {
//        ResizingArrayQueue<Integer> raq = new ResizingArrayQueue<>();
//        LinkedListQueue<Integer> llq = new LinkedListQueue<>();
//
        int count = 10000000;
//
//        double queueTime = testQueue(raq, count);
//        double queueTime2 = testQueue(llq, count);
//
//        System.out.println("ResizingArrayQueue time: " + queueTime);
//        System.out.println("LinkedListQueue time: " + queueTime2);

        ResizingArrayStack<Integer> ras = new ResizingArrayStack<>();
        LinkedListStack<Integer> lls = new LinkedListStack<>();

        double stackTime = testStack(ras,count);
        double stackTime2 = testStack(lls,count);
        System.out.println("ResizingArrayStack time: " + stackTime);
        System.out.println("LinkedListStack time: " + stackTime2);


    }
}
