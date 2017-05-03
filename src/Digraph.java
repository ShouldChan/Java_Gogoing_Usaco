/**
 * Created by Administrator on 2017/5/3.
 * Goal: to describe the structure of problem GIFT
 * For: use adjacency matrix to describe Digraph
 */


public class Digraph{
    private VertexNode[] verticesList = null;
    private int[][] Edge = null;
    private int maxVertices = 0;
    private int numVertices = 0;
    private int numEdges = 0;
    private int maxWeight = Integer.MAX_VALUE;

    public Digraph(int size) {
        this.maxVertices = size;
        this.numVertices = 0;
        Edge = new int[maxVertices][maxVertices];
        verticesList = new VertexNode[maxVertices];

        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                Edge[i][j] = (i == j) ? 0 : maxWeight;
            }
        }
    }

    public int getWeight(int v1, int v2) {
        //get the value from Edge<v1,v2>
        return v1 != -1 && v2 != -1 ? Edge[v1][v2] : 0;
    }

}
