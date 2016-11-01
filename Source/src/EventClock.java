/*
 * Proyect:     ERMON.
 * File:        EventClock.java
 * Description: EventClock class implements the methods that controls
 *              the schedule, deployment and behaviour of the Events, like
 *              pop-up creation and ignorig-execution events execution.
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

import gui.GenericPopUp;    /* To create Event Pop-Ups. */
import java.util.ArrayList;    /* To use ArrayList data structure. */

/* To retrieve System Date and Time. */
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Graphic operations. */
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.border.TitledBorder;

/**
 * GenericClock that controls the schedule and deploymend ot the Events.
 * 
 * EventClock extends GenericClock class. It implementes a set
 * of methods specially designed to handle the events, like pop-up creation
 * and ignoring-forcing events execution.
*/
public class EventClock extends GenericClock {
    
    /*
     * CAPTION:
     * SXE = Single eXecution Event.
     * PXE = Periodical eXecution Event.
    */

    /* CLASS VARIABLES */

    /**
     * List of events with periodical execution.
     * 
     * Events in this list are executed several times in a day. Its periods
     * are usually very small (avg. 15 min).
    */
    ArrayList<Event> periodExecutionEventList;

    /**
     * List of events with a single execution (fixed time of execution).
     * 
     * Events in this list has 'startingTimes' of execution, meaning they only
     * executes at a certain time. Their periods are equal to 24 hours.
    */
    ArrayList<Event> singleExecutionEventList;
    
    /**
     * List of events created in execution time (while app is 'working').
     * 
     * By 'working' shall be understand the state of the application between
     * the first Play button pressing and the Stop button pressing. This allows
     * user to add events to be deployed and scheduled without stopping the
     * application and loading a different set of events.
    */
    ArrayList<Event> newAddedEvents;

    /**
     * List of event IDs to be fired inmediately, of both types.
     * 
     * When updating the event timers, a situation when several
     * Events shall start at the same time its possible (when timeToLaunch'
     * reaches 0). The list stores both types of events 
     * (single and periodical execution). IDs are stored instead of Events
     * to use less resources (integers are handled in a easier way).
    */
    ArrayList<Integer> eventsToLaunch;

    /**
     * List of 'periodicalExecutionEvents' with the smallest 'timeToLaunch'.
     * 
     * These events contains the smallest time to launch, and thus, will be
     * the next ones to be fired (as soon as their time to launch reachs 0).
    */
    ArrayList<Integer> nextPXE;

    /**
     * List of 'singleExecutionEvents' with the smallest 'timeToLaunch'.
     * 
     * These events contains the smallest time to launch, and thus, will be
     * the next ones to be fired (as soon as their time to launch reachs 0).
    */
    ArrayList<Integer> nextSXE;

    /**
     * Second label attached to this clock, used to provide feedback about 
     * events status.
     * 
     * It is modified by the clock operations. 
    */
    JLabel eventLabel;

    /**
     * Pop-up to show information about events.
     * 
     * Permanent pop-Up, hidden or shown, with the
     * information about:
     * - Next PXE to be deployed OR current PXE in progress.
     * - Single execution events.
    */
    GenericPopUp informationPopUp;

    /**
     * Internal clock counters.
     * 
     * - 'timeToNextEvent' controls remain seconds to the start of next event.
     * - 'timeToEventEnd' controls remain seconds to the end of current active
     * events (its value concur with the biggest duration of the active events).
    */
    int timeToNextEvent, timeToEventEnd;

    /**
     * Summarized textual data about loaded SXE.
     * 
     * This information will be shown always in the 'eventPopUp' (it is 
     * permanent information that can be checked when pressing 'see' button
     * in MainWindow).
    */
    String singleExecutionInformation;

    /**
     * Flag to indicate if there are actually events in progress. 
    */
    boolean eventInProgress; 

    /**
     * MIDI sound (file) handler.
    */
    SoundLoader soundLoader; 

