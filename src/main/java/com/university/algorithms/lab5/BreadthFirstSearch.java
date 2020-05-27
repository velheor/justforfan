package com.university.algorithms.lab5;

import java.util.ArrayDeque;

public class BreadthFirstSearch {
    private final boolean[] marked;
    public BreadthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }
    private void bfs(Graph G, int s) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.push(s);
        marked[s] = true;
        while (!q.isEmpty()) {
            int v = q.removeLast();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    q.push(w);
                    marked[w] = true;
                }
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
