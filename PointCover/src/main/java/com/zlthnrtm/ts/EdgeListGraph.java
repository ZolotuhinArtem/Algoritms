package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeListGraph{
    
    private List<Edge> edges;
    
    public EdgeListGraph(List<Edge> edges) {
        this.setEdges(edges);
    }
    
    public void removeEdge(Edge edge) {
        this.edges.remove(edge);
    }
    
    public void removeVertex(Vertex vertex) {
        List<Edge> tempList = new ArrayList<Edge>();
        for (Edge i: this.edges) {
            if (i != null) {
                tempList.add(i);
            }
        }
        for (Edge i: tempList) {
            if (i.hasVertex(vertex)) {
                this.removeEdge(i);
            }
        }
    }
    
    public int edgeCount() {
        return this.edges.size();
    }
    
    public Edge getSomeEdge(){
        ArrayList<Edge> tempList = new ArrayList<>();
        for (Edge i: this.edges) {
            tempList.add(i);
        }
        if (tempList.size() <= 0) {
            return null;
        } else {
            int k = (int) Math.round(Math.random() * (tempList.size() - 1));
            return tempList.get(k);
        }
    }
    
    public EdgeListGraph getCopy(){
        List<Edge> tempList = new ArrayList<>(this.edges.size());
        for(Edge edge: this.edges) {
            tempList.add(edge.getCopy());
        }
        return new EdgeListGraph(tempList);
    }
    
    public void updateVertexsValency(){
        for (Edge edge: this.edges) {
            edge.getVertex1().setValency(0);
            edge.getVertex2().setValency(0);
        }
        for (Edge edge: this.edges) {
            /** if vertex not alone. 
            *   P.S: if vertex1 == vertex2 than edge is alone vertex
            */
            if (!edge.getVertex1().equals(edge.getVertex2())) {
                edge.getVertex1().setValency(edge.getVertex1().getValency() + 1);
                edge.getVertex2().setValency(edge.getVertex2().getValency() + 1);
            }
        }
    }

    public Set<Vertex> getVertexs() {
        Set<Vertex> vertexs = new HashSet<>();
        for(Edge edge: this.edges) {
            vertexs.add(edge.getVertex1());
            vertexs.add(edge.getVertex2());
        }
        return vertexs;
    }
    
    private void setEdges(List<Edge> edges) {
        this.edges = edges;
        updateVertexsValency();
    }
}
 