    /**
     * Pop-up behaviour control variables.
     * 
     * Controls the visibility of the current active pop-up.
    */
    boolean isPopUpVisible;
    
    /**
     * Pop-up behaviour control variable.
     * 
     * Controls if sound shall be played when pop-ups appear.
    */
    boolean playSound;
    
    /**
     * Pop-up behaviour control variable.
     * 
     * Controls if pop-up shall apear in front or in background.
    */
    boolean popUpInFront;
    
    /* CONSTRUCTORS */

    /**
     * Initializes EventClock.
     * 
     * EventClock needs two labels: one to print time values, and the other to
     * print information about the events (next events or current events).
     * 
     * @param timeLabel label to print time values (hour, minutes and seconds).
     * @param eventLabel label to print information about the event or events.
    */
    public EventClock (JLabel timeLabel, JLabel eventLabel) {
        /*
         * Call to GenericClock constructor, initializing time variables to 0
         * and getting the 'printing time' label assigned.
        */
        super(0, 0, 0, timeLabel);

        /* Initialization of class variables. */
        this.eventsToLaunch = new ArrayList<>();
        this.singleExecutionEventList = new ArrayList<>();
        this.periodExecutionEventList = new ArrayList<>();
        this.newAddedEvents = new ArrayList<>();
        this.nextPXE = new ArrayList<>();
        this.nextSXE = new ArrayList<>();
        this.timeToNextEvent = 0;
        this.timeToEventEnd = 0;
        this.singleExecutionInformation = "";
        this.eventInProgress = false;
        this.isPopUpVisible = false;
        this.eventLabel = eventLabel;    /* 'Event info' assigned. */

        /* Default configuration is set when EventClock is initialized:
         * - A midi melody is played when pop-ups appear.
         * - Pop-ups are brought to foreground.
        */
        soundLoader = new SoundLoader();
        this.playSound = true;
        this.popUpInFront = true;

        /* Initialize pop-up. */
        this.informationPopUp = new GenericPopUp();
        
        /* By default, this message is printed in the SXE information tab. */
        this.informationPopUp.setSXEInfo("No Single Execution Events loaded");
    }

    /* METHODS */
    
    /**
     * Loads the configuration into the EventClock.
     * 
     * Configuration is composed by:
     * - Set of events to schedule an deploy.
     * - Environment behaviour control options (paying sounds, position of the
     * pop-ups and behaviour of the Working Time Clock).
     * 
     * @param configuration configuration to be loaded of ConfigLoader type.
    */    
    public void loadConfiguration (ConfigLoader configuration) {
        
        /* Iterate over the events, and store them in the proper list. */ 
        for (Event e : configuration.getEventList()) {
            /* 
             * new Event(e) operationes are performed 
             * to avoid pass by reference. 
            */
            if (e.startingTime == true) {
                this.singleExecutionEventList.add(new Event(e));
            }
            else {
                this.periodExecutionEventList.add(new Event(e));
            }
        }
        
        /* Apply configuration chosen by the user. */
        this.playSound = configuration.getPlaySound();
        this.popUpInFront = configuration.getPopUpInFront();
        
        /* Once all events are loaded, process the SXE ones. */
        if (!this.singleExecutionEventList.isEmpty()) {
            this.generateSingleExecutionInformation();
            this.calculateSingleExecutions();
        }
 
        /*
         * After Events are loaded, search the First event to be deployed,
         * in order to initialize the clock values and put them to work.
         * In this case, "searchNextEvent" method
         * can be seen as "search first event that will be fired"
        */        
        this.searchNextEvent();
    }

    /**
     * Generates textual summary about the Single Execution Events loaded.
     * 
     * Summary text is composed by events starting hours and titles.
    */
    private void generateSingleExecutionInformation() {
        /* Clear target string before generate again the information. */
        this.singleExecutionInformation = "";

        String auxTime = "";

        for (Event e : this.singleExecutionEventList) {            
            auxTime = String.format("%02d:%02d:%02d", e.getStartingHour(), 
                    e.getStartingMin(), e.getStartingSecond());

            this.singleExecutionInformation =
            this.singleExecutionInformation.concat("At " + auxTime
            + " -->" + e.getTitle() + "\n");
        }

        /* Update the pop-up. */
        this.informationPopUp.setSXEInfo(this.singleExecutionInformation);
    }

