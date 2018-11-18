import java.util.ArrayList;
import java.util.List;

public class EdgeList {
    private List<Edge> edges = new ArrayList<>();

    public void addEdge(int from, int to){
        edges.add(new Edge(from,to));
    }
    public boolean hasEdge(int from, int to){
        return false;
    }
    public boolean removeEdge(){
        return true;
    }
    private class Edge {
        private int to;
        private int from;
        Edge(int from,int to){
            this.to = to;
            this.from = from;
        }
    }
}