/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package robotersteuerung;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.io.FilenameUtils;
import utils.ExtendedTable;


public class UserInterface extends javax.swing.JFrame implements SerialPortListener {

    private final int tableMinRows = 100;
    private final String[] motors = {"m1", "m2", "m3", "m4", "m5", "m6", "m7"};
    private final String[] commands = {"goto", "stop", "info","rese"};
    private final String[] columnNames = {"Motor", "Command", "Position", "Speed", "Group"};
    
    private SerialPortManager serialPortManager = new SerialPortManager();
    
    private ArrayList<MotorCommand> commandList = new ArrayList<>();
    
    private String currentFilePath = "";
    
    public UserInterface() {
        //try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } 
        //catch(Exception ignored){}
        initComponents();
        initAdditionalComponents();
    }
    
    private void initAdditionalComponents() {
        motorBox.setModel(new DefaultComboBoxModel(motors));
        commandBox.setModel(new DefaultComboBoxModel(commands));
        serialPortManager.addListener(this);
        
        commandTable = new ExtendedTable(commandTable.getModel());
        commandTable.setDefaultEditor(Object.class, null);                      //Deaktiviert die Eingabe für die Tabelle.
        commandTable.setRowHeight(30);
        commandTable.getTableHeader().setResizingAllowed(false);
        commandTable.getTableHeader().setReorderingAllowed(false);
        commandTable.getTableHeader().setFont(new Font("Segoe", Font.PLAIN, 18));
        jScrollPane1.setViewportView(commandTable);
        
        FileNameExtensionFilter ascFilter = new FileNameExtensionFilter("asc files (*.asc)", "asc");
        fileChooser.setFileFilter(ascFilter);
        
        fileMenu.add(createMenuItem("New", 'N', KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK), new ActionListener(){
            public void actionPerformed(ActionEvent e){
                newFile();
            }
        }));