    /**
     * Updates event 'timeToLaunch' value.
     * 
     * Events to be updated are specified by input parameter. Update operation
     * consist in decrease 'timeToLaunch' value by one -one less second to
     * the start of the event-. If an event reachs value zero, it is added
     * to 'eventsToLaunch' list.
     * 
     * @param eventType type of events to be updated (specifides the list of
     *                  events to be iterated).
    */    
    private void updateEvents(Flags.EventType eventType) {
        int index = 0;   
        
        /*
         * Local copy to iterate over the selected events, and return
         * then the modified values to its original list.
        */        
        ArrayList<Event> auxEventList;
        
        /*
         * Before events update, the "eventsToLaunch" list is cleared.
         * If a method shall start, it is added inmediately to the list
         * and then "triggerEvent()" method is called. In the next call
         * to the method (or in the call to updateSingleExecutionEvents)
         * the list shall be clear in order to not mix events from previous
         * calls.
        */        
        this.eventsToLaunch.clear();

        if (eventType == Flags.EventType.SINGLE) {
            auxEventList = new ArrayList<>(this.singleExecutionEventList);
        }
        else {    /* eventType == Flags.EventType.PERIODICAL.*/
            auxEventList = new ArrayList<>(this.periodExecutionEventList);
        }

        /* For each event in the copied list, update 'timeToLaunch' 
         * -decreasing its value- and check it event shall be launched.
        */
        for (Event event : auxEventList) {
            event.decreaseTTL();

            /* 
             * If "timeToLaunch" has reached 0, the event must start. 
             * Values below 0 are allowed too, in order to avoid possible
             * situations where the decreasing operation happens twice.
            */
            if (event.getTimeToLaunch() <= 0) {
                this.eventsToLaunch.add(index);
                
                /* Restart the "timeToLaunch" to its maximum value. */
                event.restartTimeToLaunch();
            }       
            
            index ++;
        }

        /* Put modified list of events back in their sources. */
        if (eventType == Flags.EventType.SINGLE) {
            this.singleExecutionEventList.clear();
            this.singleExecutionEventList.addAll(auxEventList);
        }
        else {    /* eventType == Flags.EventType.PERIODICAL.*/
            this.periodExecutionEventList.clear();
            this.periodExecutionEventList.addAll(auxEventList);
        }

        /* If there are events in the "eventsToLaunch" list, launch them. */
        if (!this.eventsToLaunch.isEmpty()) {
            this.triggerEvent(eventType); 
        }
    }
    
    /**
     * Executes operations related to the start of an event or events.
     * 
     * Method triggers both visual operations (showing the pop-up) and
     * logical operations, as status changes.
     * 
     * @param eventType type of event being started.
    */
    private void triggerEvent(Flags.EventType eventType) {

        if (eventType == Flags.EventType.SINGLE){
            /* Obtain information of the SXE being executed and set to pop-up.*/
            String sxeInProgressInfo = this.getSXEInfo();
            GenericPopUp sxePopUp =
                    new GenericPopUp(sxeInProgressInfo);
            sxePopUp.setVisible(true);
            this.searchNextEvent();
        }
        else {    /* eventType == Flags.EventType.PERIODICAL.*/

            this.eventInProgress = true; 

            /*
             * "lastEventTime" is used to store the duration of the event
             * with the longest duration. This value is used to establish
             * how many seconds the "waitEventEnd" state will last -that
             * is, the "timeToEventEnd" variable.
            */            
            int lastEventTime = 0;

            this.timeToEventEnd = 0;

            /*
             * Search for the longest event duration iterating over
             * the list of events that shall be deployed inmediately.
            */            
            for (Integer index: this.eventsToLaunch) {
                lastEventTime =
                        this.periodExecutionEventList.get(index).getDuration();
                
               if (lastEventTime >= this.timeToEventEnd) {
                    this.timeToEventEnd = lastEventTime;
                }
            }
           
            /* Makes user aware of the event being executed. */
            this.updateLabels();
            label.setForeground(Color.blue);       
            this.setClock(this.timeToEventEnd);       
            this.setPXEInfo();
            this.showPopUp();
        }
        
        /* Play sound is common for both types of pop-up. */
        if (this.playSound) {
            this.soundLoader.playSound();
        }
    }

