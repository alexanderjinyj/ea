import java.util.ArrayList;
import java.util.List;

/**
 * this class define a deep first search algorith for directed graph
 * dfsNum means the order in the DFS
 * status 0 : unvisited; 1 : visited but not finished; 2 : finished
 * time is for record the time of visit
 * com means connected component
 */
public class Dfs {
    private int[] dfsNum;
    private int[] status;
    private int time;
    private Graph graph;
    private List<Integer> com;

    /**
     * construct a dfs reference
     *
     * @param dGraph the graph is applied
     *               initial dfsNum and status with 0 time too
     */
    public Dfs(Graph dGraph) {
        graph = dGraph;
        dfsNum = new int[graph.getNodes().size()];
        status = new int[graph.getNodes().size()];
        for (int i = 0; i < dfsNum.length; i++) {
            dfsNum[i] = 0;
            status[i] = 0;
        }
        time = 0;
    }

    /**
     * do dfs begin with node
     *
     * @param node is the begin node
     *             initial the connected component which node related
     */
    public void run(Node node) {
        com = new ArrayList<Integer>();
        if (dfsNum[node.getID()] == 0) {
            dfsVisit(node);
        }
    }


    /**
     * visit all the nodes belonged to adjacency matrix of parem node
     * when the adjacency node is not visited.
     * and update the dfsnum status and com
     *
     * @param node
     */
    public void dfsVisit(Node node) {
        int id = node.getID();
        status[id] = 1;
        time = time + 1;
        dfsNum[id] = time;
        ArrayList<Edge> adj = node.getIncidenceList();
        for (Edge edge : adj) {
            Node adjNode = edge.getDest();
            int adjId = adjNode.getID();
            if (dfsNum[adjId] == 0) {
                dfsVisit(adjNode);
            }
        }
        status[id] = 2;
        com.add(id);
    }

    /**
     * @return int array of the dfsNum of all node
     */
    public int[] getDfsNums() {
        return dfsNum;
    }

    /**
     * @return graph
     */
    public Graph getGraph() {
        return graph;
    }

    /**
     * @return int array of the sttus of all node
     */
    public int[] getStatus() {
        return status;
    }

    /**
     * @return int list of connected component
     */
    public List getCom() {
        return com;
    }





}
