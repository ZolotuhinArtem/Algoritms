package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        Integer[][] graph = new Integer[7][7];
        graph[0][1] = 1;
        graph[1][0] = 1;
        
        graph[1][2] = 1;
        graph[2][1] = 1;
        
        graph[2][3] = 1;
        graph[3][2] = 1;
        
        graph[3][5] = 1;
        graph[5][3] = 1;
        
        graph[3][4] = 1;
        graph[4][3] = 1;
        
        graph[0][4] = 1;
        graph[4][0] = 1;
        
        graph[6][6] = 1;
        
        GraphVertexCover graphVertexCover = new GraphVertexCover();
        
        System.out.println("Strict: " + graphVertexCover.calculateStrict(graph).toString());
        
        List<Edge> edges = new ArrayList<>(7);
        edges.add(new Edge(new Vertex(0), new Vertex(1)));
        edges.add(new Edge(new Vertex(1), new Vertex(2)));
        edges.add(new Edge(new Vertex(2), new Vertex(3)));
        edges.add(new Edge(new Vertex(3), new Vertex(5)));
        edges.add(new Edge(new Vertex(3), new Vertex(4)));
        edges.add(new Edge(new Vertex(4), new Vertex(0)));
        edges.add(new Edge(new Vertex(6), new Vertex(6)));
        EdgeListGraph edgeListGraph = new EdgeListGraph(edges);
        
        System.out.println("Lazy: " + graphVertexCover.calculateLazy(edgeListGraph).toString());
    }
}
