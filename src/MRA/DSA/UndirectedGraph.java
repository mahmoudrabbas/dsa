package MRA.DSA;

import java.util.ArrayList;

public class UndirectedGraph {
    int V;
    int E;
    private boolean [][] adjMatrix;
    private ArrayList<Integer> [] adjList;

    public UndirectedGraph(int vertices) {
        this.V = vertices;
        adjMatrix = new boolean[V][V];
        adjList = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // O(1)
    public void entryEdgeToMatrix(int x, int y){
        adjMatrix[x][y] = true;
        adjMatrix[y][x] = true;
    }

    // O(1)
    public void entryEdgeToList(int x, int y){
        adjList[x].add(y);
        adjList[y].add(x);
    }

    // O(1)
    public boolean adjMatrixCheck(int x, int y){
        return adjMatrix[x][y];
    }

    // O(degree(V))
    public boolean adjListCheck(int x, int y){
        return adjList[x].contains(y);
    }

    // O(1)
    public void adjMatrixDelEdge(int x, int y){
        adjMatrix[x][y] = false;
        adjMatrix[y][x] = false;
    }

    // O(degree(V))
    public void adjListDelEdge(int x, int y){
        adjList[x].remove(y);
        adjList[y].remove(x);
    }

    // O(V)
    public void adjMatrixOf(int v){
        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // O(degree(V))
    public void adjListOf(int v){
        for (Integer adj : adjList[v]) {
            System.out.print(adj+" ");
        }
        System.out.println();
    }


    // O(V^2)
    public void adjMatrixRepresent(){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((adjMatrix[i][j]?1:0)+" ");
            }
            System.out.println();
        }
    }

    // O(E*degree(V))
    public void adjListRepresent(){
        for (ArrayList<Integer>list:adjList) {
            for (int v: list) {
                System.out.print(v+" ");
            }

            System.out.println();
        }
    }


}
