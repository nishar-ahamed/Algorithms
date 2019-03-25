package com.algorithms.search.depthfirstsearch;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class DepthFirstSearch {
    private Stack<Vertex> stack = new Stack<Vertex>();

    public void depthFirstSearch(List<Vertex> vertices) {
        for (Vertex v : vertices) { //adding this logic if multiple cluster exists
            if (!v.isVisited()) {
                dfs(v);
            }
        }
    }

    private void dfs(Vertex root) {
        stack.push(root);
        root.setVisited(true);

        while (!stack.empty()) {
            Vertex actual = stack.pop();
            System.out.println(actual);
            for (Vertex v : actual.getAdjVertex()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.push(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex("1");
        Vertex v2 = new Vertex("2");
        Vertex v3 = new Vertex("3");
        Vertex v4 = new Vertex("4");
        Vertex v5 = new Vertex("5");

        v1.addAdjVertex(v2);
        v1.addAdjVertex(v3);
        v3.addAdjVertex(v4);
        v4.addAdjVertex(v5);

        List<Vertex> list = new ArrayList<>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.depthFirstSearch(list);
    }
}

