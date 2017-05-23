package com.zlthnrtm.ts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static final int MINIMAL_VERTEX_COUNT = 3;
    
    public static final int MINIMAL_VERTEX_STEP_VALUE = 1;
    
    public static final int MINIMAL_TEST = 1;
    
    public static void main(String[] args) {
        
        int maxVertexCount = 0;
        int vertexStep = 0;
        int testCountPerTest = 0;
        
        
        while (maxVertexCount < MINIMAL_VERTEX_COUNT) {
            System.out.println("Enter max vertex count (minimal value = " + MINIMAL_VERTEX_COUNT + "):");
            maxVertexCount = readInt();
        }
        
        while (vertexStep < MINIMAL_VERTEX_STEP_VALUE) {
            System.out.println("Enter vertex step (minimal value = " + MINIMAL_VERTEX_STEP_VALUE + "):");
            vertexStep = readInt();
        }
        
        while (testCountPerTest < MINIMAL_TEST) {
            System.out.println("Test count (minimal value = " + MINIMAL_TEST + "):");
            testCountPerTest = readInt();
        }
        
        
        
        GraphVertexCover gvc = new GraphVertexCover();
        
        EdgeListGraph elg;
        
        StatisticDataBase statisticDataBase = new ExelStatisticDataBase();
        
        long startTime, totalTime;
        
        double averageTime;
        
        for (int i = MINIMAL_VERTEX_COUNT; i < maxVertexCount; i += vertexStep) {
            
            System.out.println("Current vertex count: " + i);
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.fullGraphGeneration(maxVertexCount);
                startTime = System.nanoTime();
                gvc.calculateStrict(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Strict: " + averageTime);
            
            drawProgress(i - MINIMAL_VERTEX_COUNT, maxVertexCount - MINIMAL_VERTEX_COUNT - 1);
        }
        
        
    }
    
    public static void demonstration(){
        EdgeListGraph edgeListGraph = SimpleGraphBuilder.vertexAsInteger()
                .addEdge(0, 1)
                .addEdge(1, 2)
                .addEdge(2, 3)
                .addEdge(3, 4)
                .addEdge(4, 0)
                .addEdge(6, 6)
                .build();
        
        
        GraphVertexCover graphVertexCover = new GraphVertexCover();
        
        System.out.println("Strict: " + graphVertexCover.calculateStrict(edgeListGraph).toString());
        
        System.out.println("Lazy: " + graphVertexCover.calculateLazy(edgeListGraph).toString());
        
        System.out.println("Greedy: " + graphVertexCover.calculateGreedy(edgeListGraph).toString());
    }
    
    public static int readInt() {
        System.out.print("\n$ ");
        Scanner in = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                result = in.nextInt();
                return result;
            } catch (InputMismatchException e) {
                System.out.print("\nInvalid value. You should enter integer value\n$ ");
            }
        }
    }

    private static void drawProgress(int value, int of) {
        String str = "0% [";
        int barSize = 25;
        double k = (double) value / (double) of;
        for (int i = 0; i < barSize; i++) {
            if (i < k* barSize) {
                str += '#'; 
            } else {
                str += "-";
            }
        }
        str += "] " + (int) Math.round(k * 100) + "%";
        System.out.println(str);
    }
}
