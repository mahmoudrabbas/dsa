import MRA.DSA.Graph;

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(9);
        g.addToAdjacencyList(0,1);
        g.addToAdjacencyList(0,2);
        g.addToAdjacencyList(0,3);
        g.addToAdjacencyList(0,4);
        g.addToAdjacencyList(1,5);
        g.addToAdjacencyList(5,6);
        g.addToAdjacencyList(3,7);
        g.addToAdjacencyList(7,8);

        g.bfs(0);
    }
}

