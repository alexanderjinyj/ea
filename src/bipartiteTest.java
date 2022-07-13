public class bipartiteTest {
    public static void main(String[] args) {
        Graph graph = new Graph(false);
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();


        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 5, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 1);

        /*
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 5, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 5, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 1);
        */

        BipartiteGraph bipartiteGraph = new BipartiteGraph(graph);
        if (bipartiteGraph.getIsPartite()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        int[] color = bipartiteGraph.getbipartition();
        System.out.println("check");

    }


}