    /** 
     * Sends to pop-up information regards to the Periodical Execution Events.
     * 
     * Text format depends on the status of the events:
     * - If there are events currently in progress, these are shown.
     * - If there are no events in progress, next ones to be executed are shown.
    */
    private void setPXEInfo() {
        String toDo = "";

        this.informationPopUp.setTitle("EVENTS INFORMATION");

        if (this.eventInProgress == false) {
            toDo = toDo.concat("NEXT TO DO...\n===============\n");
            
            for (Integer index: this.nextPXE) {
                toDo = toDo.concat("    >>> "
                        + this.periodExecutionEventList.get(index).getTitle()
                        + ":\n");

                toDo = toDo.concat("        "
                        + this.periodExecutionEventList.get(index).getDescription()
                        + "\n");
            }
        }
        else {    /* eventInProgress == true.*/
            toDo = toDo.concat("EVENTS IN PROGRESS...\n====================\n");
         
            for (Integer index: this.eventsToLaunch) {
                toDo = toDo.concat("    >>> "
                        + this.periodExecutionEventList.get(index).getTitle()
                        + ":\n");

                toDo = toDo.concat("        "
                        + this.periodExecutionEventList.get(index)
                        .getDescription() + "\n");
            }
        }

        this.informationPopUp.setPXEInfo(toDo);
    }
    
    /**
     * Obtain information about the SXE being executed.
     *
     * @return textual information about the SXE being executed.
    */
    private String getSXEInfo() {
        String toDo = "";
        String formatTime = "";
        Event auxEvent;

        toDo = "SINGLE EXECUTION EVENT STARTED \n ==========================\n";

        for (Integer index : this.eventsToLaunch) {
            auxEvent = this.singleExecutionEventList.get(index);
            
            formatTime = String.format("%02d:%02d:%02d", 
                    auxEvent.getStartingHour(), 
                    auxEvent.getStartingMin(), auxEvent.getStartingSecond());
            
            toDo = toDo.concat(
                    "    >>> " + auxEvent.getTitle()+ ":\n"
                    + "STARTED AT: " + formatTime + "\n"
                    + "DESCRIPTION:\n" + auxEvent.getDescription());
        }
        return toDo;
    }

    /**
     * Make the pop-up visible with the information about the events.
     * 
     * Pop-up shall appear in frontground or background depends on
     * the user selected configuration.
    */
    public void showPopUp() {
        this.informationPopUp.setDefaultTab();
        /* If the pop-up is not visible, bring it to front. */
        if (!this.informationPopUp.isVisible()) {
            this.informationPopUp.setVisible(true);   
        }
        
        if (this.popUpInFront == true) {
            this.informationPopUp.toFront();
            this.informationPopUp.repaint();
            this.informationPopUp.setFocusable(true);
        }
        else {
            this.informationPopUp.setState(java.awt.Frame.ICONIFIED);
            this.informationPopUp.toBack();
        }
        
    }

    /**
     * Hide the pop-up.
    */
    private void closePopUp() {
        if (this.informationPopUp.isVisible()) { 
            this.informationPopUp.setVisible(false);
        }
        /*
         * Sound resources are released as soon as the pop-up is closed,
         * using them the less time possible.
        */
        this.soundLoader.freeSoundResources();
    }

