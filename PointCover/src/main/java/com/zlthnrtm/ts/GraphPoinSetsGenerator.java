package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GraphPoinSetsGenerator{
 
    public GraphPoinSetsGenerator() {        
    }
    
    public List<List<Integer>> generate(int pointCount){
        int current = 0;
        
        List<List<Integer>> sets = new ArrayList<>();
        
        while (this.hasNext(current, pointCount)) {
            ArrayList<Integer> points = new ArrayList<>();
            String str = Integer.toBinaryString(current);
            for(int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    points.add(str.length() - i - 1);
                }
            }
            current++;
            sets.add(points);
        }
        
        sets.sort(new Comparator<List<Integer>>(){
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
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
    
    private boolean hasNext(int current, int pointCount){
        String str = Integer.toBinaryString(current);
        
        if (str.length() <= pointCount) {
            return true;
        }
        
        return false;
    } 
}
