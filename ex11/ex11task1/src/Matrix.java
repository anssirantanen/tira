
public class Matrix {
    private int size;
    private boolean[][] matrix;
    public Matrix(int size){
        this.size = size;
        matrix = new boolean[size][size];
    }
    public void addEdge(int from, int to){
        matrix[from][to] = true;
    }
    public void removeEdge(int from ,int to){
        matrix[from][to] = false;
    }
    public boolean hasEdge(int from, int to){
        return matrix[from][to];
    }
}