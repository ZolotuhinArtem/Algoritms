package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(GraphGenerator.generate(5, 0.5));
            System.out.println(GraphGenerator.generate(5, 1));
        }
        
        
    }
    
    public static void demonstration(){
        EdgeListGraph edgeListGraph = SimpleGraphBuilder.vertexAsInteger()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 0)
                .addEdge(6, 6)
                .build();
        
        
        GraphVertexCover graphVertexCover = new GraphVertexCover();
        
        System.out.println("Strict: " + graphVertexCover.calculateStrict(edgeListGraph).toString());
        
        System.out.println("Lazy: " + graphVertexCover.calculateLazy(edgeListGraph).toString());
        
        System.out.println("Greedy: " + graphVertexCover.calculateGreedy(edgeListGraph).toString());
    }
}
