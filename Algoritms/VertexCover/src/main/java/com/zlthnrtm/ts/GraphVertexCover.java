package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphVertexCover {
    
    public Set<Vertex> calculateStrict(EdgeListGraph edgeListGraph){
        
        GraphVertexSetsGenerator graphVertexSetsGenerator = new GraphVertexSetsGenerator();
        
        EdgeListGraph tempEdgeListGraph;
        
        for(Set<Vertex> vertexs: graphVertexSetsGenerator.generate(edgeListGraph.getVertexs())){
            tempEdgeListGraph = edgeListGraph.getCopy();
            
            for (Vertex vertex: vertexs) {
                tempEdgeListGraph.removeVertex(vertex);
            }
            
            if (tempEdgeListGraph.edgeCount() == 0) {
                return vertexs;
            }
        }
        
        return new HashSet<Vertex>();
    }
    
    public List<Vertex> calculateLazy(EdgeListGraph edgeListGraph) {
        
        EdgeListGraph graph = edgeListGraph.getCopy();
        
        List<Vertex> vertexs = new ArrayList<>();
        Edge edge;
        Vertex vertex1, vertex2;
        
        while (graph.edgeCount() > 0) {
            edge = graph.getSomeEdge();
            vertex1 = edge.getVertex1();
            vertex2 = edge.getVertex2();
            vertexs.add(vertex1);
            graph.removeVertex(vertex1);
            if (!vertex1.equals(vertex2)) {
                vertexs.add(vertex2);
                graph.removeVertex(vertex2);
            }
        }
        
        return vertexs;
    }
    
    public Set<Vertex> calculateGreedy(EdgeListGraph edgeListGraph) {
        
        EdgeListGraph graph = edgeListGraph.getCopy();
        
        Set<Vertex> vertexs = new HashSet<>();
        Vertex maxValencyVertex;
        while (graph.edgeCount() > 0) {
            
            maxValencyVertex = Collections.max(graph.getVertexs(), (o1, o2) -> {
                if (o1.getValency() > o2.getValency()) {
                    return 1;
                }
                if (o1.getValency() < o2.getValency()) {
                    return -1;
                }
                return 0; 
            });
            
            vertexs.add(maxValencyVertex);
            
            graph.removeVertex(maxValencyVertex);
            graph.updateVertexsValency();
            
        }
        return vertexs;
    }
}
