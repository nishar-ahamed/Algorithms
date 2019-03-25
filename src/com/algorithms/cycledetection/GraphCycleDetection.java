package com.algorithms.cycledetection;

import java.util.ArrayList;
import java.util.List;

public class GraphCycleDetection {

    public void detectCycle(List<Vertex> vertexList) {
        for (Vertex v : vertexList) {//Logic for multiple clusters
            if (!v.isVisited())
                modifiedDfs(v);
        }
    }

    private void modifiedDfs(Vertex vertex) {
        System.out.println("DFS on vertex " + vertex);
        vertex.setBeingVisited(true);
        for (Vertex v : vertex.getAdjVertex()) {
            System.out.println("Visiting the adjacent vertices of vertex " + vertex);
            if (v.isBeingVisited()) {
                System.out.println("There is a backward edge: so there is a cycle!!!");
                return;
            }
            if (!v.isVisited()) {
                System.out.println("Visiting vertex " + v + " recursively...");
                v.setVisited(true);
                modifiedDfs(v);
            }
        }
        System.out.println("Set vertex " + vertex + " beingVisited (false) and visited (true)...");
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }

    public static void main(String[] args) {
        Vertex vertex1 = new Vertex("1");
        Vertex vertex2 = new Vertex("2");
        Vertex vertex3 = new Vertex("3");
        Vertex vertex4 = new Vertex("4");
        Vertex vertex5 = new Vertex("5");
        Vertex vertex6 = new Vertex("6");

        vertex1.addAdjVertex(vertex2);
        vertex1.addAdjVertex(vertex3);
        vertex2.addAdjVertex(vertex3);
        vertex4.addAdjVertex(vertex1);
        vertex4.addAdjVertex(vertex5);
        vertex5.addAdjVertex(vertex6);
        vertex6.addAdjVertex(vertex4);

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);

        GraphCycleDetection graphCycleDetection = new GraphCycleDetection();
        graphCycleDetection.detectCycle(vertexList);

    }
}
