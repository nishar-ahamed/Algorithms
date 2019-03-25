package com.algorithms.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    
    public void computePaths(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(sourceVertex);
        while (!priorityQueue.isEmpty()) {
            Vertex actualVertex = priorityQueue.poll();
            for (Edge edge : actualVertex.getAdjNeighbours()) {
                Vertex v = edge.getEndVertex();
                double newDistance = actualVertex.getDistance() + edge.getWeight();
                if (newDistance < v.getDistance()) {
                    priorityQueue.remove(v);
                    v.setDistance(newDistance);
                    v.setPredecessor(actualVertex);
                    priorityQueue.add(v);
                }
            }
        }
    }

    public List<Vertex> getShortestPath(Vertex targetVertex) {
        List<Vertex> shortestPathToTarget = new ArrayList<>();
        for (Vertex vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            shortestPathToTarget.add(vertex);
        }
        Collections.reverse(shortestPathToTarget);
        return shortestPathToTarget;
    }

    public static void main(String[] args) {
        Vertex v0 = new Vertex("A");
        Vertex v1 = new Vertex("B");
        Vertex v2 = new Vertex("C");

        v0.addAdjNeighbours(new Edge(1,v0,v1));
        v0.addAdjNeighbours(new Edge(1,v0,v2));
        v1.addAdjNeighbours(new Edge(1,v1,v2));

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        dijkstraAlgorithm.computePaths(v0);
        System.out.println(dijkstraAlgorithm.getShortestPath(v2));
    }
}
