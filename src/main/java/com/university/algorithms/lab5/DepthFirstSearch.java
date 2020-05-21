package com.university.algorithms.lab5;

import java.util.List;

public class DepthFirstSearch {
    List<Integer[]> graph;
    boolean[] used;
    public DepthFirstSearch(List<Integer[]> graph){
        this.graph = graph;
        used = new boolean[graph.size()];

    }
    public void dfs(int pos) {
        used[pos] = true;
        System.out.println(pos);
        for (int next : graph.get(pos)){
            if (!used[next]){
                dfs(next);
            }
        }
    }
}
