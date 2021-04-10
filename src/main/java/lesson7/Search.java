package lesson7;

import java.util.LinkedList;

public class Search {
    protected boolean[] marked;
    protected int[] edgeTo;
    protected int source;

    public Search(Graph g, int source) {
        this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
    }
    public boolean hasPathTo(int w) {
        return marked[w];
    }
    public LinkedList<Integer> pathTo(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
