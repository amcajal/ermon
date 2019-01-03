/*
 * Proyect:     ERMON.
 * File:        ConfigLoader.java
 * Description: Implements the access to the configuration variables,
 *              and performs the loading operations of the events in the
 *              EventClock.
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

import java.util.ArrayList;    /* To use ArrayList data structures. */

/**
 * Contains the set of events to be loaded in the EventClock, and behaviour
 * control variables - for example, play sound at pop-ups-.
 *
 * This class give access to the configuration variables, and executes the
 * loading process of the eventes in the EventClock.
 */
public class ConfigLoader {
    /* CLASS VARIABLES */
    
    /**
     * List of events to be scheduled/deployed.
     * 
     * Events in the list will be the ones loaded in the EventClock, and thus,
     * scheduled and deployed during its working time (showed in the pop-ups,
     * and so on).
    */
    ArrayList<Event> eventList;

    /**
     * Establishes if sound shall be played when pop-ups appear.
     * 
     * If true, when pop-up appears a simple sound shall be played.
    */
    boolean playSound;    
    
    /**
     * Establishes if pop-up shall be brought to the front when appears.
     * 
     * If true, when pop-up appears it shall be brought to foreground.
    */
    boolean popUpInFront;   
    
    /**
     * Establish behaviour of clocks when Pause button is pressed.
     * 
     * If true, when Pause button is pressed, both Event Clock and Worked Time
     * clocks are paused. If false, only Event Clock is paused, while Worked
     * Time clock continues executing its operations.
    */
    boolean pauseClocks;


    /* CONSTRUCTORS. */

    /**
     * Creates configuration initialized with default values.
    */
    public ConfigLoader() {
        eventList = new ArrayList<>();
        
        playSound = true;
        popUpInFront = true; 
        pauseClocks = true;
    }

    /* METHODS */

    /**
     * Creates and loads the set of default events.
     *
     * Default set of events are hardcoded and are always available in the
     * application. They have been designed following ergonomic researchs.
    */
    public void loadDefaultEvents() {
        
        /* List shall be clear from previous loads. */
        if (!this.eventList.isEmpty()) {
            this.eventList.clear();
        }

        /* Default events. */
        
        this.eventList.add(new Event("Stretch wrists, neck, back and shoulders",
                "Stretch wrist, neck and back. Do 5 to 10 repetitions each"
                + " or 15 to 30 seconds each. Do shoulder circles, shrugs and"
                + " pinches, each 1 to 3 times.",
                1800, 120, false,
                0, 0, 0));

        this.eventList.add(new Event("Stand up and walk",
                "Stand up and walk a little, with your head "
                        + "and neck straight."
                + "Do stretch exercises while walking"
                        + " (lower back, chest, neck, legs)",
                3600, 300, false,
                0, 0, 0));

        this.eventList.add(new Event("Refresh your eyes",
                "Look away from the screen for 1 or 2 minutes "
                        + "to a more distant"
                + " scene (7 meters at least). Blink your eyes rapidly"
                        + " for a few seconds"
                + " and cover them with your palms for 10 to 15 seconds."
                + "Close your eyes tightly and roll them.",
                900, 180, false,
                0, 0, 0));

        this.eventList.add(new Event("Long break",
                "Take a long break, going away from the work place."
                + " Take deep breaths, drink water, eat a little snack,"
                + " go outside under the sun if possible, and still stand.",
                7200, 900, false,
                0, 0, 0));
        
        /*
         * Use the following code snippet to load a set of custom events
         * with very low statistics (in order to test any modification
         * performed to the application; the events has very small periods
         * and durations, so the application moves from one state to another
         * very quickly).
        */
        
        /*
            eventList.add(new Event("Rub your eyes", 
                    "Rub your eyes for 20 seconds",
                    20, 20, false,
                    0, 0, 0));

            eventList.add(new Event("Walk", "Walk 10 minutes",
                    10, 10, false,
                    0, 0, 0));

            eventList.add(new Event("Strecht", "Strecht your back",
                    15, 15, false,
                    0, 0, 0));
        */ 
    }

    /**
     * Loads a set of events created by the user (customized ones).
     *
     * Custom events has been created previously and stored in a valid
     * configuration file.
     *
     * @param customEventList list of custom events to be loaded.
    */
    public void loadCustomEvents(ArrayList<src.Event> customEventList) {
        /* List shall be clear from previous loads. */
        if (!this.eventList.isEmpty()) {
            this.eventList.clear(); 
        }
        for (Event e : customEventList) {
            this.eventList.add(new Event(e));
        }
    }

    /* GETTERS AND SETTERS */

    /**
     * 
     * @return copy of the list of events.
    */
    public ArrayList<Event> getEventList() {
        return this.eventList;
    }

    /**
     *
     * @return playSound value.
    */
    public boolean getPlaySound() {
        return this.playSound;
    }

    /**
     *
     * @return popUpInFront value.
    */
    public boolean getPopUpInFront() {
        return this.popUpInFront;
    }
    
    /**
     * 
     * @return pauseClocks value. 
    */
    public boolean getPauseClocks() {
        return this.pauseClocks;
    }

    /**
     * Sets playSound value.
     *
     * @param playSound value to assign to playSound variable.
    */
    public void setPlaySound(boolean playSound) {
        this.playSound = playSound;
    }

    /**
     * Sets popUpInFront value.
     *
     * @param popUpInFront value to assign to playSound variable.
    */
    public void setPopUpInFront (boolean popUpInFront) {
        this.popUpInFront = popUpInFront;
    }
    
    /**
     * Sets pauseClocks value.
     * 
     * @param pauseClocks value to assign to the variable.
    */
    public void setPauseClocks(boolean pauseClocks) {
        this.pauseClocks = pauseClocks;
    }
}
