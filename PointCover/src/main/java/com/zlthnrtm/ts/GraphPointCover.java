package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.List;

public class GraphPointCover {
    

    /**
    * Point[][] graph must be square.
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
    public List<Integer> calculate(Integer[][] graph){
        
        if (graph.length <= 0) {
            throw new IllegalArgumentException("invalid matrix");
        }
        
        if (graph.length != graph[0].length) {
            throw new IllegalArgumentException("matrix must be square");
        }
        
        GraphPoinSetsGenerator graphPoinSetsGenerator = new GraphPoinSetsGenerator();
        
        for(List<Integer> pointList: graphPoinSetsGenerator.generate(getCount(graph))){
            Integer[][] copy = getCopy(graph);
            
            for (Integer point: pointList) {
                for (int i = 0; i < copy.length; i++) {
                    copy[i][point] = null;
                    copy[point][i] = null;
                }
            }
            
            if (getCount(copy) == 0) {
                return pointList;
            }
        }
        
        return new ArrayList<Integer>();
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
