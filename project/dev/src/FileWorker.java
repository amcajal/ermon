/*
 * Proyect:     ERMON.
 * File:        FileWorker.java
 * Description: Implementes operations to handle text files, like writting
 *              and reading data from them.
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

package src;

/* Handle file manipulation. */
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/* Handle exceptions. */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* Data structures */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implements operations to interact with text files (read and write).
*/
public class FileWorker {
    /* CONSTRUCTORS */

    /* Default constructor. */
    public FileWorker() {}

    /* METHODS */

    /**
     * Writes a custom configuration in a text file (valid configuration file).
     *
     * Configuration data is stored in a Map. The method iterates over the map,
     * and extract the information to be written.
     *
     * @param eventMap map with the custom events to be saved in the file.
     * @param outputFile absolute path to the text file where data will be saved
     * @throws FileNotFoundException if outputFile cannot be found.
    */
    public void write (HashMap<Integer, src.Event> eventMap, File outputFile)
            throws FileNotFoundException {

        /* Exception is caught later in 'CreateWindow.java'. */
        PrintWriter writer = new PrintWriter(outputFile);

        String lineToWrite = "";
        src.Event auxEvent; /* Auxiliar copy of an Event. */

        /*
         * The following variables are used to store the data of the events.
         * Each one its related to one Event variable.
        */
        String title, description;
        int period, duration, startingHour, startingMinute, startingSecond;
        boolean startingTime;

        /*
         * File header, used to recognize a valid configuration file.
         * Header shall not be modified by the user under any circumstances.
        */
        writer.println("Ermon_Configuration");
        writer.println("DO NOT MODIFY THIS FILE MANUALLY"); 

        for (Map.Entry pair : eventMap.entrySet()) {
            auxEvent = (src.Event) pair.getValue();    /* Auxiliar storage. */

            /* Extract information and store them into auxiliar variables. */
            title = auxEvent.getTitle();
            description = auxEvent.getDescription();
            period = auxEvent.getPeriod();
            duration = auxEvent.getDuration();
            startingHour = auxEvent.getStartingHour();
            startingMinute = auxEvent.getStartingMin();
            startingSecond = auxEvent.getStartingSecond();
            startingTime = auxEvent.getStartingTime();

            /*
             * Generate the text line to be printed (atributes are sorted in
             * a specific way; this order is necessary later).
             * The hash (#) character is used to separate the fields, because
             * when the information is retrieved, the string will be splitted by
             * that character. This is the reason of not allowing
             * hash characters while creating events, in the "description" area
             * or "title" area.
            */
            lineToWrite = "" + title + "#" + description + "#"
                    + period + "#" + duration + "#" + startingTime + "#"
                    + startingHour + "#" + startingMinute
                    + "#" + startingSecond;
            
            writer.println(lineToWrite);    /* Write line into output file. */
        }
        writer.close();    /* Once operation has finished, close the file. */
    }

    /**
     * Reads a valid configuration file and returns the list of events.
     * 
     * The extracted information is loaded into a list of Events used to load 
     * the custom configuration into the app, or to modify it in 
     * the creation window.
     * 
     * @param inputFileFullPath absolute path to the configuration file.
     * @return list of read events.
    */
    public ArrayList<src.Event> read (String inputFileFullPath) {
        /*
         * List with loaded events, returned at the end of the method.
         * If the list is empty, the read file is incorrect.
        */
        ArrayList<src.Event> outputList = new ArrayList<>();

        /* List with the lines of the readed configuration file, */
        ArrayList<String> lines = new ArrayList<>();

        String fileLine = ""; 
        String[] splits;    /* Array with splitted parts of a line. */

        /*
         * Auxiliar variables to create events later loaded into 'outputList'.
         * Each variable correspond to an Event variable.
        */
        String title, description;
        int period, duration, hour, min, second;
        boolean startingTime;

        /*
         * Try to open the file and read it.
         * If it fails, the process is cancelled.
        */
        try {

            /* Next 2 lines are needed to acess the file and read the content */
            FileReader fr = new FileReader(inputFileFullPath);
            BufferedReader br = new BufferedReader(fr);

            /* Extract all the lines of the file. */
            while((fileLine = br.readLine()) != null){ 
                lines.add(fileLine);
            }

            if (!lines.isEmpty()) {
                /*
                 * If first line is correct, it shall be equal to
                 * "Ermon_Configuration", as specified in 'Write' process.
                 */
                if (lines.get(0).equals("Ermon_Configuration")) {
                    /*
                     * Read each line, and check that the format is correct,
                     * so the Events can be loaded.
                     * If some of the lines has incorrect data,
                     * the process ends.
                    */
                    try {
                        /*
                         * First and second lines doesnt contain Event data,
                         * so they must be ignored
                         */
                        for (int i = 2; i <= lines.size()-1; i++) {
                            splits = lines.get(i).split("#");
                            /*
                             * If the format is correct, the parts of an Event
                             * shall appear in a certain order and in a certain
                             * format (integer or string). Otherwhise,
                             * the process will end.
                            */
                            title = splits[0];
                            description = splits[1];
                            period = Integer.parseInt(splits[2]);
                            duration = Integer.parseInt(splits[3]);
                            startingTime = Boolean.parseBoolean(splits[4]);
                            hour = Integer.parseInt(splits[5]);
                            min = Integer.parseInt(splits[6]);
                            second = Integer.parseInt(splits[7]);

                            /* Create a new Event with the loaded data- */
                            outputList.add(new src.Event(title, description, 
                                    period, duration, startingTime,
                                    hour, min, second));
                        }

                    /* If any of the lines has an incorrect data, process ends*/
                    } catch (Exception ex) {
                        outputList.clear();    /* outputList is cleared. */
                    }
                }
            }
            br.close();
            fr.close();

        /* If file doesnt exist. */
        } catch (FileNotFoundException ex) {
            outputList.clear();
        /* If file cannot be read. */
        } catch (IOException ex) {
            outputList.clear();
        } finally {
            /*
             * Failed or not, the process shall return the outputList.
             * If everything worked, outputList will contain loaded Events.
             * If something failed, outputList will be empty.
            */
            return outputList;
        }
    }
  
    /**
     * Reads media files.
     * 
     * Media files contains 'about' information. These files are shown in the
     * GenericInfoWindow.
     * 
     * @param pathToFileToRead absolute path to the media file.
     * @return content of the file in String format.
     * @throws FileNotFoundException if file to read cannot be found.
     * @throws IOException if file to read cannot be accessed.
    */
    public String readMedia (String pathToFileToRead)
            throws FileNotFoundException, IOException {
        /* Exceptions are caught in GenericInfoWindow. */ 
        
        String dataToPrint = "";
        
        // Input stream is required to access files inside a external package.
        InputStream in = getClass().getResourceAsStream(pathToFileToRead);
        
        // Scanner is used to iterate over the string.
        java.util.Scanner s = new java.util.Scanner(in).useDelimiter("\\A");
        dataToPrint = s.hasNext() ? s.next() : "";
        s.close();
        return dataToPrint;
    }
}
