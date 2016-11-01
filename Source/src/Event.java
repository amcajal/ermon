/*
 * Proyect:     ERMON.
 * File:        Event.java
 * Description: Implements an Event, an operation that takes place
 *              in time and has certain detailes attached to it, like
 *              duration, description and period.
 * Java:        JDK 7
 * Contact:     Alberto Martin Cajal <amartin.glimpse23@gmail.com>
 * Website:     https://github.com/amcajal/ermon
 * Copyrigth:   GNU General Public License, version 3.0.
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

/**
 * Activity to be scheduled and deployed during the application execution.
 *
 * An event is an action -like stand up or walk- that takes place in a certain
 * time, with details attached to it like description, duration and period.
 * Event objective is to reduce or avoid health issues related to long periods
 * of computing use.
*/
public class Event {
    /* CLASS VARIABLES */
    
    /** 
     * Title of the event, short and accurate. 
    */
    String title;
    
    /**
     * Detailed description of the event.
    */
    String description;  
    
    /**
     * Time -in seconds- it takes to repeat the event.
    */
    int period;  
    
    /**
     * Duration -in seconds- of the event. 
    */
    int duration;    
    
    /**
     * Remaining time -in seconds- until event starts.
     * 
     * This variable is used to control the execution
     * of the events (when it reaches 0, it means that the event has fulfilled
     * another iteration of its period, and must be launched).
    */    
    int timeToLaunch; 

    /**
     * Establishes if the event shall be executed only at a certain time.
     * 
     * If 'true', event period is 24 hours, meaning that it only fires
     * once each 24 hours.
    */
    boolean startingTime;    /* True if the event occurs just once per day. */

    /**
     * Decomposition of the 'startingTime' in hours, minutes and seconds.
     * 
     * Decomposition in 24 hour digital format. Minimal value is 0:0:0 
     * and maximun is 23:59:59.
    */
    int startingHour, startingMinute, startingSecond;

    /* CONSTRUCTORS */
    
    /**
     * Creates an Event.
     * 
     * @param title title of the event.
     * @param description description of the event.
     * @param period in seconds, period of the event (how often it occurs).
     * @param duration in seconds, duration of the event.
     * @param startingTime True if event shall start at a specific time.
     * @param startingHour specific starting hour (0 to 23).
     * @param startingMinute specific starting minute (0 to 59).
     * @param startingSecond specific starting second (0 to 59).
    */
    public Event(String title, String description,
            int period, int duration,
            boolean startingTime,
            int startingHour, int startingMinute, int startingSecond) {

        this.title = title;
        this.description = description;
        this.period = period;
        this.duration = duration;

        this.startingTime = startingTime;
        this.startingHour = startingHour;
        this.startingMinute = startingMinute;
        this.startingSecond = startingSecond;

        /*
         * 'timeToLaunch' has a max. value equal to the event's period.
         * Difference is that 'timeToLaunch' is updated, while period value
         * remains static.
         */
        this.timeToLaunch = this.period;
    }
    
    /**
     * Creates event from an existing one.
     * 
     * The created event is a copy of the one passed as argument.
     * 
     * @param e original event to be copied in the created one. 
    */
    public Event (Event e) {
        this.title = e.getTitle();
        this.description = e.getDescription();
        this.period = e.getPeriod();
        this.duration = e.getDuration();

        this.startingTime = e.getStartingTime();
        this.startingHour = e.getStartingHour();
        this.startingMinute = e.getStartingMin();
        this.startingSecond = e.getStartingSecond();
        
        this.timeToLaunch = this.period;
    }

    /* METHODS */
    
    /**
     * Decreases TimeToLaunch (TTL) value in one unit.
     * 
     * TimeToLaunch represents the number of seconds until the event shall
     * be fired. This method decreases its value in one unit, simulating the
     * pass of one second.
    */
    public void decreaseTTL() {
        this.timeToLaunch = this.timeToLaunch - 1;
    }

    /**
     * Restarts 'timeToLaunch' to its initial value, equal to event's period.
     * 
     * 'timeToLaunch' value get restarted each time it reachs 0 value (thats it,
     * each time the event is fired, meaning another period iteration has been
     * fullfiled).
    */
    public void restartTimeToLaunch() {
        this.timeToLaunch = this.period;
    }

    /* GETTERS AND SETTERS */

    /**
     *
     * @return title of the event.
    */
    public String getTitle() {
        return this.title;
    }

    /**
     *
     * @return period of the event.
    */
    public int getPeriod() {
        return this.period;
    }

    /**
     *
     * @return duration of the event.
    */
    public int getDuration() {
        return this.duration;
    }

    /**
     *
     * @return 'timeToLaunch' value.
    */
    public int getTimeToLaunch() {
        return this.timeToLaunch;
    }

    /**
     *
     * @return description of the event.
    */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @return true if event has a starting time.
    */
    public boolean getStartingTime() {
        return this.startingTime;
    }

    /**
     *
     * @return starting hour value.
    */
    public int getStartingHour() {
        return this.startingHour;
    }

    /**
     *
     * @return starting minute value.
    */
    public int getStartingMin() {
        return this.startingMinute;
    }

    /**
     *
     * @return starting second value.
    */
    public int getStartingSecond() {
        return this.startingSecond;
    }

    /**
     * Modifies 'timeToLaunch' value.
     *
     * @param currentTime value to be assigned to 'timeToLaunch'.
    */
    public void setTimeToLaunch (int currentTime) {
        this.timeToLaunch = currentTime;
    }
 
    /**
     * Modifies event's period value.
     * 
     * @param period value to be assigned to the period.
    */
    public void setPeriod (int period) {
        this.period = period;
    }
}
