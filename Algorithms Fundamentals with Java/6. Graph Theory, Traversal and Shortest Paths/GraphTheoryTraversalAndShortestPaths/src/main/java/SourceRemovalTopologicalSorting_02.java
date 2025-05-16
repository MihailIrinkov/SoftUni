import java.util.*;
import java.util.stream.Collectors;

public class SourceRemovalTopologicalSorting_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String nextLine = scanner.nextLine();

            if (nextLine.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> nextNodes = Arrays.stream(nextLine.split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                graph.add(nextNodes);
            }

        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> connectedComponent : connectedComponents) {
            System.out.print("Connected Component: ");
            for (int integer : connectedComponent) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> components = new ArrayList<>();

        for (int start = 0; start < graph.size(); start++) {
            if (!visited[start]) {
                components.add(new ArrayDeque<>());
                dfs(start, components, graph, visited);

            }
        }

        return components;
    }

    private static void dfs(int node, List<Deque<Integer>> components, List<List<Integer>> graph, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;

            for (int child : graph.get(node)) {
                dfs(child, components, graph, visited);
            }

            components.get(components.size() - 1).offer(node);
        }
    }

    public static List<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependenciesCount = getDependenciesCount(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String key = graph.keySet()
                    .stream()
                    .filter(k -> dependenciesCount.get(k) == 0)
                    .findFirst()
                    .orElse(null);

            if (key == null) {
                break;
            }

            for (String child : graph.get(key)) {
                dependenciesCount.put(child, dependenciesCount.get(child) - 1);
            }

            sorted.add(key);
            graph.remove(key);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return sorted;
    }

    private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
        Map<String, Integer> dependeciesCount = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependeciesCount.putIfAbsent(node.getKey(), 0);
            for (String child : node.getValue()) {
                dependeciesCount.putIfAbsent(child, 0);
                dependeciesCount.put(child, dependeciesCount.get(child) + 1);
            }
        }

        return dependeciesCount;
    }
}
