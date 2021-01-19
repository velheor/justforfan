package com.university.algorithms.bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static List<Integer>[] graph = readGraph();
    static boolean[] used = new boolean[graph.length];

    public static void main(String[] argv) {
        dfs(3);
    }

    public static void dfs(int pos) {
        used[pos] = true;
        System.out.println(pos);
        for (int next : graph[pos]) {
            if (!used[next]) {
                dfs(next);
            }
        }
    }

    public static List<Integer>[] readGraph() {
        List<Integer>[] graphNew = new List[5];
        graphNew[0] = new ArrayList<>();
        graphNew[0].add(1);
        graphNew[0].add(2);
        graphNew[1] = new ArrayList<>();
        graphNew[1].add(0);
        graphNew[1].add(4);
        graphNew[1].add(3);
        graphNew[2] = new ArrayList<>();
        graphNew[2].add(0);
        graphNew[3] = new ArrayList<>();
        graphNew[3].add(1);
        graphNew[4] = new ArrayList<>();
        graphNew[4].add(1);
        return graphNew;
    }
}
