package com.university.algorithms.lab5;

import java.util.ArrayList;
import java.util.List;

public class Lab5 {
    public static void main(String[] args) {
        int V = 5;
        int[][] ms = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};

        Graph graph = new Graph(V);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (ms[i][j] == 1) {
                    graph.addEdge(i, j);
                }
            }
        }
        int n = 0;
        int[][] mi = new int[graph.E()][graph.V()];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < i; j++) {
                if (ms[j][i] == 1) {
                    mi[n][i] = 1;
                    mi[n][j] = 1;
                    n++;
                }
            }
        }

        for (int i = 0; i < graph.V(); i++) {
            for (int j = 0; j < graph.E(); j++) {
                System.out.print(mi[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        int firstV;
        int secondV;
        List<Integer[]> listOfEdges = new ArrayList<Integer[]>();
        for (int i = 0; i < graph.E(); i++) {
            firstV = 0;
            for (int j = 0; j < graph.V(); j++) {
                if (mi[i][j] == 1) {
                    if (firstV == 0) {
                        firstV = j + 1;
                    } else {
                        secondV = j + 1;
                        Integer[] edge = {firstV, secondV};
                        listOfEdges.add(edge);
                        System.out.println(firstV + " " + secondV);
                    }
                }
            }
        }

        for (int i = 0; i < listOfEdges.size(); i++) {
            System.out.print("Для точки " + (i + 1) + " ");
            for (int j = 0; j < 2; j++) {
                if (listOfEdges.get(i)[j] == i + 1) {
                    System.out.print(listOfEdges.get(i)[j] + 1);
                }
            }
            System.out.println();
        }

        DepthFirstSearch depthFirstPaths = new DepthFirstSearch(listOfEdges);
        depthFirstPaths.dfs(5);
        BreadthFirstPaths.BFS(listOfEdges, 1);
    }
}
