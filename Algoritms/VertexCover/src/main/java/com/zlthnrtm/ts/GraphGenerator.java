package com.zlthnrtm.ts;

import com.zlthnrtm.ts.SimpleGraphBuilder.SimpleGraphBuilderVertexAsInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GraphGenerator {
   

    public static EdgeListGraph fullGraphGeneration(int vertexCount) {
        SimpleGraphBuilderVertexAsInteger simpleGraphBuilderVertexAsInteger = SimpleGraphBuilder.vertexAsInteger();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                simpleGraphBuilderVertexAsInteger.addEdge(i, j);
            }
        }
        return simpleGraphBuilderVertexAsInteger.build();
    }

    public static EdgeListGraph treeGeneration(int vertexCount) {
        Random random = new Random();
        
        SimpleGraphBuilderVertexAsInteger simpleGraphBuilderVertexAsInteger = SimpleGraphBuilder.vertexAsInteger();
        
        simpleGraphBuilderVertexAsInteger.addEdge(0, 1);
        
        for (int i = 2; i < vertexCount; i++) {
            simpleGraphBuilderVertexAsInteger.addEdge(random.nextInt(i), i);
        }
        
        return simpleGraphBuilderVertexAsInteger.build();
    }

    public static EdgeListGraph halfFilledGrafGeneration(int vertexCount) {
        
        EdgeListGraph edgeListGraph = null;
        
        int edgeCount = (int) ((vertexCount + 2) * (vertexCount - 1)) / 4;
        
        List<Edge> edges = new ArrayList<>(edgeCount);
        
        SimpleGraphBuilderVertexAsInteger simpleGraphBuilderVertexAsInteger = SimpleGraphBuilder.vertexAsInteger();
        
        for (int i = 0; i < edgeCount; i++) {
            
            int vertex1 = 0 + (int) (Math.random() * vertexCount);
            int vertex2 = 0 + (int) (Math.random() * vertexCount);
            Edge edge = new Edge(new Vertex(vertex1), new Vertex(vertex2));
            
            while (edges.contains(edge) || (vertex1 == vertex2)) {
                
                vertex1 = (int) (Math.random() * vertexCount);
                vertex2 = (int) (Math.random() * vertexCount);
                edge = new Edge(new Vertex(vertex1), new Vertex(vertex2));
            }
            
            edges.add(edge);
            simpleGraphBuilderVertexAsInteger.addEdge(vertex1, vertex2);
        }
        
        edgeListGraph = simpleGraphBuilderVertexAsInteger.build();
        
        return edgeListGraph;
    }

    
}