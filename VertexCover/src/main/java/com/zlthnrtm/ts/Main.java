package com.zlthnrtm.ts;

import com.zlthnrtm.ts.SimpleGraphBuilder.SimpleGraphBuilderVertexAsInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static final int MINIMAL_VERTEX_COUNT = 3;
    
    public static final int MINIMAL_EDGE_COUNT = 1;
    
    public static final int MINIMAL_VERTEX_STEP_VALUE = 1;
    
    public static final int MINIMAL_TEST = 1;
    
    public static void main(String[] args) {
        
        int choose = 0;
        while ((choose > 2) || (choose < 1)) {
            System.out.print("Choose:\n\t1 - test\n\t2 - normal work");
            choose = readInt();
        }
        
        switch (choose) {
            case 1:
                test();
                break;
            case 2:
                normal();
                break;
            default:
                System.out.println("ERROR!");
                break;
        }
    }
    
    public static void test(){
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
        
        Long startTime, totalTime;
        
        double averageTime;
        
        List<StatisticNode> statisticNodes = new LinkedList<>();
        
        elg = GraphGenerator.fullGraphGeneration(3);
        
        for (int i = MINIMAL_VERTEX_COUNT; i <= maxVertexCount; i += vertexStep) {
            
            System.out.println("Current vertex count: " + i);
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.fullGraphGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateStrict(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for FULL Strict: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, i * (i - 1) / 2, averageTime, "FSTRICT"));
            
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.halfFilledGrafGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateStrict(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Half Strict: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, (i + 2) * (i - 1) / 4, averageTime, "HSTRICT"));
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.treeGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateStrict(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Tree Strict: " + averageTime + " nanoseconds" + "\n");
            statisticNodes.add(new StatisticNode(i, i - 1, averageTime, "TSTRICT"));
            //------------------------------------------------------------------------------------------
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.fullGraphGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateLazy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for FULL Lazy: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, i * (i - 1) / 2, averageTime, "FLAZY"));
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.halfFilledGrafGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateLazy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Half Lazy: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, (i + 2) * (i - 1) / 4, averageTime, "HLAZY"));
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.treeGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateLazy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Tree Lazy: " + averageTime + " nanoseconds" + "\n");
            statisticNodes.add(new StatisticNode(i, i - 1, averageTime, "TLAZY"));
            
            //-----------------------------------------------------------------------------------------
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.fullGraphGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateGreedy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for FULL Greedy: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, i * (i - 1) / 2, averageTime, "FGREEDY"));
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.halfFilledGrafGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateGreedy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Half Greedy: " + averageTime + " nanoseconds");
            statisticNodes.add(new StatisticNode(i, (i + 2) * (i - 1) / 4, averageTime, "HGREEDY"));
            
            averageTime = 0.0;
            for (int j = 0; j < testCountPerTest; j++) {
                elg = GraphGenerator.treeGeneration(i);
                startTime = System.nanoTime();
                gvc.calculateGreedy(elg);
                totalTime = System.nanoTime() - startTime;
                averageTime += (double) totalTime / (double) testCountPerTest;
            }
            System.out.println("Average time for Tree Greedy: " + averageTime + " nanoseconds" + "\n");
            statisticNodes.add(new StatisticNode(i, i - 1, averageTime, "TGREEDY"));
            
            System.out.println();
            drawProgress(i - MINIMAL_VERTEX_COUNT, maxVertexCount - MINIMAL_VERTEX_COUNT - 1);
            System.out.println("\n----------------------------------------------------------------------------\n");
        }
        
        Collections.sort(statisticNodes);
        for (StatisticNode node: statisticNodes) {
            statisticDataBase.addNode(node);
        }
        statisticDataBase.save("Table: " + new Date(System.currentTimeMillis()) + ".xls");
    }
    
    public static void normal(){
        
        int edgeCount = -1;
        while (edgeCount < MINIMAL_EDGE_COUNT) {
            System.out.println("If you enter edge, which has two equal vertices, than it is not edge, it is alone vertex, which has valency 0.\n"
                + "Enter edge count (min value = " + MINIMAL_EDGE_COUNT + "):");
            edgeCount = readInt();
        }
        
        SimpleGraphBuilderVertexAsInteger vertexBuilder = SimpleGraphBuilder.vertexAsInteger();
        int v1, v2;
        for (int i = 0; i < edgeCount; i++) {
            System.out.println("#### Edge number " + (i + 1) + " ####");
            v1 = readVertex("First vertex");
            v2 = readVertex("Second vertex");
            vertexBuilder.addEdge(v1, v2);
        }
        
        EdgeListGraph edgeListGraph = vertexBuilder.build();
        
//        EdgeListGraph edgeListGraph = SimpleGraphBuilder.vertexAsInteger()
//                .addEdge(0, 1)
//                .addEdge(1, 2)
//                .addEdge(2, 3)
//                .addEdge(3, 4)
//                .addEdge(4, 0)
//                .build();
        
        
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

    private static int readVertex(String prefix) {
        int vertex = -1;
        while (vertex < 0) {
            System.out.print(prefix);
            vertex = readInt();
            if (vertex >= 0) {
                return vertex;
            } else {
                System.out.println("Error! Vertex index is smaller than zero!");
            }
        }
        return -1;
    }
}
