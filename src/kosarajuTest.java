import java.util.ArrayList;
import java.util.List;

public class kosarajuTest {
    public static void main(String[] args) {
        Graph graph = new Graph(true);
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();


        graph.addEdge(0,1,1);
        graph.addEdge(0,2,1);
        graph.addEdge(0,6,1);
        graph.addEdge(1,4,1);
        graph.addEdge(1,6,1);
        graph.addEdge(4,0,1);
        graph.addEdge(5,2,1);
        graph.addEdge(5,3,1);
        graph.addEdge(6,4,1);
        Kosaraju newScc=new Kosaraju(graph);
        List<List<Integer>> scc =new ArrayList<>();
        scc =newScc.scc();
        System.out.println("noob");
    }
}
