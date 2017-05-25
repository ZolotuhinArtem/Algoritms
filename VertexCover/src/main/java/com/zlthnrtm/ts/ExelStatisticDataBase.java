/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zlthnrtm.ts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author manjaro
 */
public class ExelStatisticDataBase implements StatisticDataBase{

    private HSSFWorkbook workbook;
    
    private HSSFSheet sheet;
    
    private int rowNum;
    
    public ExelStatisticDataBase() {
        this.workbook = new HSSFWorkbook();
        this.sheet = this.workbook.createSheet("sheet");
        this.rowNum = 1;
        Row row = this.sheet.createRow(0);
        row.createCell(0).setCellValue("Vertex count");
        row.createCell(1).setCellValue("Edge count");
        row.createCell(2).setCellValue("Nanotime");
        row.createCell(3).setCellValue("Label");
    }

    
    
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addNode(Integer vertexCount, Integer edgeCount, Double nanotime, String label) {
        
        Row row = this.sheet.createRow(this.rowNum);
        row.createCell(0).setCellValue(vertexCount);
        row.createCell(1).setCellValue(edgeCount);
        row.createCell(2).setCellValue(nanotime);
        row.createCell(3).setCellValue(label);
        
        
        this.rowNum++;
        
        return true;
    }

    @Override
    public boolean save(String name) {
        try {
            Path path = Paths.get(name);
            File file = path.toFile();
            this.workbook.write(file);
        } catch (IOException ex) {
            Logger.getLogger(ExelStatisticDataBase.class.getName()).log(Level.SEVERE, ex.getMessage());
        }
        return true;
    }
    
}
