/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

/**
 *
 * @author manjaro
 */
public class StatisticNode implements Comparable<StatisticNode>{

    private Integer vertexCount;
    
    private Integer edgeCount;
    
    private Double nanotime;
    
    private String label;

    public StatisticNode() {
    }

    public StatisticNode(Integer vertexCount, Integer edgeCount, Double nanotime, String label) {
        this.vertexCount = vertexCount;
        this.edgeCount = edgeCount;
        this.nanotime = nanotime;
        this.label = label;
    }

    public Integer getVertexCount() {
        return vertexCount;
    }

    public void setVertexCount(Integer vertexCount) {
        this.vertexCount = vertexCount;
    }

    public Integer getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(Integer edgeCount) {
        this.edgeCount = edgeCount;
    }

    public Double getNanotime() {
        return nanotime;
    }

    public void setNanotime(Double nanotime) {
        this.nanotime = nanotime;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
    
    @Override
    public int compareTo(StatisticNode o) {
        int result = this.label.compareTo(o.getLabel());
        
        if (result == 0) {
            if (this.vertexCount > o.getVertexCount()) {
                return 1;
            }
            if (this.vertexCount < o.getVertexCount()) {
                return -1;
            }
            if (this.edgeCount > o.getEdgeCount()) {
                return 1;
            }
            if (this.edgeCount < o.getEdgeCount()) {
                return -1;
            }
        } 
        
        return result;
    }
    
}
