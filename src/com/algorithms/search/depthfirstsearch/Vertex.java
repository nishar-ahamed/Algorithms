package com.algorithms.search.depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String data;
    private boolean isVisited;
    private List<Vertex> adjVertex;

    public Vertex(String data) {
        this.data = data;
        this.adjVertex = new ArrayList<>();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public List<Vertex> getAdjVertex() {
        return adjVertex;
    }

    public void addAdjVertex(Vertex vertex) {
        this.adjVertex.add(vertex);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data='" + data + '\'' +
                '}';
    }
}
