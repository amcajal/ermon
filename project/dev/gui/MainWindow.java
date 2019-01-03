/*
 * Proyect:     ERMON.
 * File:        MainWindow.java
 * Description: Application main interface. It works as entry point.
 *              It is the first window that appears when launching
 *              the program. Controls the clocks/events behaviour
 *              and give access to the different configuration and
 *              information sections.
 * Java:        JDK 7
 * Contact:     Alberto Martin Cajal <amartin.glimpse23@gmail.com>
 * Website:     https://github.com/amcajal/ermon
 * License: GNU GPL v3.0
 * Copyright (C) 2018,2019 Alberto Martin Cajal
 *
 * This file is part of ERMON.
 *
 * ERMON is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ERMON is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ERMON.  If not, see <http://www.gnu.org/licenses/>.
*/

package gui;

/* Graphical operations. */
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.util.ArrayList;    /* To use ArrayList data structure. */
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/* Main classes with the core functionality of the application */
import src.EventClock;
import src.GenericClock;
import src.Flags;
import src.ConfigLoader;
import src.Event;
import src.FileWorker;
import src.Flags.ClockType;
import src.Flags.CreationWindowMode;

/**
 * Contains the main User Interface; Entry point of the application.
 *
 * MainWindow controls the behaviour of the core elements of the application,
 * -clocks, configuration windows, information windows, buttons-
 * Main method of the application, first in being executed.
*/
public class MainWindow extends javax.swing.JFrame {

    /* CLASS VARIABLES */

    /* 
     * 'systemTimeClock' controls the system time -that is, the hour, minute
     * and second of the current day, established by the O.S.
    */
    GenericClock systemTimeClock;
    
    /*
     * 'workedTimeClock' controls the "working" time of the application,
     * that is, the amount of time the application has been scheduling and
     * deploying events (if clocks are paused/stopped, "working" time doesn't
     * increase).
    */
    GenericClock workedTimeClock;

    /*
     * 'eventTimeClock' controls the event timers: how much time until the next
     * event stats, and how much time until the current event(s) in progress
     * finishes.
    */
    EventClock eventTimeClock;

    /*
     * Controls the behaviour of the "PlayAndPause" button, depending on the
     * current state of the application. If 'initialState' is true, 
     * clocks are initialized. Otherwhise, depends on the 'paused' variable
     * value, they are started or paused.
    */
    boolean initialState;
    boolean paused;
    
    ConfigLoader configLoader;    /* Loads the selected configuration. */

    /* Only one instance is allowed for each child window. */
    CreationWindow creationWindow;
    GenericInfoWindow habitsWindow;
    GenericInfoWindow aboutWindow;

    /* CONSTRUCTORS */

