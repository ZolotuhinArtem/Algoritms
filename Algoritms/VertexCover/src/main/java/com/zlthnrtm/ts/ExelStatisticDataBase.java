/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.*;
package com.zlthnrtm.ts;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author manjaro
 */
public class ExelStatisticDataBase implements StatisticDataBase {

    @Override
    public void clear() {

    }

    public void save(String csv) {
        List<String> lines = Arrays.asList(csv);
        Path file = Paths.get("graphic.csv");
        try {
            Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean addNode(Integer vertexCount, Integer edgeCount, Double nanotime, String label) {

        return false;
    }


}

