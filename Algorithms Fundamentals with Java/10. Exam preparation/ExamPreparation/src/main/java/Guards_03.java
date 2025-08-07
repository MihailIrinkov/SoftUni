import java.util.*;

public class Guards_03 {

    private static final Set<Integer> visitedNodes = new HashSet<>();
    private static final Set<Integer> notVisitedNodes = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        int nodes = Integer.parseInt(scanner.nextLine());
        int edgeCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nodes; i++) {
            notVisitedNodes.add(i + 1);
            graph.put(i + 1, new HashSet<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int from = Integer.parseInt(edge[0]);
            int to = Integer.parseInt(edge[1]);

            graph.get(from).add(to);
        }

        int startNode = Integer.parseInt(scanner.nextLine());

        dfs(graph, startNode);

        notVisitedNodes
                .stream()
                .sorted()
                .forEach(node -> System.out.print(node + " "));
    }

    private static void dfs(Map<Integer, Set<Integer>> graph, int currentNode) {
        if (!notVisitedNodes.contains(currentNode)) {
            return;
        }

        notVisitedNodes.remove(currentNode);

        Set<Integer> connectedNodes = graph.get(currentNode);
        for (Integer connectedNode : connectedNodes) {
            dfs(graph, connectedNode);
        }
    }
}