        fileMenu.add(createMenuItem("Open File...", 'O', KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK), new ActionListener(){
            public void actionPerformed(ActionEvent e){
                openFileChooser(false);
            }
        }));
       
        fileMenu.addSeparator();
        fileMenu.add(createMenuItem("Save", 'S', KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), new ActionListener(){
            public void actionPerformed(ActionEvent e){
                save();
            }
        }));

        fileMenu.add(createMenuItem("Save As...", 'S', KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.ALT_DOWN_MASK), new ActionListener(){
            public void actionPerformed(ActionEvent e){
                openFileChooser(true);
            }
        }));
    }
    
    private void resetInputFields() {
        positionField.setText("000000");
        speedField.setText("000");
        groupField.setText("000");
        motorBox.setSelectedIndex(0);
        commandBox.setSelectedIndex(0);
    }
    
    public JMenuItem createMenuItem(String text, char mnemonic, KeyStroke keyStroke, ActionListener actionListener) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.setMnemonic(mnemonic);
        menuItem.setAccelerator(keyStroke);
        menuItem.addActionListener(actionListener);
        return menuItem;
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        commandTable = new javax.swing.JTable();
        positionField = new javax.swing.JTextField();
        speedField = new javax.swing.JTextField();
        groupField = new javax.swing.JTextField();
        motorBox = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();
        commandBox = new javax.swing.JComboBox<>();
        sendButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("new - Roboter Steuerung");
        setPreferredSize(new java.awt.Dimension(750, 610));
        setResizable(false);

        commandTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        commandTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Motor", "Command", "Position", "Speed", "Group"
            }
        ));
        commandTable.setRowHeight(30);
        commandTable.getTableHeader().setResizingAllowed(false);
        commandTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(commandTable);

        positionField.setColumns(6);
        positionField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        positionField.setText("000000");
        positionField.setName(""); // NOI18N
        positionField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        positionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onType(evt);
            }
        });

        speedField.setColumns(3);
        speedField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        speedField.setText("000");
        speedField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        speedField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onType(evt);
            }
        });

        groupField.setColumns(3);
        groupField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        groupField.setText("000");
        groupField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textFieldFocusGained(evt);
            }
        });
        groupField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onType(evt);
            }
        });

        motorBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        addButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addButton.setText("Add");
        addButton.setToolTipText("");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                onReleaseAddButton(evt);
            }
        });

        commandBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        sendButton.setText("Senden");
        sendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendButtonMouseClicked(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        fileMenu.setText("File");
        fileMenu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                onType(evt);
            }
        });
        jMenuBar1.add(fileMenu);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(motorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(commandBox, 0, 156, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(speedField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(speedField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addButton)
                    .addComponent(commandBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void updateTable() {
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        ArrayList<Integer> sentRows = new ArrayList<>();
        for (int i = 0; i < tableMinRows; i++) {
            if (i < commandList.size()) {
                model.addRow(new Object[]{commandList.get(i).getMotor(), commandList.get(i).getCommand(), commandList.get(i).getPosition(), commandList.get(i).getSpeed(), commandList.get(i).getGroup()});   
                commandTable.setRowColor(i, Color.red);
            } else {
                model.addRow(new Object[]{"", "", "", "", ""});   
            }
        }
        
        commandTable.setModel(model);
    }
    
    
    private void addCommand() {
        MotorCommand m = new MotorCommand(String.valueOf(motorBox.getSelectedItem()), String.valueOf(commandBox.getSelectedItem()), positionField.getText(), speedField.getText(), groupField.getText());
        commandList.add(m);
        System.out.print("Input: " + m);
        updateTable();
        resetInputFields();
        this.requestFocus();
        if (!currentFilePath.isEmpty()) {
            this.setTitle("*"+currentFilePath + " - Roboter Steuerung");
        }
    }
    
    private void sendNextCommands() {
        for (MotorCommand m : commandList) {
            if (!m.hasBeenSent()) {
                for (MotorCommand m2 : commandList) {
                    if (m2.getGroup().equals(m.getGroup())) {
                        serialPortManager.sendString(m2.toString());
                        m2.setSent(true);
                    }
                }
                updateTable();
                break;
            }
        }
    }
    
    private void openFileChooser(boolean save) {
        int selection = fileChooser.showSaveDialog(this);
        if (selection == JFileChooser.APPROVE_OPTION) {
            String path = fileChooser.getSelectedFile().getAbsolutePath();
            if (save) {
                if (FilenameUtils.getExtension("path") == null) {
                    path += ".asc";
                }
                FileManager.getInstance().saveData(path, commandList);
            } else {
                commandList = FileManager.getInstance().loadData(path);
                updateTable();
            }
            currentFilePath = path;
            this.setTitle(path + " - Roboter Steuerung");
        }
    }
    
    private void newFile() {
        this.setTitle("new - Roboter Steuerung");
        currentFilePath = "";
        commandList.clear();
        updateTable();
    }
    
    private void save() {
        if (currentFilePath.isEmpty()) {
            openFileChooser(true);
        } else {
            FileManager.getInstance().saveData(currentFilePath, commandList);
            this.setTitle(currentFilePath + " - Roboter Steuerung");
        }
    }
    
    private void onReleaseAddButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onReleaseAddButton
        addCommand();
    }//GEN-LAST:event_onReleaseAddButton

    private void textFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textFieldFocusGained
//        JTextField field = (JTextField) evt.getSource();
//        if (field.getText().equals("000000") || field.getText().equals("000000") || field.getText().equals("Gruppe")) {
//            field.setText("");
//        }
    }//GEN-LAST:event_textFieldFocusGained

    private void onKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onKeyReleased
        switch(evt.getKeyCode()) {
            case java.awt.event.KeyEvent.VK_ENTER: {
                addCommand();
            } break;
        }
    }//GEN-LAST:event_onKeyReleased

    private void onType(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onType
        JTextField textField = (JTextField) evt.getSource();
        if (textField.getText().length() >= textField.getColumns()) {
            evt.consume();
        }
    }//GEN-LAST:event_onType

    private void sendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendButtonMouseClicked
        sendNextCommands();
    }//GEN-LAST:event_sendButtonMouseClicked
    
    public void onReceiveString() {
        System.out.println(serialPortManager.getOutput());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> commandBox;
    private javax.swing.JTable commandTable;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField groupField;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> motorBox;
    private javax.swing.JTextField positionField;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField speedField;
    // End of variables declaration//GEN-END:variables
}
