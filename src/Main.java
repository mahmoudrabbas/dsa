import MRA.DSA.DirectedGraph;

public class Main {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);


        graph.entryEdgeToList(0,2,6);
        graph.entryEdgeToList(2,1,7);
        graph.entryEdgeToList(1,3,4);
        graph.entryEdgeToList(2,4,2);
        graph.entryEdgeToList(4,3,3);
        graph.entryEdgeToList(3,0,5);

        graph.adjListRepresent();

        graph.adjListDelEdge(2,4);
        graph.adjListRepresent();

    }
}