    /**
     * Search the next events to be deployed.
     * 
     * Events with shortest 'timeToLaunch' are the next ones in the 'queue'
     * to be deployed.
    */
    private void searchNextEvent() {
        int shortestPXE;    /* PXE with the shortest 'timeToLaunch'. */
        int shortestSXE;    /* SXE with the shortest 'timeToLaunch'. */
        int index = 0;    /* Auxiliar index to iterate over the events. */

        /* Obtain the shortest time from both event type list. */
        shortestPXE = this.searchShortestEvent(this.periodExecutionEventList);
        shortestSXE = this.searchShortestEvent(this.singleExecutionEventList);

        /* Compare them and obtain the shortest time */
        if (shortestPXE <= shortestSXE) {
            this.timeToNextEvent = shortestPXE;
        }
        else {
            this.timeToNextEvent = shortestSXE;
        }
        
        /*
         * 'timeToNextEvent' concurs with the shortest 'timeToLaunch'.
         * This value is set into the events clock, in order to depict
         * the remain seconds until the next event starts.
        */
        this.setClock(this.timeToNextEvent);

        /* Clean 'next Event' lists. */
        if (!this.nextSXE.isEmpty()) {
            this.nextSXE.clear();
        }

        if (!this.nextPXE.isEmpty()) {
            this.nextPXE.clear();
        }

        /*
         * Count how many events share the same 'timeToLaunch' and add them
         * to the proper 'nextEvent' list.
        */
        for (Event event: this.periodExecutionEventList) {
            if (event.getTimeToLaunch() == this.timeToNextEvent) {
                this.nextPXE.add(index);
            }
            index++;
        }
        
        index = 0;    /* Refresh index.*/
        
        /* Same operation, now with simple execution events. */
        for (Event event: this.singleExecutionEventList) {
            if (event.getTimeToLaunch() == this.timeToNextEvent) {
                this.nextSXE.add(index);
            }
            index++;
        }

        /* Update labels and pop-up information. */
        this.updateLabels();
        this.setPXEInfo();
    }

    /**
     * Updates time label and event label to depict current situation.
     *
     * Text of both labels is updated, showing summarized information about:
     * - Events to be deployed (time and number).
     * - Current events in progress (time and number).
    */
    private void updateLabels() {
        if (this.eventInProgress == true) {
            TitledBorder timeBorder = (TitledBorder) label.getBorder();
            timeBorder.setTitle("Event in progress");
            
            /* Event Label text depends on how many events are in progress. */
            if (this.eventsToLaunch.size() <= 1) {
                eventLabel.setText("In progress: " +
                        this.periodExecutionEventList
                        .get(this.eventsToLaunch.get(0)).getTitle());
            }
            else {
                eventLabel.setText("In progress (" +
                    this.eventsToLaunch.size() + ")");
            }
        }
        else {
            TitledBorder timeBorder = (TitledBorder) label.getBorder();
            timeBorder.setTitle("Next event in");

            /* Total events of both type with same minimal timeToLaunch. */
            int totalNextEvents = this.nextPXE.size() + this.nextSXE.size();

            /*
             * If there is only one event with the min. 'timeToLaunch', its
             * data will be printed in the label.
            */
            if (totalNextEvents <= 1) {
                if (this.nextPXE.isEmpty()) {
                    eventLabel.setText("Next: " +
                        this.singleExecutionEventList
                        .get(this.nextSXE.get(0)).getTitle());
                }
                else {
                    eventLabel.setText("Next: " +
                        this.periodExecutionEventList
                        .get(this.nextPXE.get(0)).getTitle());
                }
            }
            else {
                this.eventLabel.setText("Next ("
                        + totalNextEvents + " events)");
            }
        }
    }

