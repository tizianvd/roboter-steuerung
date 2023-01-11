/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotersteuerung;

import java.util.ArrayList;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author TvanDahl
 */
class SerialPortReader implements SerialPortEventListener {
    private String output = "";
    String receivestring = "";
    private final SerialPort serialPort;
    private final ArrayList<SerialPortListener> listeners = new ArrayList<>();
    
    public  SerialPortReader(SerialPort serialPort){
        super();
        this.serialPort = serialPort;
    }
    
    public void addListener(SerialPortListener listener) {
        listeners.add(listener);
    }
    
    public void clear() {
        output = "";
    }

    @Override
    public void serialEvent(SerialPortEvent event) {
        String help = "";
        if(event.isRXCHAR()){ 
            if((event.getEventValue() >= 1)){                       
                try {
                    receivestring =  receivestring + serialPort.readString();      

                    if(receivestring.endsWith("\n")){
                        help = receivestring.substring(0,receivestring.length() - 1);
                        receivestring = help;
                        if (output.isEmpty() || !receivestring.equals("\r")) {
                            output = receivestring + output;
                            receivestring = "";
                            for(SerialPortListener listener : listeners){
                                listener.onReceiveString();
                            }
                        }
                    }

                }
                catch (SerialPortException ex) {
                    System.out.println(ex);
                }
            }
        }
        else if(event.isCTS()){
            if(event.getEventValue() == 1){
                System.out.println("CTS - ON");
            }
            else {
                System.out.println("CTS - OFF");
            }
        }
        else if(event.isDSR()){
            if(event.getEventValue() == 1){
                System.out.println("DSR - ON");
            }
            else {
                System.out.println("DSR - OFF");
            }
        }
    }

    public String getOutput() {
        return output;
    }
}