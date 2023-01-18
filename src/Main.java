import MRA.DSA.Graph;


public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph(5);

        graph.addToEdgeList(0,1);
        graph.addToEdgeList(0,2);
        graph.addToEdgeList(0,3);
        graph.addToEdgeList(1,2);
        graph.addToEdgeList(1,3);
        graph.addToEdgeList(3,4);

        graph.displayEdges();
        System.out.println(graph.checkAdjacencyInEdgeList(4,1));
        graph.iterateOfVInEdgeList(1);


    }

}

