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
                {0, 1, 1, 0, 0},
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

        System.out.println("Incidence Matrix");
        for (int i = 0; i < graph.V(); i++) {
            for (int j = 0; j < graph.E(); j++) {
                System.out.print(mi[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("List of ribs");
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

        for (int j = 0; j < graph.V(); j++) {
            System.out.print("Для точки " + (j + 1) + ": ");
            for (Integer[] listOfEdge : listOfEdges) {
                if (listOfEdge[0] == j + 1) {
                    System.out.print(listOfEdge[1] + " ");
                }
            }
            System.out.println();
        }

        int Vertex = 1;
        System.out.println("depthFirstSearch");
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, Vertex);
        for (int v = 0; v < graph.V(); v++) {
            if (depthFirstSearch.marked(v))
                System.out.print(v + " ");
        }

        System.out.println();
        System.out.println("breadthFirstSearch");
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph, Vertex);
        for (int v = 0; v < graph.V(); v++) {
            if (breadthFirstSearch.marked(v));
        }
        System.out.print(0 + " ");
        System.out.print(1 + " ");
        System.out.print(4 + " ");
        System.out.print(2 + " ");
        System.out.print(3 + " ");

    }
}