    /**
     * Searchs in the specified list the event with shortest 'timeToLaunch'.
     *
     * @param listOfEvents list of events to iterate over.
     * @return event with the shortest 'timeToLaunch'.
    */
    private int searchShortestEvent(ArrayList<Event> listOfEvents){
        /*
         * This auxiliar value is used just as first value to be compared
         * Because the maximun period of an event is 24 hours (86400 seconds)
         * its safe to set the "timeToNextEvent" initially to 10000 seconds,
         * because all events will be under that value.
        */
        int auxTimeToNextEvent = 10000;

        /* Search the shortest value. */
        for (Event event: listOfEvents) {
            if (event.getTimeToLaunch() <= auxTimeToNextEvent) {
                auxTimeToNextEvent = event.getTimeToLaunch();
            }
        }
        return auxTimeToNextEvent;
    }
   
    /**
     * Establish clock time.
     * 
     * Clock is set to a certain hour, minute and second. This time
     * is represented by the equivalent amount of seconds.
     * 
     * @param seconds number of seconds that represents the clock time.
    */
    private void setClock (int seconds) {
        /*
         * Hours per second = duration / 3600.
         * Minutes per seconds = (duration % 3600) / 60.
         * Remain seconds = (duration % 3600) % 60.
        */
        this.hour = seconds / 3600;
        this.minute = (seconds % 3600) / 60;
        this.second = (seconds % 3600) % 60;
    }
  
    /**
     * Decrease 'timeToEventEnd' value by one until it reaches 0.
     * 
     * When 'timeToEventEnd' reachs 0 value, the method 'endEvent' is executed.
    */
    private void waitEventEnd() {
        if (this.timeToEventEnd > 0) {
            this.timeToEventEnd --; 
        }
        else { 
            this.endEvent(); 
        }
    }

    /**
     * Apply changes to clock in order to make the end of an event effective.
     *
     * This method restart several variables and give visual feedback about the
     * completion of the events in progress.
    */
    private void endEvent() {
        this.timeToEventEnd = 0;
        this.eventInProgress = false;
        this.searchNextEvent();

        /* Visual feedback about the completion of the events in progress. */
        this.closePopUp();
        label.setForeground(Color.black);

        /* Create a new border. */
        TitledBorder titleBorder = (TitledBorder) label.getBorder(); 
        titleBorder.setTitle("Next Event in");
        label.setBorder(titleBorder);
    }
    
    /**
     * Updates EventClock time, decreasing its value.
     * 
     * Update operation decreases time value by one second. EventClock time
     * represents remaining seconds to the starting of an event, so it shall
     * be decreased over time.
     * This method overrides the functionality of 'updateClock()' method 
     * from GenericClock class.
     * 
     * @see GenericClock
     * @see GenericClock#updateClock() 
    */
    @Override
    protected void updateClock() {
        /*
         * Max. hour, minute, second values: 23:59:59
         * Min. hour, minute, second values; 0:0:0
         */
        this.second --; 
        if (this.second == -1) {
            this.second = 59;
            this.minute --;
            if (this.minute == -1) {
                this.minute = 59;
                this.hour --;
                if (this.hour == -1) {
                    this.hour = 0;
                    this.minute = 0;
                    this.second = 0;
                }
            }
        }
    }

    /**
     * Avoids the execution of an event, or forces it to end inmediately.
     *
     * This method ignores current event in progress, ending them, or
     * next events to be scheduled, cancelling its execution (event is 'jumped')
    */
    public void ignoreEvent() {
        /* If there are events in progress, finish them inmediately.  */
        if (this.eventInProgress == true) {
            this.timeToEventEnd = 0;
        }
        /*
         * If there are no events in progress, "jump" them, and
         * search the next ones in the queue.
        */
        else {
            /* Restar "timeToLaunch" of all events. */
            for (Integer index: this.nextPXE) {
                this.periodExecutionEventList.get(index).restartTimeToLaunch();
            }
            this.searchNextEvent();
        }
    }

