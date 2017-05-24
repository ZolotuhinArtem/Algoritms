/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author manjaro
 */
public class SimpleGraphBuilder {
    
    public static SimpleGraphBuilderVertexAsInteger vertexAsInteger() {
        return new SimpleGraphBuilderVertexAsInteger();
    }
    
    public static class SimpleGraphBuilderVertexAsInteger{
        
        
        private Map<Integer, Vertex> verticles;
        
        private List<Edge> edgeList;

        public SimpleGraphBuilderVertexAsInteger() {
            this.verticles = new HashMap<>();
            this.edgeList = new ArrayList<>();
        }
        
        
        
        public SimpleGraphBuilderVertexAsInteger addEdge(Integer vertexIndexOne, Integer vertexIndexTwo){
            
            Vertex start, end;
            
            start = getVertexFromInteger(vertexIndexOne);
            end = getVertexFromInteger(vertexIndexTwo);
            
            this.edgeList.add(new Edge(start, end));
            
            return this;
        }
        
        private Vertex getVertexFromInteger(Integer vertexIndex) {
            Vertex vertex = this.verticles.get(vertexIndex);
            if (vertex == null){
                vertex = new Vertex(vertexIndex, -1);
                this.verticles.put(vertexIndex, vertex);
            }
            
            return vertex;
        }
        
        public EdgeListGraph build(){
            return new EdgeListGraph(this.edgeList);
        }
    }
}
