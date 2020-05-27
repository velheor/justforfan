package com.university.algorithms.lab5;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    private final boolean[] marked;    // marked[v] = is there an s-v path?
    private final List<Integer> way = new ArrayList<>();

    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