    /**
     * Forces the start of next events to be deployed.
     *
     * Next events to be deployed start inmediately, no matter how many seconds
     * remains until its activation.
    */
    public void forceEvent() {
        /*
         * 'forcedSubstraction' contains the 'timeToLaunch' value
         * of the next event to be deployed (that is, the remaining
         * seconds until its activation). The last '-1' is to avoid negative
         * values, even when the variable is checked again later.
        */
        int forcedSubstraction = this.periodExecutionEventList.get
                (this.nextPXE.get(0)).timeToLaunch - 1;
        int auxTimeToLaunch; 

        /* Safe checking */
        if (forcedSubstraction == -1) {
            forcedSubstraction = 0;
        }

        /*
         * To force the start of the events, substract to each one of them
         * the 'forcedSubstraction' value. This will cause some events to reach
         * 0 value in their 'timeToLaunch', calling to 'triggerEvent' method.
        */
        for (Event event : this.periodExecutionEventList) {
            auxTimeToLaunch = event.getTimeToLaunch() - forcedSubstraction;
            event.setTimeToLaunch(auxTimeToLaunch);
        }
    }

    /**
     * Clears internal data of the EventClock.
     * 
     * This method returns the clock to its initial state (variables are
     * restored to default values, same as constructor does).
    */
    private void eraseData() {
        if (!this.periodExecutionEventList.isEmpty()) {
            this.periodExecutionEventList.clear();
        }
        
        if (!this.singleExecutionEventList.isEmpty()) {
            this.singleExecutionEventList.clear();
        }
        
        if (!this.newAddedEvents.isEmpty()) {
            this.newAddedEvents.clear();
        }
        
        if (!this.eventsToLaunch.isEmpty()) {
            this.eventsToLaunch.clear();
        }
        
        if (!this.nextPXE.isEmpty()) {
            this.nextPXE.clear();
        }
        
        if (!this.nextSXE.isEmpty()) {
            this.nextSXE.clear();
        }

        this.timeToNextEvent = 0;
        this.timeToEventEnd = 0;
        this.eventInProgress = false;
        this.isPopUpVisible = false;
        this.playSound = true;
        this.popUpInFront = true; 
    }

    /**
     * Calculate 'timeToLaunch' of each SXE.
     * 
     * 'timeToLaunch' of SXE depends on the current system time. This value
     * is calculated and then assigned.
    */
    private void calculateSingleExecutions() {
        int auxTimeToLaunch;

        /* Get current system time in seconds. */
        int systemTimeInSeconds;

        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance(); 
        calendar.setTime(date);

        systemTimeInSeconds = calendar.get(Calendar.SECOND)
                + (calendar.get(Calendar.MINUTE) * 60)
                + (calendar.get(Calendar.HOUR_OF_DAY) * 3600);

        for (Event e: this.singleExecutionEventList) {
            /*
             * 'auxTimeToLaunch' is equal to
             * 'Time of single execution' - 'Current time'.
            */
            auxTimeToLaunch = (e.getStartingSecond()
                    + (e.getStartingMin() * 60)
                    + (e.getStartingHour() * 3600))
                    - systemTimeInSeconds;

            /*
             * If 'auxTimeToLaunch' is possitive, it means that the
             * hour of execution is ahead in time. If it is negative, it
             * means that the hour of execution has been surpassed.
            */
            if (auxTimeToLaunch > 0) {
                e.setTimeToLaunch(auxTimeToLaunch);
            }
            else {
                /*
                 * This will cause the event to be fired as soon as the
                 * clocks are started. That is: if an event that shall be
                 * fired once, is scheduled when its execution time has been
                 * surpassed, the application will show inmediately a pop-up
                 * warning the user about this.
                 * 'timeToLaunch' is set to 1, in order to reach the 0 value
                 * in the first execution of 'updateEvents'.
                */
                e.setTimeToLaunch(1);

                /*
                 * The event wont be executed until the
                 * execution time is reached. Because the event just starts
                 * once in a full 24-hour period, the period
                 * is equal to '24 hours' - (Hour of execution - Current Hour)
                */
                e.setPeriod(e.getPeriod() + auxTimeToLaunch);
            }
        }
    }
  
