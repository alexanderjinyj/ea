import java.util.Arrays;

public class DfsTest {
    public static void main(String[] args) {
        Graph graph = new Graph(true);
        Node zero = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);

        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();
        graph.addNode();


        graph.addEdge(1,0,1);
        graph.addEdge(3,1,1);
        graph.addEdge(2,7,1);
        graph.addEdge(2,4,1);
        graph.addEdge(5,2,1);
        graph.addEdge(5,0,1);
        graph.addEdge(6,5,1);
        graph.addEdge(6,3,1);
        graph.addEdge(6,8,1);
        graph.addEdge(7,5,1);
        graph.addEdge(7,6,1);
        graph.addEdge(7,8,1);
        Dfs dfs =new Dfs(graph);
        dfs.run(graph.getNode(7));
        for(int i =0;i< graph.getNodes().size();i++){
            dfs.run(graph.getNode(i));
        }
        int[] dfsNum= dfs.getDfsNums();
        System.out.println(Arrays.toString(dfsNum));
        Graph transGraph =graph.Transpose();
        System.out.printf("X");

    }
}
