package MRA.DSA;
import java.util.ArrayList;
import java.util.HashSet;

public class Graph {
    int vertices;
    Boolean [][] adjacencyMatrix;
    ArrayList<Integer> [] adjacencyList;
    HashSet<Integer> [] adjacencySet;
    ArrayList<Edge> edgeList;


    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyMatrix = new Boolean[vertices][vertices];
        adjacencyList = new ArrayList[vertices];
        adjacencySet = new HashSet[vertices];
        edgeList = new ArrayList<>();


        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix[i][j] = false;
            }
        }

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
            adjacencySet[i] = new HashSet<>();
        }

    }

    //Adding O(1)
    public void addToAdjacencyMatrix(int a, int b){
        adjacencyMatrix[a][b] = true;
        adjacencyMatrix[b][a] = true;
    }

    //Checking O(1)
    public boolean checkAdjacencyInMatrix(int a, int b){
        return adjacencyMatrix[a][b];
    }

    //Iterating O(v)

    public void iterateOfVInMatrix(int v){
        for (int i = 0; i < vertices; i++) {
            if(adjacencyMatrix[v][i]){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    //Adding O(1)
    public void addToAdjacencyList(int a, int b){
        adjacencyList[a].add(b);
        adjacencyList[b].add(a);
    }

    //Checking O(degree(v))
    public boolean checkAdjacencyInList(int a, int b){
        return adjacencyList[a].contains(b);
    }

    //Iterating O(degree(v))
    public void iterateOfVInList(int v){
        for (Integer x: adjacencyList[v]) {
            System.out.print(x+" ");
        }
        System.out.println();
    }


    //Adding O(log v)
    public void addToAdjacencySet(int a, int b){
        adjacencySet[a].add(b);
        adjacencySet[b].add(a);
    }

    //Checking O(log v)
    public boolean checkAdjacencyInSet(int a, int b){
        return adjacencySet[a].contains(b);
    }

    //Iterating O(degree(v)+log(v))
    public void iterateOfVInSet(int v){
        for (Integer x: adjacencySet[v]) {
            System.out.print(x+" ");
        }
        System.out.println();
    }



    //Adding O(1)
    public void addToEdgeList(int a, int b){
        Edge edge = new Edge(a, b);
        edgeList.add(edge);
    }

    //Checking O(E)
    public boolean checkAdjacencyInEdgeList(int a, int b){
        for (Edge e: edgeList) {
             if(e.check(a,b)){
                 return true;
            }
        }
        return false;
    }

    //Iterating O(E)
    public void iterateOfVInEdgeList(int v){
        for (Edge e:edgeList) {
            if (e.getA()==v){
                System.out.print(e.getB()+" ");
            } else if (e.getB()==v) {
                System.out.print(e.getA()+" ");
            }
        }
        System.out.println();
    }


    public void displayAdjacencyMatrix(){
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print((adjacencyMatrix[i][j]?1:0)+"  ");
            }
            System.out.println();
        }
    }

    public void displayAdjacencyList(){
        int c = 0;
        for (ArrayList<Integer> list: adjacencyList) {
            System.out.print(c++ + ": ");
            for (int v: list) {
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }

    public void displayAdjacencySet(){
        int c = 0;
        for (HashSet<Integer> set: adjacencySet) {
            System.out.print(c++ + ": ");
            for (int v: set) {
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }

    public void displayEdges(){
        for (Edge edge: edgeList) {
            System.out.println(edge.getA()+" "+edge.getB());
        }
    }


}


class Edge {
    private int a;
    private int b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public boolean check(int v1, int v2){
        return (v1 == this.a && v2 == this.b) || (v1 == this.b && v2 == this.a);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
