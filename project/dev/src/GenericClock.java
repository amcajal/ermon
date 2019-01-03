/*
 * Proyect:     ERMON.
 * File:        GenericClock.java
 * Description: Implements the generic Clock element. A clock is a component
 *              that controls the execution of certain operations based on
 *              the system time or internal counters (seconds).
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
 * along with ERMON. If not, see <http://www.gnu.org/licenses/>.
*/

package src;

/* System time and date. */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;    /* GUI Label component. */

/*
 * Perform GUI tasks in background thread. Core component of the application.
*/
import javax.swing.SwingWorker;

/**
 * Clock element that controls events based on system time or internal counters.
 *
 * Root -generic- clock, containing basic operations shared by all kind of
 * clock elements. It behaviour tries to imitate a real clock, iterating
 * over its main loop every one second.
*/
public class GenericClock extends SwingWorker<Integer, String> {
    /* CLASS VARIABLES */

    /**
     * Clock time components.
     * 
     * Clock time values are represented by three componentes:
     * - Seconds.
     * - Minutes (1 minute = 60 seconds).
     * - Hours (1 hour = 60 minutes).
     * Time values are represented in digital format, being 00:00:00 the
     * min. time value, and 23:59:59 the max. time value.
    */
    int hour, minute, second;

    /**
     * GUI Label attached to the clock, used to represent time values.
    */
    final JLabel label;

    /**
     * Behaviour control variable.
     * 
     * Clock transits between "running/active", "paused" and "stopped" states.
     * In each state, Clock executes a different set of operations.
     * - Running: paused is FALSE, stopped is FALSE.
     * - Paused: paused is TRUE, stopped is FALSE.
     * - Stopped: stopped is TRUE (paused value is irrelevant).
     * 
     * This variable indicates if clock is in 'paused' state.
    */
    boolean paused;
    
    /**
     * Behaviour control variable.
     * 
     * Clock transits between "running/active", "paused" and "stopped" states.
     * In each state, Clock executes a different set of operations.
     * - Running: paused is FALSE, stopped is FALSE.
     * - Paused: paused is TRUE, stopped is FALSE.
     * - Stopped: stopped is TRUE (paused value is irrelevant).
     * 
     * This variable indicates if clock is in 'stopped' state.
    */
    boolean stopped;

    /**
     * Textual representation of the time value -hour, minute and seconds-. 
    */
    String clockToPrint;

    /**
     * Modifies the textual representation of the time value. 
     * 
     * It is used as a graphic effect trigger while clock is running:
     * - When FALSE, colons are printed between the components 00:00:00
     * - When TRUE, colons are not printed between components 00 00 00
    */
    boolean clockToPrintBlink;
    
    /* CONSTRUCTORS */

    /**
     * Default constructor.
     *
     * All variables are initialized to:
     * - Zero.
     * - Null.
     * - False.
    */
    public GenericClock(){
        this.hour = 0;
        this.minute = 0;
        this.second = 0;

        this.label = null;    /* No label assigned to the clock. */

        this.paused = true;
        this.stopped = true;
        
        this.clockToPrintBlink = false;
    }

    /**
     * Creates Clock with initial time value and assigned GUI label.
     *
     * Time value is hour:minute:second (i.e: 12:20:34).
     *
     * @param hour hour value (min. value 0; max. value 23).
     * @param minute minute value (min. value 0; max. value 59).
     * @param second seconds value (min. value 0; max. value 59).
     * @param label GUI label to be attached to the clock.
    */
    public GenericClock (int hour, int minute, int second, JLabel label) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

        this.label = label;

        this.paused = true;
        this.stopped = true;
        
        this.clockToPrintBlink = false;
    }
   
    /**
     * Creates Clock that matchs the System Time.
     * 
     * Initial time value is equal to System Time of the local machine. It has
     * attached a label too.
     * 
     * @param label label to be attached to the clock.
    */
    public GenericClock (JLabel label) {
        /* Obtain the current system time. */
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        /* Initialization to the System Time */
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        this.label = label; 

        this.paused = true;
        this.stopped = true;
        
        this.clockToPrintBlink = false;
    }

    /* METHODS */
    
    /**
     * Core functionality of GenericClock.
     *
     * It implements the loop operations executed by the Clock. 
     * 
     * @return time value.
     * @throws Exception SwingWorker exception.
     * @see SwingWorker
     * @see SwingWorker#doInBackground()
    */
    @Override
    protected Integer doInBackground() throws Exception {
        /* Infinity loop: clock works as long as the application is running. */
        while (1==1) {
            /*
             * In order to reproduce the behaviour of a real clock,
             * the SwingWorker waits one second before execute its operations.
             * This could be done using Java Timers, but considering
             * current complexity and application needs,
             * Thread "sleep" operation is finally chosen.
            */
            Thread.sleep(1000);

            /* GenericClock only works if its state is not stopped. */
            if (this.stopped == false) {
                if (this.paused == false) {  
                    this.updateClock();
                    label.setText(this.printClock());
                }
            }
        }
    } 
    
    /**
     * Updates clock, increasing the second counter by one.
     * 
     * Basic operation of GenericClock. It updates the time value by one second,
     * working as a normal clock. When time value reachs its max. value, it
     * returns to the min. value (hour in digital format).
     * - Max. value: 23:59:59
     * - Min. value: 00:00:00
    */
    protected void updateClock() {
        this.second ++;
        if (this.second == 60) {
            this.second = 0;
            this.minute ++;
            if (this.minute == 60) {
                this.minute = 0;
                this.hour ++;
                if (this.hour == 23) {
                    this.hour = 0;
                }
            }
        }
    }

    /**
     * Prints time value in the attached label.
     * 
     * Time value is parsed to a String, in order to print it in the attached
     * label. Blinking effect is performed. Each component -hour, minute, second
     * - is printed in a two digit format. I.e: 03:20:21
     * 
     * @return time value in String format.
    */
    protected String printClock() {
        if (this.clockToPrintBlink == false) {    /* "Blinking" effect is off.*/
            clockToPrint = String.format(
                    "%02d:%02d:%02d", this.hour, this.minute, this.second);
            this.clockToPrintBlink = true;
        }
        else {    /* If "blinking" effect is on.*/
            /* Colon chars are not visible now.  */
            clockToPrint = String.format(
                    "%02d %02d %02d", this.hour, this.minute, this.second);
            this.clockToPrintBlink = false;
        }    
        return clockToPrint; 
    }

    /**
     * Pauses clock.
     * 
     * Set 'paused' to True.
     * 
     * @see #paused
    */
    public void pauseClock() {
        this.paused = true;
    }

    /**
     * Starts clock.
     * 
     * Sets 'paused' and stopped to False.
     * 
     * @see #paused
     * @see #stopped
    */
    public void startClock() {
        this.paused = false;
        this.stopped = false;
    }
    
    /**
     * Stops the clock.
     * 
     * Sets 'stoppe'd to True. 'pauseClock()' method is executed too for safety.
     * Time value is restarted to zero.
     * 
     * @see #stopped
     * @see #pauseClock() 
    */
    public void stopClock() {
        this.pauseClock();
        this.stopped = true;
      
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }
}
