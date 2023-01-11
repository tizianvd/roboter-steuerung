/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotersteuerung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author TvanDahl
 */
public class TextFileReader {
    private static final TextFileReader obj = new TextFileReader();
    private static String buffer = "";
    public TextFileReader() {
    }
   
    public void clearBuffer() {
        buffer = "";
    }
    
    public void addToBuffer(String s) {
        buffer += s;
    }
    
    public void saveBufferToFile(String fileName) {
        try (PrintWriter w = new PrintWriter(fileName)) {
            w.println(buffer);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        
        clearBuffer();
    }
    
    public String readFile(String fileName) {
        try(FileInputStream inputStream = new FileInputStream(fileName)) {     
            return IOUtils.toString(inputStream);
        } catch (IOException e) {
            System.out.println(e);
        }
        
        return "";
    }
    
    public static TextFileReader getInstance() {
        return obj;
    } 
    
}
