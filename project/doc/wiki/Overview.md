OVERVIEW
========

This page contains an overview of the "development side" of Ermon application.

## Index
1. [Motivation](#motivation)
2. [Software requirements](#software-requirements)
3. [Architecture](#architecture)
4. [Design and Implementation](#design-and-implementation)

---

### Motivation
Computers have become one of the main tools of the XXI Century, being present in a great number of professional fields, and in the daily life too.

However, a continued and prolonged use of computers, done in a wrong way, carries a series of health problems, like back pains and dry eyes, that can lead to a considerable decrease in the life quality.

These problems can be reduced or even avoided through **Ergonomy**, defined as the adaptation of the individual to the work place and its tools. Besides a good equipment, good postures and a suitable desktop, a very efficient and simple way to avoid these pains is perform small exercises or activities that counter the effects of a prolonged computer use.

In order to make the user able to focus in other things, these healthy habits can be controlled, scheduled and deployed automatically through a desktop application, in charge of warn as a "trainer" or "monitor", about the exercises to perform, as well as its duration and period.

While there are some applications dedicated to this purpose, they usually are a) complex, and may not be used intuitively and comfortable; b) limited, without customization options, neither user adaptation capabilities and c) proprietary or commercial, not being accessible for everyone.

Motivation then is clear: develop an alternative to these tools, making it simple, both in user and computer side, highly customizable and open source (totally free and available for the community). Also, this process can be performed while testing -or improving- significant aspects of the software engineering, obtaining knowledge and experience in several related fields and technologies.

**Ermon** (acronym of ERgonomic MONitor) is presented as this alternative. A simple application, that helps the user to perform activities to combat the adverse effects of a prolonged use of the computer, easy to use, and with customization capabilities (for example, to choose the set of exercises to be scheduled).

---

### Software requirements

The requirements that roughly driven the development of Ermon are listed below.

**Ermon** application shall:

|ID | Description |
| ------------ | :------------ |
| 001 | be [Open Source](https://en.wikipedia.org/wiki/Open-source_software), released under [GNU GPL version 3.0 license](https://www.gnu.org/licenses/gpl-3.0.html) (check [License](#license) section for more information). |
| 002 | be multi platform, being compatible with the following O.S: Windows, Unix and Mac. |
| 003 | be GUI driven. All interactions shall be performed through graphical elements -e.g: buttons, scroll bars, pop-ups-.|
| 004 | warn the user or attract his attention using both graphical information -text, colour changes, blinks- and sound signals.|
| 005 | contain a default set of ergonomic events or activities, created after a research in such science.|
| 006 | be able to create new events -either from the beginning or using existing events as templates- AND save this events in custom event files for further use (in the file system).|
| 007 | be able to load both the default set of events AND custom set of events (from the file system), either for use them OR modify them.|
| 008 | contain a default configuration regards to: the behaviour of pop-ups (appearing in foreground or background), the playing of sound when pop-ups appear, and the behaviour of the "Worked Time Clock". By default: pop-ups are played with sound; "Worked Time Clock" is paused when events are paused; Pop-ups are brought to front.|
| 009 | allow the modification of the default configuration and its restore to its initial values (Req. 008). |
| 010 | contain a "System Clock". This clock matches the local time or O.S time.|
| 011 | contain a "Worked Time Clock". This clock controls how much time the application has been deploying and scheduling events or activities, and can be used to measure how much time the user has been working.|
| 012 | contain a "Event Time Clock". This clocks controls the events and activities: how much time to the start of the next event, and how much time to the end of the current events in progress.|
| 013 | show all time values in a twenty-four hour digital format, being 00:00:00 the lower bound, and 23:59:59 the upper bound.|
| 014 | contain two types of events: Single Execution Events -SXE- AND Periodical Execution Events -PXE-. SXE are those events that only happens once in a day, at a certain hour. PXE are those events that happens constantly, with a certain interval between executions (a period).|
| 015 | provide feedback in each user action -about what has been done- and in each software operation that shall be noticed, using several means (Req. 004)  |
| 016 | allow force or ignore events -only PXE-. Force and event means that it is commanded to start immediately, regardless of the remaining time to its execution. Ignoring an even means that it is commanded to end immediately, regardless of the remaining time to its finalization.|
| 017 | allow the checking of information about the next event or events to be deployed, or information about the current event or events in progress.|
| 018 | allow the creation of events in real time. These events are created while the application is running, and added to the list of events currently dispatched and deployed, but only remain until the application is closed (they are not saved in any file).|
| 019 | create a pop-up each time an event(s) starts, with the related information in the correct tab. The pop-up then shall appear in foreground or background, with a sound or in silence, depends on the configuration. (Req. 008). |
| 020 | treat SXE in a different way than PXE. SXE cannot be affected by user actions, and will be deployed when "System Time Clock" matches the starting time.|
| 021 | be in three possible states: STARTED, PAUSED or STOPED. |
| 022 | be in STARTED state when it is scheduling and deployment of events, that is, updating the time values that controls its initialization and endings. |
| 023 | be in PAUSED state when events are not being updated, but its data are kept, so they will be restored when PLAY status is recovered. SXE cannot be paused, as Req. 020 establishes.|
| 024 | be in STOPPED state when the scheduling and deployment of events when has been terminated. Application is returned to its initial state. |
| 025 | ask the user for confirmation when closing the program, in order to avoid involuntary close button pressings and the consequent lost of information. |

---

### Architecture

*NOTE: Check the [API](https://amcajal.github.io/ermon/) for a full description of the code -packages, classes, methods-.*

**Ermon** application is compound of the following modules:
- **GUI module**, responsible of the graphic user interface, and thus, the communication between the program logic and the user commands. 
- **SRC (source) module**, responsible of the program logic, like data handling, mathematical operations and instructions performance.
- **MEDIA module**, compound of miscellaneous -multimedia- files used both for the GUI module and the SRC module, in order to achieve the necessary functionality.

The connexion between this modules are represented in the figure below:
![module_conection](https://github.com/amcajal/ermon/blob/master/project/doc/media/ermon_architecture.png)

Basically, user uses the GUI components (windows and its buttons, text areas, pop-ups) to communicate with the SRC module, that will perform the internal operations of the application (like update timers and check events status). Certain of these operations (playing a sound or show textual information) requires external files that, due to their nature, can be grouped together under the MEDIA module.

This architecture is implemented in the project in a very straightforward manner, establishing a package for each one of them. Then, the project as:
- **GUI package**: containing the Swing components -all the windows that can be created in **Ermon**-, and then, the code behind the pushing of buttons, opening-closing of windows and so on.
- **SRC package**: containing the Java source code for the core functionality (main classes and their methods).
- **MEDIA package**: containing the plain text, MIDI and JPG files used in the application (for play sounds, show textual information and add icons to several buttons).

This architecture allows a very easy maintenance of the application from the developer side. For example: user wants to start the timers, 
so he press the "Play Button" (globally recognized thanks to the "Play" logo, under MEDIA package). 
This simple action is received in the MainWindow (GUI package) that, besides update the graphical aspect of the interface giving feedback of what is happening, 
triggers the operations of the EventClock, GenericClock, CongifLoader classes and more (SRC package), 
performing the core operations -update timers, check which events will be next, keep track of the application status-.

---

### Design and Implementation

*More detail about the implementation of each module is provided below*

**GUI module**: the user interface functionality is achieved using [Swing components](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html). 
Swing is a graphic library that includes widgets to create graphic user interfaces with the most common components like buttons, tables and text areas. 
Included in Netbeans, the creation of interfaces using this components is easy and most of the code can be generated automatically, 
reducing developing time and errors. The core elements are the multi-thread capability of the library 
(very important in order to control several elements concurrently, like the different timers and its text) 
and the [Event listeners](https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html), that are constantly waiting for user actions 
(for example, the push of a button). In this way, any user action can be registered and processed as needed. 
Usually, a user action will be attached to a logical operation, thus connecting both elements.
Use of Swing library allows a quick creation of GUIs, aesthetically as wanted, and with the required code to control the app. 
For example, application status control can be easily implemented with three single buttons (play, stop and pause),
with minimal code, and totally understandable for the user.

![state_diagram](https://github.com/amcajal/ermon/blob/master/project/doc/media/ermon_state_diagram.png)

**MEDIA module**: acts as a "database" or "internal storage". 
A simple project package without code -except the one needed for the API documentation (an addition in this project)- 
where the multimedia files used in the application -MIDI files, JPEG logos, plain text files- are stored together. 
In this way, both SRC and GUI modules can access easily to them, 
avoiding problems derived from the external storage in different OS (absolute and relative paths, permissions, accidental user operations).

**SOURCE module**: all required logic operations of the application can be achieved with the following elements:
- "Event": represents the activity (physical or not) to be performed in order to maintain healthy while using the computer, 
like "walk five minutes" or "rub your eyes". It shall contain the necessary information both to communicate 
with the user and be controlled by the application. 
This information includes the title of the event, its description, duration and so on. 
This element can be easily implemented as a Java class.

- "Clock": element that control operations based on the time (how many seconds left, what time is it). 
Clock shall measure seconds, minutes and hours, and depends on these values, certain operations shall be triggered. 
There shall be three types of clocks, as requirements establishes -System Clock, Worked Time clock and Event clock-. Diagrams of the clocks are as follows:

![generic_clock](https://github.com/amcajal/ermon/blob/master/project/doc/media/generic_clock.png)

![event_clock](https://github.com/amcajal/ermon/blob/master/project/doc/media/event_clock.png)

The implementation of the Clocks can be easily achieved using [Swing Workers](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/worker.html). 
Swing Workers perform GUI tasks in background threads, allowing several operations simultaneously without blocking each other 
(for example, press a button while a text are is updated). So each clock can work individually from the others, each one updating its state, 
but still able to communicate between them. This allows a graphic feedback, and an easier implementation and management.

- "Supports": elements that performs operations required to communicate the clocks between them, and keep the system working. 
These support elements shall be able to:
	- Load and play MIDI files when necessary.
	- Store the user configuration and apply it to the system. 
	- Perform reads and writes of text files in the most safe and clean way possible. This is very important because the storage of any application data is performed in plain text, so the format of the file shall be checked before any other operation.

All of the previous elements can be implemented easily as Java classes, using the core functionalities of the language.
