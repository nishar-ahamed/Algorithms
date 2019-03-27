package com.algorithms.breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.algorithms.search.depthfirstsearch.Vertex;

public class BreadthFirstSearch {
	
	public void breadthFirstSearch(List<Vertex> vertices) {
		for (Vertex v : vertices) { //adding this logic if multiple cluster exists
            if (!v.isVisited()) {
                bfs(v);
            }
        }
	}

	public void bfs(Vertex root) {
		Queue<Vertex> queue = new LinkedList<>();
		root.setVisited(true);
		queue.add(root);

		while (!queue.isEmpty()) {
			Vertex actualVertex = queue.remove();
			System.out.println(actualVertex + " ");

			for (Vertex vertex : actualVertex.getAdjVertex()) {
				if (!vertex.isVisited()) {
					vertex.setVisited(true);
					queue.add(vertex);
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

        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.breadthFirstSearch(list);
    }
}
