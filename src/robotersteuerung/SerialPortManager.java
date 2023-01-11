/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotersteuerung;

import jssc.SerialPort;

/**
 *
 * @author TvanDahl
 */
public class SerialPortManager {
    private SerialPort serialPort;
    private SerialPortReader serialPortReader;
    public SerialPortManager() {
        InitSerialPort();
    }
    
    private void InitSerialPort() {
        try {
            serialPort = new SerialPort("COM1");
            serialPort.openPort();
            serialPort.setParams(9600, 8, 1, 0);
            int mask = SerialPort.MASK_RXCHAR;
            serialPort.setEventsMask(mask);
            
            serialPortReader = new SerialPortReader(serialPort);
            serialPort.addEventListener(serialPortReader);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public String getOutput() {
        if (serialPort != null) {
            return serialPortReader.getOutput();
        }
        
        return "null";
    }
    
    public void sendString(String str) {
        System.out.println("Debug: " + str);
        try{
            serialPortReader.clear();
            serialPort.writeString(str);
        }
        catch(Exception ex){
            //System.out.println(ex);
        }
    }
    
    public void addListener(SerialPortListener listener) {
        if (serialPortReader != null) {
            serialPortReader.addListener(listener);
        }
    }
    
}
