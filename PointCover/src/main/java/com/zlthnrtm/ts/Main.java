/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import java.util.List;

/**
 *
 * @author manjaro
 */
public class Main {
    public static void main(String[] args) {
        
        Integer[][] graph = new Integer[7][7];
        graph[0][1] = 1;
        graph[1][0] = 1;
        
        graph[1][2] = 1;
        graph[2][1] = 1;
        
        graph[2][3] = 1;
        graph[3][2] = 1;
        
        graph[3][5] = 1;
        graph[5][3] = 1;
        
        graph[3][4] = 1;
        graph[4][3] = 1;
        
        graph[0][4] = 1;
        graph[4][0] = 1;
        
        graph[6][6] = 1;
        
        GraphPointCover graphPointCover = new GraphPointCover();
        
        System.out.println(graphPointCover.calculateStrict(graph).toString());
        
        
    }
}
