package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphVertexSetsGenerator{
 
    public GraphVertexSetsGenerator() {        
    }
    
    public List<Set<Vertex>> generate(Set<Vertex> vertexs){
        
        
        
        List<Set<Vertex>> sets = new ArrayList<>();
        
        Map<Integer, Vertex> vertexMap = new HashMap<Integer, Vertex>();
        int k = 0;
        
        for(Vertex vertex: vertexs) {
            vertexMap.put(k, vertex);
            k++;
        }
        
        Set<Vertex> tempVertexs;
        int current = 0;
        
        while (this.hasNext(current, vertexs.size())) {
            tempVertexs = new HashSet<>();
            String str = Integer.toBinaryString(current);
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    tempVertexs.add(vertexMap.get(str.length() - i - 1));
                }
            }
            current++;
            sets.add(tempVertexs);
        }
        
        sets.sort(new Comparator<Set<Vertex>>(){
            @Override
            public int compare(Set<Vertex> o1, Set<Vertex> o2) {
                if (o1.size() > o2.size()) {
                    return 1;
                }
                
                if (o1.size() < o2.size()) {
                    return -1;
                }
                
                return 0;
            }
            
        });
        return sets;
    }
    
    private boolean hasNext(int current, int vertexCount){
        String str = Integer.toBinaryString(current);
        
        if (str.length() <= vertexCount) {
            return true;
        }
        
        return false;
    } 
}
