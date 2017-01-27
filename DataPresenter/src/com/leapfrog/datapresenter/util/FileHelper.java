/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.datapresenter.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subasone
 */
public class FileHelper {
    
    public static List<String> readLines(String fileName) throws IOException {
       
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = "";
        while((line = reader.readLine()) != null){
            lines.add(line);
        }
        reader.close();
        return lines;
    }
}
