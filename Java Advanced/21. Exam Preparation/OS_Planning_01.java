import java.util.ArrayDeque;
import java.util.Scanner;

public class OS_Planning_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> taskStack = new ArrayDeque<>();
        String[] taskInput = scanner.nextLine().split(", ");
        //Integer[] taskInput = Integer.parseInt(scanner.nextLine().split(", "));
        for (int i = 0; i < taskInput.length; i++) {
            int current = Integer.parseInt(taskInput[i]);
            taskStack.push(current);
        }
        String[] threadInput = scanner.nextLine().split(" ");
        for (int i = 0; i < threadInput.length; i++) {
            int current = Integer.parseInt(threadInput[i]);
            threadsQueue.offer(current);
        }
        int taskToKill = Integer.parseInt(scanner.nextLine());

        int thread = threadsQueue.peek();
        int task = taskStack.peek();

        while (task != taskToKill) {

            if(thread >= task){
                taskStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

            thread = threadsQueue.peek();
            task = taskStack.peek();
        }

        System.out.printf("Thread with value %d killed task %d%n", thread, taskToKill);
        for (Integer n : threadsQueue) {
            System.out.print(n + " ");
        }
    }
}
