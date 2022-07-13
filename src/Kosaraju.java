import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * implement kosaraju algorithm
 * scc means strong connected component, which is a list of integer list
 */
public class Kosaraju {
    // scc is strongly connected components
    private Graph graph;
    private List<List<Integer>> scc;

    /**
     * construct a  kosaraju algorithm
     * @param dGraph the graph
     */
    public Kosaraju(Graph dGraph){
        graph =dGraph;
        scc =new ArrayList();
    }

    /**
     * find the strong connected component
     * in the first for loop get the topological sort of the graph
     * then transpose the graph
     * then dfs the transposed graph in the order of topological sort
     * @return the strong connected component
     */
    public List<List<Integer>> scc(){
        Dfs dfs =new Dfs(graph);
        int size =graph.getNodes().size();
        List<Integer> topSort=new ArrayList<Integer>();
        for (int i = 0; i <size ; i++) {
            dfs.run(graph.getNode(i));
            List com=dfs.getCom();
            topSort.addAll(com);
        }
        Graph transGraph =graph.Transpose();
        Dfs transDfs =new Dfs(transGraph);
        for (int i = 0; i <size ; i++) {
            int visitNode =topSort.get(size-i-1);
            if (transDfs.getDfsNums()[visitNode] ==0){
                transDfs.run(transGraph.getNode(visitNode));
                scc.add(transDfs.getCom());
            }
        }
        return scc;
    }
}
