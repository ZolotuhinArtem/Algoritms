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
    
    public static final String FSTRICT = "FSTRICT";
    public static final String HSTRICT = "HSTRICT";
    public static final String TSTRICT = "TSTRICT";
    public static final String FLAZY = "FLAZY";
    public static final String HLAZY = "HLAZY";
    public static final String TLAZY = "TLAZY";
    public static final String FGREEDY = "FGREEDY";
    public static final String HGREEDY = "HGREEDY";
    public static final String TGREEDY = "TGREEDY";
    
    
    void clear();
    
    boolean save(String name);
    
    boolean addNode(Integer vertexCount, Integer edgeCount, Double nanotime, String label);
    
    boolean addNode(StatisticNode node);
    
}
