import java.util.ArrayList;

public class HopcroftAndKarp {
    private BipartiteGraph bipartiteGraph;
    private int[] verticleV;
    private int[] verticleU;
    private Graph directGraph;

    public HopcroftAndKarp(BipartiteGraph bipGraph){
        bipartiteGraph =bipGraph;
        if(bipartiteGraph.getIsPartite()){
            int[] bipartition =bipartiteGraph.getbipartition();
            int sizeV =0;
            int sizeU=0;
            for(int i:bipartition){
                if(i ==1){
                    sizeV=sizeV+1;
                }
            }
            verticleV =new int[sizeV];
            verticleU =new int[bipartiteGraph.getNodes().size()-sizeV];
            for (int i:bipartition) {
                sizeV=0;
                sizeU=0;
                if(i ==1){
                    verticleV[sizeV]=i;
                    sizeV++;
                }else {
                    verticleU[sizeU]=i;
                    sizeU++;
                }
            }
        }
        directGraph =new Graph(true);
    }

    public void generateDirctGraph(int[] freeV,int[] freeU,double[][] adjMatrix){
        int size=bipartiteGraph.getNodes().size();
        for (int i=0; i<size;i++) {
            directGraph.addNode();
        }
        directGraph.addNode();
        directGraph.addNode();
        for (int i: freeV) {
            directGraph.addEdge(size,i,1);
        }
        for (int i:freeU) {
            directGraph.addEdge(i,size+1,1);
        }
        for (int row =0; row<adjMatrix.length;row++
             ) {
            for (int col=0; col<adjMatrix[0].length;col ++) {
                if (adjMatrix[row][col]>0) {
                    if (freeV.equals(row)) {
                        directGraph.addEdge(row,col,1);
                    }else{
                        directGraph.addEdge(col,row,1);
                    }
                }
            }
        }
    }

    public ArrayList<Path>findAugmentPath(){
        ArrayList<Path> paths=new ArrayList<Path>();
        

        return paths;
    }
}
