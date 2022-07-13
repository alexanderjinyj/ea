import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph extends Graph {
    private Graph graph;
    private boolean isBipartite;
    private int[] bipartition;

    public BipartiteGraph(Graph g) {
        graph = g;
        isBipartite = this.isBipartite();
        bipartition = new int[g.getNodes().size()];
        this.bipartition();
    }

    private boolean isBipartite(Graph g, int[] color, int src) {
        if (g != null) {
            color[src] = 1;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(src);
            while (q.size() != 0) {
                int ver = q.poll();
                //Return false if there is a self-loop
                if (graph.getCosts()[ver][ver] == 1) {
                    return false;
                }
                ArrayList<Edge> adj = graph.getNode(ver).getIncidenceList();
                for (Edge edge : adj) {
                    int dest = edge.getDest().getID();
                    if (color[dest] == color[ver]) {
                        return false;
                    } else if (color[dest] == -1) {
                        color[dest] = 1 - color[ver];
                        q.add(dest);
                    }
                }
            }
            return true;
        } else {
            throw new NullPointerException("the graph is null object");
        }

    }

    public boolean isBipartite() {
        if (graph != null) {
            int size = graph.getNodes().size();
            int[] color = new int[size];
            for (int i = 0; i < size; i++) {
                color[i] = -1;
            }
            for (int i = 0; i < size; i++) {
                if (color[i] == -1) {
                    if (isBipartite(graph, color, i) == false) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            throw new NullPointerException("the graph is null object");
        }
    }

    private void bipartition(Graph g, int[] color, int src) {
        if (g != null) {
            color[src] = 1;
            Queue<Integer> q = new LinkedList<Integer>();
            q.add(src);
            while (q.size() != 0) {
                int ver = q.poll();
                if (graph.getCosts()[ver][ver] == 1) {
                    throw new Error("there is a self-loop");
                }
                ArrayList<Edge> adj = graph.getNode(ver).getIncidenceList();
                for (Edge edge : adj) {
                    int dest = edge.getDest().getID();
                    if (color[dest] == -1) {
                        color[dest] = 1 - color[ver];
                        q.add(dest);
                    }
                }
            }
        } else {
            throw new NullPointerException("the graph is null object");
        }

    }

    public void bipartition() {
        if (graph != null) {
            if (isBipartite) {
                int size = graph.getNodes().size();
                for (int i = 0; i < size; i++) {
                    bipartition[i] = -1;
                }
                for (int i = 0; i < size; i++) {
                    if (bipartition[i] == -1) {
                        bipartition(graph, bipartition, i);
                    }
                }
            } else {
                throw new Error("this graph isn't bipartite");
            }
        } else {
            throw new NullPointerException("the graph is null object");
        }

    }

    public boolean getIsPartite() {
        return isBipartite;
    }

    public int[] getbipartition() {
        return bipartition;
    }


}
