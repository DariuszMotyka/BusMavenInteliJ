package Bus;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dfs {

    private int[] edgeTo;
    private boolean[] marked;
    private final int source;

    public Dfs(CityMap graph, int source) {
        this.source = source;
        this.edgeTo = new int[graph.getNumberOfBusStop()];
        this.marked = new boolean[graph.getNumberOfBusStop()];
        this.dfs(graph, this.source);
    }

    public boolean hasPathTo(int vertex) {
        return this.marked[vertex];
    }

    public Iterable<Integer> getPathTo(int vertex) {
        Deque<Integer> path = new ArrayDeque();
        if (!this.hasPathTo(vertex)) {
            return path;
        } else {
            for(int w = vertex; w != this.source; w = this.edgeTo[w]) {
                path.push(w);
            }

            path.push(this.source);
            return path;
        }
    }

    private void dfs(CityMap graph, int vertex) {
        this.marked[vertex] = true;

        for(int i = 0; i < graph.getConnectionList(vertex).size(); ++i) {
            if (!this.marked[i]) {
                this.edgeTo[i] = vertex;
                this.dfs(graph, i);
            }
        }

    }
}
