/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author manjaro
 */
public class EdgeListGraph {
    
    private List<Edge> edges;

    public EdgeListGraph() {
        this.edges = new ArrayList<>();
    }

    public EdgeListGraph(List<Edge> edges) {
        this.edges = edges;
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
    
}
