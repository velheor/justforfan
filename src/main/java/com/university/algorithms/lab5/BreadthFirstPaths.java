package com.university.algorithms.lab5;

import java.util.List;

public class BreadthFirstPaths {
    static void BFS(List<Integer[]> graph, int v) {
        System.out.print(v + " ");
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i)[0] == i + 1) {
                System.out.print(graph.get(i)[i]  + 1);
            }
        }
    }
}