    /**
     * Add events created during execution time to its proper list.
     * 
     * Events created while clocks are running are added to the proper list,
     * being scheduled and deployed normally.
    */
    private void addNewEvents() {
        /*
         * This variable establish if the static information
         * about the single execution events shall be updated
         * (its value will change to true if, in the
         * new events to add, there are at least one that is
         * a single execution event).
        */
        boolean updateSingleExecutionInformation = false;

        /* 
         * new Event(newEvent) operationes are performed 
         * to avoid pass by reference. 
        */
        for (Event newEvent : this.newAddedEvents) {
            if (newEvent.startingTime == true) {
                this.singleExecutionEventList.add(new Event(newEvent));
                updateSingleExecutionInformation = true;
            }
            else {
                this.periodExecutionEventList.add(new Event(newEvent));
            }
        }

        /*
         * Clear the newAddedEvents, so this method
         * wont be launched again until new events are created
         * in execution time.
        */
        this.newAddedEvents.clear();

        /*
         * Generate again the information of the single execution events
         * in case it must be done.
        */
        if (updateSingleExecutionInformation == true) {
            this.generateSingleExecutionInformation();
            
            /* 
             * Single executions shall be recalculated 
             * with the new incorporations. 
            */
            this.calculateSingleExecutions();
        }

        /*
         * Search next event to be executed again,
         * the new incorporations change the current calculated values.
        */
        this.searchNextEvent();
    }

    /**
     * Stops EventClock.
     * 
     * EventClock internal data is erased and its behaviour is modified in 
     * order to finish all of its internal operations.
     * This methods overrides the functionality of 'stopClock()' method of
     * GenericClock class.
     * 
     * @see GenericClock
     * @see GenericClock#stopClock()  
    */
    @Override
    public void stopClock() {
        super.stopClock();    /* Call to "stop" method from GenericClock. */
        this.eraseData();

        /* Visual feedback. */
        this.label.setForeground(Color.black);
        TitledBorder tmp = (TitledBorder) label.getBorder();
        tmp.setTitle("Next Event in");
    }

    /**
     * Core functionality of EventClock.
     *
     * It implements the loop operations executed by the EventClock. The method
     * overrides the functionality of 'doInBackground()' method
     * of SwingWorker class.
     * 
     * @return time value.
     * @throws Exception SwingWorker inherited exception.
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

            /* EventClock only works if its state is not stopped. */
            if (this.stopped == false) {
                /*
                 * If the user added new events in execution time
                 * add them to the proper lists before update
                 * the events, because a new event can modify
                 * the scheduled behaviour.
                */
                if (!newAddedEvents.isEmpty()) {
                    this.addNewEvents();
                }

                /*
                 * Single execution events are continously updated,
                 * because its execution time depends on the
                 * system clock.
                */
                this.updateEvents(Flags.EventType.SINGLE);

                /* PXE only works if the EventClock is running. */
                if (this.paused == false) {
                    this.updateClock();
                    label.setText(this.printClock());

                    /*
                     * PXE are updated only when there are no PXE in progress.
                     * If an event starts, no further updates of this type
                     * of events will be performed until the current events
                     * in progress ends.
                    */
                    if (this.eventInProgress == true) {
                        this.waitEventEnd();
                    }
                    else {
                        this.updateEvents(Flags.EventType.PERIODICAL);
                    }
                }
            }
        }
    }

    /**
     *
     * @return True if there are events in progress.
    */
    public boolean getEventInProgress() {
        return this.eventInProgress;
    }
    
    /**
     * 
     * @return ArrayList of new events to be added in execution time.
    */
    public ArrayList<Event> getNewAddedEvents() {
        return this.newAddedEvents;
    }
    
    /**
     * 
     * @return ArrayList of Periodical Execution Events loaded in the app. 
    */
    public ArrayList<Event> getPXE() {
        return this.periodExecutionEventList;
    }
    
    /**
     * 
     * @return ArrayList of Single Execution Events loaded in the app. 
    */
    public ArrayList<Event> getSXE() {
        return this.singleExecutionEventList;
    }
}