    /**
     * Initialize class variables and GUI elements.
    */
    public MainWindow() {
        initComponents();    /* Swing Componentes automatic initialization. */
        
        /* Application will ask for confirmation before being closed. */
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String ObjButtons[] = {"Yes","No"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                    "Are you sure you want to exit?",
                    "Ermon",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,null,
                    ObjButtons,ObjButtons[1]);

                if(PromptResult==JOptionPane.YES_OPTION)
                {
                    System.gc(); 
                    System.exit(0);
                }
            }
        });

        /*
         * Links 'eventNameLabel' JLabel to 'jPanel3' in order to avoid
         * the resize of the first element (keeping its size static).
         */
        jPanel3.add(eventNameLabel);

        initialState = true;
        paused = false;
        
        /* 
         * Configuration panel is visible only when 'ConfigButton' is pressed.
         * Main window shall resize itself each time the configuration panel
         * appears or dissapears.
        */
        this.configPanel.setVisible(false);
        this.pack();
        
        /* Define behaviour of 'configButton'. */
        this.defineConfigButtonBehavior();
        
        /* Create default configuration.*/
        this.configLoader = new ConfigLoader();
        this.configLoader.loadDefaultEvents();

        /* Initialize clocks.*/
        this.initializeClock(ClockType.SYSTEM_TIME);
        this.initializeClock(ClockType.EVENT_TIME);
        this.initializeClock(ClockType.WORKED_TIME);

        /*
         * System Time Clock is started at the beginning, and wont be
         * stopped until the application is closed.
        */
        this.startClock(ClockType.SYSTEM_TIME);
        
        /* 'Welcome' message. */
        this.textArea.setText("******************\n" +
                "             ErMon          \n   Ergonomic Monitor\n" +
                "******************\n");
    }

    
    /* METHODS */

    /**
     * Autogenerated code.
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        habitsButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextPane();
        configButton = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        systemTimeLabel = new javax.swing.JLabel();
        workedTimeLabel = new javax.swing.JLabel();
        eventTimeLabel = new javax.swing.JLabel();
        eventNameLabel = new javax.swing.JLabel();
        eventButton = new javax.swing.JButton();
        playAndPauseButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        ignoreForceButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        configPanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        playSoundButton = new javax.swing.JCheckBox();
        pauseWorkedTimeButton = new javax.swing.JCheckBox();
        applyButton = new javax.swing.JButton();
        popUpToFrontButton = new javax.swing.JCheckBox();
        Reset = new javax.swing.JButton();
        configMessageLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        loadDefaultEventsButton = new javax.swing.JButton();
        loadCustomEventsButton = new javax.swing.JButton();
        createCustomButton = new javax.swing.JButton();
        customFromTemplateButton = new javax.swing.JButton();
        modifyCustomButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ermon: Perform healthy habits while working with the computer");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        habitsButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        habitsButton.setText("Habits");
        habitsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habitsButtonActionPerformed(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aboutButton.setText("About");
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        textArea.setEditable(false);
        textArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(textArea);

        configButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        configButton.setText("Configuration");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(habitsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aboutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(configButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(configButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(habitsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(aboutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        systemTimeLabel.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        systemTimeLabel.setText("--:--:--");
        systemTimeLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "System Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        workedTimeLabel.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        workedTimeLabel.setText("--:--:--");
        workedTimeLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Worked Time", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        eventTimeLabel.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        eventTimeLabel.setText("--:--:--");
        eventTimeLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nex Event in", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        eventNameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eventNameLabel.setText("Event Name");
        eventNameLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        eventNameLabel.setFocusable(false);
        eventNameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        eventButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        eventButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_seeButton.png"))); // NOI18N
        eventButton.setEnabled(false);
        eventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventButtonActionPerformed(evt);
            }
        });

        playAndPauseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_playButton.png"))); // NOI18N
        playAndPauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAndPauseButtonActionPerformed(evt);
            }
        });

        stopButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_stopButton_small.png"))); // NOI18N
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        ignoreForceButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ignoreForceButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_forceButton_small.png"))); // NOI18N
        ignoreForceButton.setEnabled(false);
        ignoreForceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreForceButtonActionPerformed(evt);
            }
        });

        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/icon_addButton.png"))); // NOI18N
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(playAndPauseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(eventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ignoreForceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(systemTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(eventTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eventNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(workedTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(systemTimeLabel)
                    .addComponent(workedTimeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eventTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eventNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playAndPauseButton)
                            .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eventButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ignoreForceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        configPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("CONFIGURATION PANEL"));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("BASIC"));

        playSoundButton.setSelected(true);
        playSoundButton.setText("Play Pop-Ups with sound");

        pauseWorkedTimeButton.setSelected(true);
        pauseWorkedTimeButton.setText("Pause worked time and events together");

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        popUpToFrontButton.setSelected(true);
        popUpToFrontButton.setText("Bring pop-ups to front");

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(applyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reset))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playSoundButton)
                            .addComponent(pauseWorkedTimeButton)
                            .addComponent(popUpToFrontButton))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(playSoundButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pauseWorkedTimeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(popUpToFrontButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(Reset))
                .addContainerGap())
        );

        configMessageLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("ADVANCED"));

        loadDefaultEventsButton.setText("Load Default Events");
        loadDefaultEventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDefaultEventsButtonActionPerformed(evt);
            }
        });

        loadCustomEventsButton.setText("Load Custom Events");
        loadCustomEventsButton.setToolTipText("");
        loadCustomEventsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCustomEventsButtonActionPerformed(evt);
            }
        });

        createCustomButton.setText("Create Custom Events");
        createCustomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCustomButtonActionPerformed(evt);
            }
        });

        customFromTemplateButton.setText("Create Custom Events from template");
        customFromTemplateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customFromTemplateButtonActionPerformed(evt);
            }
        });

        modifyCustomButton.setText("Modify Custom Events");
        modifyCustomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyCustomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(customFromTemplateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadCustomEventsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(createCustomButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modifyCustomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loadDefaultEventsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(loadDefaultEventsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loadCustomEventsButton)
                .addGap(11, 11, 11)
                .addComponent(createCustomButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(customFromTemplateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modifyCustomButton))
        );

        javax.swing.GroupLayout configPanelLayout = new javax.swing.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configPanelLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(configMessageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(configPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(configPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(configMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(configPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Defines the behavior of the 'Configuration' toggle button.
     * 
     * An ItemListener establish the operations performed each time the 
     * toggle button is selected or deselected. When pressed, the configuration
     * panel is visible. When deselected, configuration panel dissapears.
    */
    private void defineConfigButtonBehavior(){
        
        this.configButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ev) {
                if(ev.getStateChange()==ItemEvent.SELECTED){
                    configPanel.setVisible(true);
                    pack();
                } else if(ev.getStateChange()==ItemEvent.DESELECTED){
                    configMessageLabel.setText("");
                    configPanel.setVisible(false);
                    pack();
                }
            }
        });
        
    }
    
    /**
     * Executes operations controled by 'aboutButton' button.
     *
     * After pressing the button, the 'GenericInfoWindow' is shown in 'About'
     * mode, allowing the user to query miscellaneous information about the
     * tool and its environment. Only one instance of the window is allowed.
     * If the window is already open, it is restored (if minimized) focused,
     * and made visible.
     *
     * @param evt the pressing of the button.
    */
    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        if (this.aboutWindow == null) {
            aboutWindow = new GenericInfoWindow();
            aboutWindow.loadData(Flags.InformationType.ABOUT);
            aboutWindow.setVisible(true);
        }
        else {
            aboutWindow.setVisible(true);
            aboutWindow.setState(java.awt.Frame.NORMAL);
            aboutWindow.toFront();
        } 
    }//GEN-LAST:event_aboutButtonActionPerformed

    /**
     * Executes operations controled by 'playAndPauseButton' button.
     *
     * Pressing 'playAndPauseButton' triggers different operations depending 
     * on the state of the application:
     *  - If clocks are stopped, they are started from its initial state.
     *  - If clocks are running, they are paused, saving its data.
     *  - If clocks are paused, they continue its work with the saved data.
     * Button icon changes too.
     *
     * @param evt the pressing of the button.
    */
    private void playAndPauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAndPauseButtonActionPerformed
        /*
         * If 'initialState' its True, clocks are in its initial state (no saved
         * data), either because the application has just been executed, or
         * because 'stopButton' has been pressed, and the internal data of
         * the clocks has been erased. Data is loaded from the beginning in
         * this situation.
        */
        if (this.initialState == true) {
            
            /* Load the configuration into the clock. */
            this.eventTimeClock.loadConfiguration(this.configLoader);
            
            /* 
             * 'initialState' is now False, as the clocks has been
             * started. Until the variable is modified again, another
             * pressing operation on 'playButton' will trigger a different
             * set of actions.
             */
            this.initialState = false;

            /* Put clocks working. */
            this.startClock(ClockType.WORKED_TIME);
            this.startClock(ClockType.EVENT_TIME);
            
            /* Change icon. */
            playAndPauseButton.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/media/icon_pauseButton.png")));
            
            /* Visual feedback. */
            this.textArea.setText("***TIMERS STARTED\n");
            
            /*
             * While clocks are running, several operations shall not be 
             * available, while others can be performed normally. 
             * Buttons related to them shall represent this situation 
             * (changing to enabled/disabled).
             * Allowed: stop clocks, check events info, add or ignore event.
             * Not allowed: open and/or modify configuration.
             */
            eventButton.setEnabled(true);
            stopButton.setEnabled(true);
            addButton.setEnabled(true);
            ignoreForceButton.setEnabled(true);

            configButton.setSelected(false);
            configButton.setEnabled(false);
            
            /* 
             * Because 'creationWindow' can be used for create events in
             * execution time, any previously opened instance of the window 
             * shall be closed.
            */
            if (this.creationWindow != null) {
                this.creationWindow.dispose();
            }
        }
        /*
         * This branch is executed when 'playAndPauseButton' is pressed
         * while the clocks are currently running (no initial state).
        */
        else {
            /* 'playButton' transits from one start to another,
             * depending on its actual state:
             * - If clocks are running, pressing it will PAUSE them.
             * - If clocks are paused, pressing it will RESTART them.
             * Button changes its icon to give visual feedback about
             * the operations that will be triggered if pressed.
            */
            if (this.paused == true) {
                this.startClock(ClockType.WORKED_TIME);
                this.startClock(ClockType.EVENT_TIME);

                playAndPauseButton.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/media/icon_pauseButton.png")));
                this.paused = false;

                /* Visual feedback. */
                this.textArea.setText(this.textArea.getText() +
                    "***\n***\n***\n***TIMERS RESTARTED\n");
            }
            else{
                if (this.configLoader.getPauseClocks() == true) {
                    this.pauseClock(ClockType.WORKED_TIME);
                }
                
                this.pauseClock(ClockType.EVENT_TIME);

                playAndPauseButton.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/media/icon_playButton.png")));
                this.paused = true;

                /* Visual feedback. */
                this.textArea.setText(this.textArea.getText() +
                    "***\n***\n***\n***TIMERS PAUSED\n");
            }
        }
    }//GEN-LAST:event_playAndPauseButtonActionPerformed

    /**
     * Executes operations controled by 'stopButton' button.
     *
     * Pressing 'stopButton' stops the clocks, releasing all resources
     * and clearing them from its internal data. Stopping the clocks
     * returns the application to its initial state.
     *
     * @param evt the pressing of the button.
    */
    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        this.stopClock(ClockType.WORKED_TIME);
        this.stopClock(ClockType.EVENT_TIME);
        
        this.textArea.setText(this.textArea.getText() 
                + "***\n***\n***\n***TIMERS STOPPED AFTER: " 
                + this.workedTimeLabel.getText() + "\n");
        
        /*
         * Stopping the clocks restores several elements of the GUI to
         * its initial state.
        */
        this.restartElements();       
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * Executes operations controled by 'eventButton' button.
     *
     * 'eventButton' shows the pop-up with the events information. The
     * pop-up contains two tabs, one for the Periodical Execution Events or
     * PXE, and another for the Single Execution Events or SXE. PXE tab shows
     * the next PXE event or events that will be deployed, while SXE tab
     * shows the next SXE to be launched, and a list of all SXE loaded.
     *
     * @param evt the pressing of the button.
    */
    private void eventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventButtonActionPerformed
        this.eventTimeClock.showPopUp();
    }//GEN-LAST:event_eventButtonActionPerformed

    /**
     * Executes operations controled by 'habitsButton' button.
     *
     * 'configButton' creates a GenericInfoWindow in "Events" mode.
     * The user can then check information about the events of the app,
     * both default set and customized ones (if the user has created them).
     * Only one instance of the window is allowed.
     * If the window is already open, it is restored (if minimized), focused,
     * and made visible.
     *
     * @param evt the pressing of the button.
    */
    private void habitsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habitsButtonActionPerformed
        if (habitsWindow == null) {
            habitsWindow = new GenericInfoWindow(this.eventTimeClock.getPXE(), 
                    this.eventTimeClock.getSXE());
            habitsWindow.loadData(Flags.InformationType.EVENTS);
            habitsWindow.setVisible(true); 
        }
        else{
            habitsWindow.setVisible(true);
            habitsWindow.setState(java.awt.Frame.NORMAL);
            habitsWindow.toFront();
        }
    }//GEN-LAST:event_habitsButtonActionPerformed

    /**
     * Executes operations controled by 'ignoreForceButton' button.
     *
     * Only affects to PXE. Depends on the status of the app:
     * - If there are PXE events in progress, pressing this button
     *    will ignore them (the execution of the events will end).
     * - If there are no PXE events in progress, pressing this button
     *    will force them (the events will start inmediatly).
     *
     * @param evt the pressing of the button.
    */
    private void ignoreForceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreForceButtonActionPerformed
        /*
         * 'eventState' will be false if no event is already in progress.
         * 'eventState' will be true if there is at least one event in progress.
        */
        boolean eventState = this.eventTimeClock.getEventInProgress();

        if (eventState == false) { 
            this.eventTimeClock.forceEvent();
        }
        else {
            this.eventTimeClock.ignoreEvent();
        }

        /* Visual feedback. */
        this.textArea.setText(this.textArea.getText() +
                    "***\n***\n***\n***EVENT FORCED OR IGNORED\n");
    }//GEN-LAST:event_ignoreForceButtonActionPerformed

    /**
     * Executes operations controled by 'addButton' button.
     *
     * Allows the creation of events during execution time.
     * When pressed, the application ask for confirmation. Then
     * opens a CreateWindow window. When finished, the created
     * events are returned and loaded into the EventClock.
     *
     * @param evt the pressing of the button.
    */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        /* Pop-up asking for confirmation. */
        String ObjButtons[] = {"Yes","No"};
        int selectedOption = JOptionPane.showOptionDialog(null,
                                  "Do you want to create additional events"
                                  + " to add to the current configuration?"
                                  + " Events will be kept until the"
                                  + " application is closed.", /* Message. */
                                  "Creating additional events", /* Header. */
                                  JOptionPane.DEFAULT_OPTION,
                                  JOptionPane.QUESTION_MESSAGE, null,
                                  ObjButtons,ObjButtons[1]);

        if (selectedOption == JOptionPane.YES_OPTION) {
            if (this.creationWindow != null) {
                this.creationWindow.dispose();
            }
            
                this.creationWindow = new CreationWindow();
                this.creationWindow.setMode(CreationWindowMode.ADD);
                /*
                 * Java keeps reference to the ArrayList when they are passed
                 * to functions ('pass by reference' simulated). With the 
                 * following operation, CreationWindow is able to modify
                 * the array of eventClock directly.
                */
                this.creationWindow.setNewAddedEvents(
                        this.eventTimeClock.getNewAddedEvents());
                
                creationWindow.setVisible(true);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Executes operations controled by 'applyButton' button.
     * 
     * Apply basic configuration options.
     * 
     * @param evt the pressing of the button.
    */
    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        this.applyConfig();
        this.configMessageLabel.setForeground(Color.blue);
        this.configMessageLabel.setText("Basic configuration options applied.");
    }//GEN-LAST:event_applyButtonActionPerformed

    /**
     * Executes operations controled by 'loadDefaultEvents' button.
     * 
     * Loads the default set of events.
     * 
     * @param evt the pressing of the button.
    */
    private void loadDefaultEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDefaultEventsButtonActionPerformed
        this.configLoader.loadDefaultEvents();  
        this.configMessageLabel.setForeground(Color.blue);
        this.configMessageLabel.setText("Default set of events loaded.");
    }//GEN-LAST:event_loadDefaultEventsButtonActionPerformed

    /**
     * Executes operations controled by 'loadCustomEvents' button.
     * 
     * Loads a custom set of events. A custom set of events is composed of
     * those events created by the user in the Creation Window, and later saved
     * in a configuration file.
     * 
     * @param evt the presing of the button.
    */
    private void loadCustomEventsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCustomEventsButtonActionPerformed
        ArrayList<Event> customList = new ArrayList<>();
        
        /* To read the configuration file. */
        FileWorker fileReader = new FileWorker();

        /* Browse input file and obtain absolute path. */
        String inputFilePath = this.browseFile();    
    
        /*
         * Loads into the list the data from the configuration file.
         * List will contain data if the configuration file is valid, that is:
         * - File can be read.
         * - File is not empty.
         * - File is in the correct format.
        */
        customList = fileReader.read(inputFilePath);

        if (!customList.isEmpty()) {  
            /* Visual feedback. */
            this.configLoader.loadCustomEvents(customList);
            this.configMessageLabel.setForeground(Color.blue);
            //this.configMessageLabel.setText("Loaded custom events.");
            String[] l = inputFilePath.split("\\\\");
            this.configMessageLabel.setText(
                    "Loaded custom events: " + l[l.length-1]); 
        }
        else {    /* Configuration file is not valid. */
            this.configMessageLabel.setForeground(Color.red);
            this.configMessageLabel.setText("Invalid file."
                    + " Default set of events remains."); 
        }
    }//GEN-LAST:event_loadCustomEventsButtonActionPerformed
    
    /**
     * Executes operations controled by 'createCustom' button.
     * 
     * Opens the Creation Window, where user can create/modify events and save
     * them in configuration files for further use.
     * 
     * @param evt the pressing of the button.
     * @see CreationWindow
    */
    private void createCustomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCustomButtonActionPerformed
        if (this.creationWindow != null) {
            this.creationWindow.dispose();
        }
        this.creationWindow = new CreationWindow();
        this.creationWindow.setMode(CreationWindowMode.SAVE);
        this.creationWindow.setVisible(true);

        configMessageLabel.setText("");
    }//GEN-LAST:event_createCustomButtonActionPerformed

    /**
     * Executes operations controled by 'modifyCustom' button.
     * 
     * Loads in the Creation Window the data of a configuration file, allowing
     * the user to modify the events contained in it.
     * 
     * @param evt the pressing of the button.
    */
    private void modifyCustomButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyCustomButtonActionPerformed
        if (this.creationWindow != null) {
            this.creationWindow.dispose();
        }        
        
        ArrayList<Event> customList = new ArrayList<>();
        
        /* Reads configuration file. */
        FileWorker fileReader = new FileWorker();

        /* Obtain absolute path of the configuration file. */
        String inputFilePath = this.browseFile();  
     
        /*
         * Loads into the list the data from the configuration file.
         * List will contain data if the configuration file is valid, that is:
         * - File can be read.
         * - File is not empty.
         * - File is in the correct format.
        */
        customList = fileReader.read(inputFilePath);

        if (!customList.isEmpty()) {
            /* Open CreationWindow with custom list of events already loaded. */
            this.creationWindow = new CreationWindow(customList);
            this.creationWindow.setMode(CreationWindowMode.SAVE);
            this.creationWindow.setVisible(true);

            configMessageLabel.setText("");
        }
        else {    /* Configuration file is not valid.*/
            /* Visual feedback. */
            configMessageLabel.setForeground(Color.red);
            configMessageLabel.setText("Invalid configuration file.");    
        }
    }//GEN-LAST:event_modifyCustomButtonActionPerformed

    /**
     * Executes operations controled by 'customFromTemplate' button.
     * 
     * Loads in the Creation Window the default set of events. In this way,
     * user can create custom one using the already defined ones as templates.
     * 
     * @param evt the pressing of the button.
    */
    private void customFromTemplateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customFromTemplateButtonActionPerformed
        if (this.creationWindow != null) {
            this.creationWindow.dispose();
        }        
        
        ArrayList<Event> customList = new ArrayList<>();
        
        /*
         * In order to avoid interferences with the main 'configloader', a local
         * one is created, retreiving from it the default set of events.
        */
        ConfigLoader tempConfigLoader = new ConfigLoader();
        tempConfigLoader.loadDefaultEvents();
        
        this.creationWindow = new CreationWindow(tempConfigLoader.getEventList());
        this.creationWindow.setMode(CreationWindowMode.SAVE);
        this.creationWindow.setVisible(true);

        configMessageLabel.setText("");
    }//GEN-LAST:event_customFromTemplateButtonActionPerformed

    /**
     * Reset basic configuration options to their initial values.
     * 
     * Initial configuration options are:
     * - Sound is played when pop-up appears.
     * - WorkedTime clock and EventTime clock are paused together.
     * - Pop-ups are brought to front.
     * 
     * @param evt the pressing of the button.
    */
    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        this.playSoundButton.setSelected(true);
        this.popUpToFrontButton.setSelected(true);
        this.pauseWorkedTimeButton.setSelected(true);
        this.applyConfig();
        
        this.configMessageLabel.setForeground(Color.blue);
        this.configMessageLabel.setText("Basic configuration options"
                + " restored to its initial values. Changes applied.");
    }//GEN-LAST:event_ResetActionPerformed

    /**
     * Browse a file in the local file system.
     * 
     * A file browser allows the user to select a file from the local file
     * system. The method retrieves the absolute path to the file.
     * 
     * @return absolute path to the selected file.
    */
    private String browseFile () {
        String filePath = "";

        /* File browser (only shows files). */
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        /* Set JFileChooser text. */
        UIManager.put("FileChooser.openDialogTitleText", "Open Events file");
        UIManager.put("FileChooser.lookInLabelText", "Look In");
        UIManager.put("FileChooser.openButtonText", "Open");
        UIManager.put("FileChooser.cancelButtonText", "Cancel");
        UIManager.put("FileChooser.fileNameLabelText", "File Name");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Type Files");
        UIManager.put("FileChooser.openButtonToolTipText", "Open events file");
        UIManager.put("FileChooser.cancelButtonToolTipText","Cancel");
        UIManager.put("FileChooser.fileNameHeaderText","File Name");
        UIManager.put("FileChooser.upFolderToolTipText", "Up One Level");
        UIManager.put("FileChooser.homeFolderToolTipText","Desktop");
        UIManager.put("FileChooser.newFolderToolTipText","Create New Folder");
        UIManager.put("FileChooser.listViewButtonToolTipText","List");
        UIManager.put("FileChooser.newFolderButtonText","Create New Folder");
        UIManager.put("FileChooser.renameFileButtonText", "Rename File");
        UIManager.put("FileChooser.deleteFileButtonText", "Delete File");
        UIManager.put("FileChooser.filterLabelText", "Type Files");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Details");
        UIManager.put("FileChooser.fileSizeHeaderText","Size");
        UIManager.put("FileChooser.fileDateHeaderText", "Date Modified");
        SwingUtilities.updateComponentTreeUI(fileChooser);

        /* Return value of the method. */
        int returnVal = fileChooser.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {    
            filePath = fileChooser.getSelectedFile().getAbsolutePath();
        }

        return filePath; 
    }
    
    /**
     * Apply basic configuration options.
     * 
     * Basic configuration options selected by the user are loaded in
     * the 'configLoader'.
    */
    private void applyConfig() {
        this.configLoader.setPlaySound(this.playSoundButton.isSelected());
        this.configLoader.setPopUpInFront(this.popUpToFrontButton.isSelected());
        this.configLoader.setPauseClocks(this.pauseWorkedTimeButton.isSelected());
    }
    
    /**
     * Returns several GUI elements to its initial state.
    */
    private void restartElements() {
        /* Clean Clock Labels and Event Label. */
        this.workedTimeLabel.setText("--:--:--");
        this.eventTimeLabel.setText("--:--:--");
        eventNameLabel.setText("Event Name");

        /*
         * Returns the application state and buttons to its initial state.
         * In initial state, only 'playButton' and 'configButton' are enabled.
         * This is because configuration cannot be set while clocks are
         * running.
         */
        this.initialState = true; 
        this.playAndPauseButton.setEnabled(true);
        configButton.setEnabled(true);
        
        /* Restore icon. */
        if (this.paused == false) {
            playAndPauseButton.setIcon(new javax.swing.ImageIcon(
                        getClass().getResource(
                                "/media/icon_playButton.png")));
        }
        else {
            this.paused = false;
        }

        this.stopButton.setEnabled(false);
        this.addButton.setEnabled(false);
        eventButton.setEnabled(false);
        ignoreForceButton.setEnabled(false);
        
        /*
         * Because CreationWindow can be used to create/modify events, 
         * any instance of CreationWindow previously opened shall be closed.
        */
        if (this.creationWindow != null) {
            this.creationWindow.dispose();
        }
    }
    
    /**
     * Initialize Clocks and excutes them.
     * 
     * Each clock gets initialized by the proper GenericClock constructor,
     * and each one calls to the 'execute()' method of SwingWorker.
     * 'eventTimeClock' and 'workedTimeClock' are in 'stop' status, while
     * 'systemTimeClock' starts to work normally.
     * 
     * @param clockType Establish what clock is initialized.
    */
    private void initializeClock(Flags.ClockType clockType) {
        switch (clockType) {
            /* Each clock is attached to the proper label and initial values. */
            case SYSTEM_TIME:
                this.systemTimeClock = new GenericClock(systemTimeLabel);
                this.systemTimeClock.execute();
                break;
            case WORKED_TIME:
                this.workedTimeClock = new GenericClock(
                        0, 0, 0, workedTimeLabel);
                this.workedTimeClock.execute();
                break;
            case EVENT_TIME:
                this.eventTimeClock = new EventClock(
                        eventTimeLabel, eventNameLabel);
                this.eventTimeClock.execute();
                break;
        }   
    }

    /**
     * Starts a specific clock of the application.
     *
     * Clock continues working and execution its operations. A clock can be
     * started after it has been initialized or after it is paused.
     * The clock to be started is specified by an input flag, 
     * containing a clock type.
     * 
     * @param clockType clock type to be started.
    */
    private void startClock(Flags.ClockType clockType) {
        switch (clockType) {
            case SYSTEM_TIME:
                this.systemTimeClock.startClock();
                break;
            case WORKED_TIME:
                this.workedTimeClock.startClock();
                break;
            case EVENT_TIME:
                this.eventTimeClock.startClock();
                break;
        }
    }

    /**
     * Pauses a specific clock of the application.
     *
     * Pausing a clock stops its activity, but keeps its internal data.
     * A clock can be paused only if it is running (started).
     * The clock to be paused is specified by an input flag, containing
     * a clock type. Pause operation is performed by calling
     * the 'GenericClock' method 'pauseClock()'.
     *
     * @param clockType clock type to be paused.
    */
    private void pauseClock(Flags.ClockType clockType) {
        switch (clockType) {
            case SYSTEM_TIME:
                /*
                 * This branch is never executed (System Clock cannot be paused)
                 * but is included in the code for completeness purposes.
                 */
                this.systemTimeClock.pauseClock();
                break;
            case WORKED_TIME: 
                this.workedTimeClock.pauseClock();
                break;
            case EVENT_TIME: 
                this.eventTimeClock.pauseClock();
                break;
        }
    }

    /**
     * Stops a specific clock of the application.
     *
     * Stop operation ends clock activity and deletes its internal data,
     * returning it to its initial state. A clock can be stopped if it is
     * paused or running.
     * The clock to be stopped is specified by an input flag, containing
     * a clock type. Stop operation is performed by calling
     * the 'GenericClock' method 'stopClock()'.
     *
     * @param clockType clock type to be paused.
    */
    private void stopClock(Flags.ClockType clockType) {
        switch (clockType) {
            case SYSTEM_TIME:
                /*
                 * This branch is never executed (System Clock is not restarted)
                 * but is included in the code for completeness purposes.
                 */
                this.systemTimeClock.stopClock();
                break;
            case WORKED_TIME: 
                this.workedTimeClock.stopClock();
                break;
            case EVENT_TIME: 
                this.eventTimeClock.stopClock();
                break;
        }
    }

    /* MAIN FUNCTION. */
    
    /**
     * Entry point to the application.
     *
     * Create and display Main Window.
     *
     * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException 
//                | IllegalAccessException 
//                | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName())
//                    .log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton applyButton;
    private javax.swing.JToggleButton configButton;
    private javax.swing.JLabel configMessageLabel;
    private javax.swing.JPanel configPanel;
    private javax.swing.JButton createCustomButton;
    private javax.swing.JButton customFromTemplateButton;
    private javax.swing.JButton eventButton;
    private javax.swing.JLabel eventNameLabel;
    private javax.swing.JLabel eventTimeLabel;
    private javax.swing.JButton habitsButton;
    private javax.swing.JButton ignoreForceButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton loadCustomEventsButton;
    private javax.swing.JButton loadDefaultEventsButton;
    private javax.swing.JButton modifyCustomButton;
    private javax.swing.JCheckBox pauseWorkedTimeButton;
    private javax.swing.JButton playAndPauseButton;
    private javax.swing.JCheckBox playSoundButton;
    private javax.swing.JCheckBox popUpToFrontButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel systemTimeLabel;
    private javax.swing.JTextPane textArea;
    private javax.swing.JLabel workedTimeLabel;
    // End of variables declaration//GEN-END:variables
}
