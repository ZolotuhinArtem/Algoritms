package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Edge> edges = new ArrayList<>(7);
        edges.add(new Edge(new Vertex(0), new Vertex(1)));
        edges.add(new Edge(new Vertex(1), new Vertex(2)));
        edges.add(new Edge(new Vertex(2), new Vertex(3)));
        edges.add(new Edge(new Vertex(3), new Vertex(5)));
        edges.add(new Edge(new Vertex(3), new Vertex(4)));
        edges.add(new Edge(new Vertex(4), new Vertex(0)));
        edges.add(new Edge(new Vertex(6), new Vertex(6)));
        EdgeListGraph edgeListGraph = new EdgeListGraph(edges);
        
        GraphVertexCover graphVertexCover = new GraphVertexCover();
        
        System.out.println("Strict: " + graphVertexCover.calculateStrict(edgeListGraph).toString());
        
        
        
        System.out.println("Lazy: " + graphVertexCover.calculateLazy(edgeListGraph).toString());
    }
}
