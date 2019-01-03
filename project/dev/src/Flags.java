/*
 * Proyect:     ERMON.
 * File:        Flags.java
 * Description: Several Enum descriptions, intented to trigget
 *              specific operations in methods developed to works as
 *              'generic' ones.
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

/**
 * Several Enum type descriptions to be used as configuration flags.
 * 
 * These enumerations are used to trigger specific actions in method or classes
 * developed as 'generic' units where several execution paths can take place.
*/
public class Flags {
    /**
     * Clock types of the application.
     * 
     * - SYSTEM_TIME: Matches the internal PC clock.
     * - WORKED_TIME: How many seconds the application is 
     *                  scheduling/deploying events.
     * - EVENT_TIME: Controls the events duration and periods.
    */
    public enum ClockType {SYSTEM_TIME, WORKED_TIME, EVENT_TIME}
    
    /**
     * Information types in the application.
     * 
     * - ABOUT: Miscellaneous information about the app. and related fields,
     *          like Blogs and Online resources.
     * - EVENTS: Events data, both default and custom (title, duration, etc).
    */
    public enum InformationType {ABOUT, EVENTS}
    
    /**
     * Event types in the application.
     * 
     * - PERIODICAL: It is repeatedly executed from time to time (period).
     * - SINGLE: It is executed once each 24 hours (specific execution hour).
    */
    public enum EventType {PERIODICAL, SINGLE}
    
    /**
     * Behavior of the Creation Window.
     * 
     * - SAVE: saves the created events in a file for further use.
     * - ADD: add the created events to the list of events being handled 
     * in execution time.
    */
    public enum CreationWindowMode {SAVE, ADD}
}
