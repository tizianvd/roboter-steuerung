/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotersteuerung;
/**
 *
 * @author TvanDahl
 */
public class MotorCommand {
    private final String motor;
    private final String command;
    private final String position;
    private final String speed;
    private final String group;
    private boolean sent = false;

    public MotorCommand(String motor, String command, String position, String speed, String group) {
        this.motor = motor;
        this.command = command;
        this.position = position;
        this.speed = speed;
        this.group = group;
    }
    
    public MotorCommand(String s) {
        String [] parts = s.split(";");
        this.motor = parts[0];
        this.command = parts[1];
        this.position = parts[2];
        this.speed = parts[3];
        this.group = parts[4];
    }

    public String getMotor() {
        return motor;
    }

    public String getCommand() {
        return command;
    }

    public String getPosition() {
        return position;
    }

    public String getSpeed() {
        return speed;
    }

    public String getGroup() {
        return group;
    }

    public boolean hasBeenSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;", motor, command, position, speed, group);
    }
    
    
}
