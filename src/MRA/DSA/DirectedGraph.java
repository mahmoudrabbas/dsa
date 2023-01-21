package MRA.DSA;

import java.util.ArrayList;

public class DirectedGraph {
    int V;
    int [][] adjMatrix;

    ArrayList<DirectedEdge> [] adjList;

    public DirectedGraph(int v){
        this.V = v;
        adjMatrix = new int[v][v];
        adjList = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adjList[i] = new ArrayList<DirectedEdge>();
        }
    }

    // O(1)
    public void entryEdgeToMatrix(int from, int to, int weight){
        adjMatrix[from][to] = weight;
    }

    // O(1)
    public void entryEdgeToList(int from, int to, int weight){
        DirectedEdge edge = new DirectedEdge(from, to, weight);
        adjList[from].add(edge);
    }



    // O(1)
    public boolean adjMatrixCheck(int from, int to){
        return adjMatrix[from][to]!=0;
    }

    // O(degree(V))
    public boolean adjListCheck(int from, int to){
        for (DirectedEdge edge: adjList[from]) {
            if(edge.getTo()==to){
                return true;
            }
        }
        return false;
    }

    // O(1)
    public void adjMatrixDelEdge(int from, int to){
        adjMatrix[from][to] = 0;
    }

    // O(degree(V))
    public void adjListDelEdge(int from, int to){
        if(!adjListCheck(from, to)){
            return;
        }
        for (DirectedEdge edge: adjList[from]) {
            if(edge.getTo()==to){
                adjList[from].remove(edge);
                return;
            }
        }


    }

    // O(V)
    public void adjMatrixOf(int v){
        for (int i = 0; i < V; i++) {
            if (adjMatrix[v][i]!=0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    // O(degree(V))
    public void adjListOf(int v){
        for (DirectedEdge adj : adjList[v]) {
            System.out.print(adj.getTo()+" ");
        }
        System.out.println();
    }

    // O(1)
    public int getWeightAdjMatrix(int from, int to){
        return adjMatrix[from][to];
    }

    // O(degree(V))
    public int getWeightAdjList(int from, int to){
        int weight = 0;
        if(!adjListCheck(from, to)){
            return 0;
        }else {
            for (DirectedEdge edge: adjList[from]) {
                if(edge.getTo()==to){
                    weight=edge.getWeight();
                }
            }
        }
        return weight;
    }

    // O(V^2)
    public void adjMatrixRepresent(){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print((adjMatrix[j][i])+" ");
            }
            System.out.println();
        }
    }
    // O(V^2)
    public void adjListRepresent(){
        for (ArrayList<DirectedEdge> list: adjList) {
            for (DirectedEdge edge: list) {
                System.out.print(edge.getTo()+" ");
            }
            System.out.println();
        }
    }

}


class DirectedEdge {
    private int from;
    private int to;
    private int weight;

    public DirectedEdge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }
}
