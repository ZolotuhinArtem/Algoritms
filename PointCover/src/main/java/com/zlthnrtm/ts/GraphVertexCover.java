package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphVertexCover {
    
    /**
    * Integer[][] graph must be square.
    * Please, make full matrix! <br>
    * Right: <br>
    *     0 1 1 0 <br>
    *     1 0 0 1 <br>
    *     1 0 0 0 <br>
    *     0 1 0 0 <br>
    * Wrong: <br>
    *     0 1 1 0 <br>
    *     0 0 0 1 <br>
    *     0 0 0 0 <br>
    *     0 0 0 0 <br>
    */
    
    public List<Integer> calculateStrict(Integer[][] graph){
        
        if (graph.length <= 0) {
            throw new IllegalArgumentException("invalid matrix");
        }
        
        if (graph.length != graph[0].length) {
            throw new IllegalArgumentException("matrix must be square");
        }
        
        GraphVertexSetsGenerator graphVertexSetsGenerator = new GraphVertexSetsGenerator();
        
        for(List<Integer> vertexs: graphVertexSetsGenerator.generate(getCount(graph))){
            Integer[][] copy = getCopy(graph);
            
            for (Integer vertex: vertexs) {
                for (int i = 0; i < copy.length; i++) {
                    copy[i][vertex] = null;
                    copy[vertex][i] = null;
                }
            }
            
            if (getCount(copy) == 0) {
                return vertexs;
            }
        }
        
        return new ArrayList<Integer>();
    }
    
    public List<Integer> calculateLazy(EdgeListGraph graph) {
        
        List<Integer> vertexs = new ArrayList<>();
        Edge edge;
        Vertex vertex;
        
        while (graph.edgeCount() > 0) {
            edge = graph.getSomeEdge();
            vertex = edge.getVertex1();
            vertexs.add(vertex.getIndex());
            graph.removeVertex(vertex);
        }
        
        return vertexs;
        
    }
    
    private Integer[][] getCopy(Integer[][] src){
        Integer[][] newGraph = new Integer[src.length][src[0].length];
        for(int i = 0; i < src.length; i++) {
            for(int j = 0; j < src[0].length; j++) {
                newGraph[i][j] = src[i][j];
            }
        }
        return newGraph;
    }
    
    private Integer getCount(Integer[][] graph) {
        
        int count = 0;
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j <= i; j++ ) {
                if (graph[i][j] != null) {
                    if (graph[i][j] != 0) {
                        count++;
                    }
                } 
            }
        }
        
        return count;
    }
}
