package com.algorithms.shortestpath.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String data;
    private boolean visited;
    private List<Edge> adjNeighbours;
    private Vertex predecessor;
    private double distance;

    public Vertex(String data) {
        this.data = data;
        this.visited = false;
        this.adjNeighbours = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getAdjNeighbours() {
        return adjNeighbours;
    }

    public void addAdjNeighbours(Edge edge) {
        this.adjNeighbours.add(edge);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.distance, o.getDistance());
    }

    @Override
    public String toString() {
        return this.data;
    }
}
