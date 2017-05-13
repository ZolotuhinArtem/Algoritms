package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Edge> edges = new ArrayList<>(7);
        
        //Creating of vertexs
        Vertex[] vertexs = new Vertex[7];
        for (int i = 0; i < vertexs.length; i++) {
            vertexs[i] = new Vertex(i, 0);
        }
        
        //Creating edges
        edges.add(new Edge(vertexs[0], vertexs[1]));
        edges.add(new Edge(vertexs[1], vertexs[2]));
        edges.add(new Edge(vertexs[2], vertexs[3]));
        edges.add(new Edge(vertexs[3], vertexs[5]));
        edges.add(new Edge(vertexs[3], vertexs[4]));
        edges.add(new Edge(vertexs[4], vertexs[0]));
        edges.add(new Edge(vertexs[6], vertexs[6]));

        
        EdgeListGraph edgeListGraph = new EdgeListGraph(edges);
        
        GraphVertexCover graphVertexCover = new GraphVertexCover();
        
        System.out.println("Strict: " + graphVertexCover.calculateStrict(edgeListGraph).toString());
        
        System.out.println("Lazy: " + graphVertexCover.calculateLazy(edgeListGraph).toString());
        
        System.out.println("Greedy: " + graphVertexCover.calculateGreedy(edgeListGraph).toString());
    }
}
