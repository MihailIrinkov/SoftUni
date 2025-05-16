import java.util.*;

public class ShortestPath_04 {

    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < edges; i++) {
            int[] paths = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(paths[0]).add(paths[1]);
        }

        int source = Integer.parseInt(scanner.nextLine());
        int destination = Integer.parseInt(scanner.nextLine());

        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];

        for (int i = 0; i < prevNodes.length; i++) {
            prevNodes[i] = -1;
        }

        bfs(graph, source, destination);

        List<Integer> path = new ArrayList<>();

        path.add(destination);

        int prevNode = prevNodes[destination];

        while (prevNode != -1) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        System.out.println("Shortest path length is: " + (path.size() - 1));

        for (int i = path.size() - 1; i >= 0 ; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static void bfs(List<List<Integer>> graph, int source, int destination) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == destination) {
                return;
            }

            for (int child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    queue.offer(child);
                }
            }
        }
    }

}
