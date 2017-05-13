package com.zlthnrtm.ts;

import java.util.ArrayList;
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
        Vertex vertex;
        
        while (graph.edgeCount() > 0) {
            edge = graph.getSomeEdge();
            vertex = edge.getVertex1();
            vertexs.add(vertex);
            graph.removeVertex(vertex);
        }
        
        return vertexs;
        
    }
}
