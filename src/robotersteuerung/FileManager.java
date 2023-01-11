/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotersteuerung;

import java.util.ArrayList;

/**
 *
 * @author TvanDahl
 */
public class FileManager {
    private final static FileManager obj = new FileManager();
    public FileManager() {
        
    }
    
    public static FileManager getInstance() {
        return obj;
    }
    
    public static void saveData(String fileName, ArrayList<MotorCommand> data) {
        data.stream().map(d -> d.toString()).forEach(TextFileReader.getInstance()::addToBuffer);
        TextFileReader.getInstance().saveBufferToFile(fileName);
    }
    
    public static ArrayList<MotorCommand> loadData(String fileName) {
        ArrayList<MotorCommand> data = new ArrayList<>();
        String textFileData = TextFileReader.getInstance().readFile(fileName);
        for (String s : textFileData.split("\n")) {
            if (!s.equals("\r")) {
                //System.out.println(s);
                data.add(new MotorCommand(s));
            }
        }
        
        return data;
    }
    
}
