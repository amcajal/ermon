USER MANUAL
=====

This page contains a full and detailed user manual of Ermon application. All features of the ergonomic monitor
are listed and explained here.

## Index
1. [Download and Installation](#download-and-installation)
2. [Using Ermon](#using-ermon)
3. [Uninstall](#uninstall)

---

## DOWNLOAD AND INSTALLATION
**Ermon** does not need to be installed. Just [download the executable here](https://github.com/amcajal/ermon/blob/master/Ermon.jar?raw=true) -dont worry if the anti-virus warns you- and double click on it, like any other desktop icon.

---

## USING ERMON

*Once you double-clicked in the application icon, and the main window appeared...*

![ermon_main_window.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediamain.jpg)

### ===> Press Play Button ![play.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediaplay.jpg) to start the clocks:
The "Next Event" clock will count remaining seconds to the start of the next event, while "Worked Time" clock will count the seconds that the application is scheduling and deploying these events. You can see a summary of the next event or events in the "Description" field.

![play_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaplay_1.jpg)

When the "Next Event" clock reachs 0, a pop-up will appear with the information of the exercise or event you shall perform ("Next Event" clock color will change to blue too). 

![play_2.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaplay_2.jpg)
![play_3.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaplay_3.jpg)

There are 2 types of events: Periodical ones, and Single Execution ones. Periodical ones repeats constantly, while Single Execution ones will be launched at a certain time of the day (you can track it with the "System Time" clock). For example, "Refresh your eyes" can be a Periodical Event, because you shall perform it every 20 minutes, while "Take your medicine" its a Single Execution one, because you shall perform it at 12:30 each day.

Dont worry about the Single Execution events: the application will warn you about them no matter if the clocks are running or paused.

### ===> Press Pause Button ![pause.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediapause.jpg) to pause the clocks:
The "Next Event" clock will be paused, keeping its value. "Worked Time" will pause or not, depends on the configuration applied (explained later).

![pause_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediapause_1.jpg)

Single Execution events will be deployed normally, even with the clocks paused. Just press Play Button when you want them back to work.

### ===> Press Stop Button ![stop.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediastop.jpg) to stop the clocks:
All clocks will stop, and its values will be erasted. Application will return to its initial state. In the Text Area you will see how many time the application has been working, in case its value is usefull for you.

![stop_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediastop_1.jpg)


*While the clocks are running...*

### ===> Press See Button ![see.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediasee.jpg) to check information about the next events to be deployed:
The pop-up with the information of the events will appear, allowing you to check what are the next events to perform. The pop-up has two tabs, one for Periodical Execution events information, and another for Single Execution events information. Check whatever you want!

![see_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediasee_1.jpg)

### ===> Press Force Button ![force.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediaforce.jpg) to force an event to start, or ignore the current one.
You need an event to start inmediately? Press Force button, and it will start right now!
You need to end an event inmediately? Press Force button, and the event in progress will end right now!

![force_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaforce_1.jpg)

Use this button to control directly the flux of events. Note that only Periodical Execution events can be affected by this. Single Execution events cannot be forced or ignored (they have a certain starting time).

### ===> Press Add Button ![add.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediaadd.jpg) to include a new event to the actual list of events being scheduled.
You forgot to add an event to the list of currently scheduled, or need to include a new one in order to not forgot it (for example, "Call HHRR at 15:00")? Press Add button, create it, and add it with no problems. Creation Window will be explained later.

*While the clocks are stopped...*

### ===> Press Configuration Button ![configuration.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediaconfiguration.jpg) to expand the configuration section.
Here you can configure several aspects of Ermon.

![config_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaconfig_1.jpg)

*In the configuration section...*

### ===> Change the basic options in the left section.
By selecting or deselecting the options you can choose if the pop-ups shall appear with sound or in silence; if the pop-ups shall appear in foreground or in background, and if "Worked Time" shall be paused when Pause button is pressed.

Press Apply Button to make the changes effective, or press Reset to return all options to its initial values. You will see a confirmation message in blue.

![config_2.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaconfig_2.jpg)


### ===> Load, create or modify events with the options of the right section.
Here you can do several operation:
- Load the default set of events, already included in the application.
- Load a set of events previously created by the user. Browse in the system to the file with the information, and its done! For example, [download here](https://github.com/amcajal/ermon/blob/master/downloads/pomodoro_events_ermon.txt?raw=true) -double click and then "Save it"- the Pomodoro set of events and load it. There you go: you can apply know the [Pomodoro](http://pomodorotechnique.com/) technique in your daily work!
- Create a set of custom events from zero, from a template (using the default events for that purpose), or modify a set of previously created events. All of this operations will lead to a Creation Window.

A message of confirmation will appear, either in blue (all went fine) or in red (something failed).

![config_3.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediaconfig_3.jpg)

*In the creation window...*

![creation_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediacreation_1.jpg)

* #### Add the data of the event in the left section.
Select the title, if the event is a Periodical one -choosing "Repeat every" and then establishing the period- or a Single Execution one -choosing "Single Execution at" and establishing the time of the day-, the duration of the event, and its description.

When you are finished, press Add Event button. A confirmation message will appear, indicating you if everything went ok, or something failed. The created event will appear in the right section.

![creation_2.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediacreation_2.jpg)

### ===> Modify or delete the created events with the buttons of the right section.
Using the combo box of the footer, select the created events to delete them, or to modify them (its values will be loaded in the left section to directly modify them).  

Finally, press Save button to save the events in a text file. You can browse in the system the folder where the file will be saved. Or, press Reset All to start from zero.

![creation_3.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediacreation_3.jpg)

*In any moment...*

### ===> Press Habits Button ![habits.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediahabits.jpg) to check information about current loaded events, default set of events, or custom events.
Select in the combo box the required information, and then press Show button.

![habits_1.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediahabits_1.jpg)

### ===> Press About Button ![about.jpg](https://github.com/amcajal/ermon/blob/master/project/doc/mediaabout.jpg) to check miscellaneous information about the application and its environment.
Select in the combo box the required information, and then press the Show button.

![habits_2.png](https://github.com/amcajal/ermon/blob/master/project/doc/mediahabits_2.jpg)

---

### Uninstall
**Ermon** does not need to be installed. Thus, to "uninstall" it, simply delete the program from your PC (drag and drop into the Recycle Bin, or secondary clock on the Ermon executable and select "Delete")

---