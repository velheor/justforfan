package com.algo.algorithms.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadFirstSearch {

  static ArrayList<Node> nodes = new ArrayList<>();
  private final Queue<Node> queue;

  public BreadFirstSearch() {
    queue = new LinkedList<>();
  }

  public static void main(String[] arg) {

    Node node0 = new Node(0);
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    node0.addNeighbours(node1);
    node0.addNeighbours(node2);
    node1.addNeighbours(node0);
    node1.addNeighbours(node3);
    node1.addNeighbours(node4);
    node3.addNeighbours(node1);
    node4.addNeighbours(node1);
    node0.addNeighbours(node2);

    System.out.println("The BFS traversal of the graph is ");
    BreadFirstSearch bfsExample = new BreadFirstSearch();
    bfsExample.bfs(node3);
  }

  public void bfs(Node node) {
    queue.add(node);
    node.visited = true;
    while (!queue.isEmpty()) {

      Node element = queue.remove();
      System.out.print(element.data + "t");
      List<Node> neighbours = element.getNeighbours();
      for (int i = 0; i < neighbours.size(); i++) {
        Node n = neighbours.get(i);
        if (n != null && !n.visited) {
          queue.add(n);
          n.visited = true;
        }
      }
    }
  }

  static class Node {
    int data;
    boolean visited;
    List<Node> neighbours;

    Node(int data) {
      this.data = data;
      this.neighbours = new ArrayList<>();
    }

    public void addNeighbours(Node neighbourNode) {
      this.neighbours.add(neighbourNode);
    }

    public List<Node> getNeighbours() {
      return neighbours;
    }

    public void setNeighbours(List<Node> neighbours) {
      this.neighbours = neighbours;
    }
  }
}
