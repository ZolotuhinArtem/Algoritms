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
public interface StatisticDataBase {
    
    void clear();
    
    boolean addNode(Integer vertexCount, Integer edgeCount, Long nanotime, String label);
    
}
