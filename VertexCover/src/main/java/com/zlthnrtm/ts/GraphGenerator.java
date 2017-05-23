/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import com.zlthnrtm.ts.SimpleGraphBuilder.SimpleGraphBuilderVertexAsInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author м
 */
public class GraphGenerator {
    
    public static EdgeListGraph generate(int vertices, double denisty) {
        
        EdgeListGraph edgeListGraph = null;
        
        List<Edge> edges = new ArrayList<>();
        int edgesAmount = 0;
        
        edgesAmount = (int) Math.round(vertices * (vertices - 1) / 2 * denisty);
        
        SimpleGraphBuilderVertexAsInteger sGBVAI = SimpleGraphBuilder.vertexAsInteger();
        
        for (int i = 0; i < edgesAmount; i++) {
            
            int vertex1 = 0 + (int) (Math.random() * vertices);
            int vertex2 = 0 + (int) (Math.random() * vertices);
            Edge edge = new Edge(new Vertex(vertex1), new Vertex(vertex2));
            
            while (edges.contains(edge) || (vertex1 != vertex2)) {
                
                vertex1 = (int) (Math.random() * vertices);
                vertex2 = (int) (Math.random() * vertices);
                edge = new Edge(new Vertex(vertex1), new Vertex(vertex2));
            }
            
            edges.add(edge);
            sGBVAI.addEdge(vertex1, vertex2);
        }
        
        edgeListGraph = sGBVAI.build();
        
        return edgeListGraph;
    }
}