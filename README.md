![ermon_logo](https://github.com/amcajal/ermon/blob/master/images/readme_ermon_logo.png)

### Overview

**Ermon** (ERgonomic MONitor) is a simple application to perform healthy habits while working with computers. Once started, the application notifies the user from time to time to do basic activities called "events"- like blink repeatedly, stretch shoulders or walk a little- in order to reduce and prevent symptoms related with the prolonged use of computers: dry eyes, back and wrists pain, early fatigue, and so on.

Ermon main features are:

- **Easy to use**: Aimed to all audiences -typical users, gamers, programmers - anyone who works or uses a computer. Easy as press play and let the application work.
- **Cut to the chase**: No initial set-up needed. The application has a default list of events available, based on a basic research about ergonomic science.
- **Multi-platform**: Works in Windows, Linux and Mac.
- **Portable**: No installation needed. Just click on the application, and run. 
- **Customizable**: New events can be created, modified and saved. Basic tool configuration options can be set too.

And of course, completely FREE.

![ermon_main_window.png](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png)

---

[![user_section_logo.png](https://github.com/amcajal/ermon/blob/master/images/user_section_logo.png)](#user-section-index)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
[![dev_section_logo.png](https://github.com/amcajal/ermon/blob/master/images/dev_section_logo.png)](#developer-section-index)

---

### User Section Index

1. [License](#license)
2. [Requirements](#requirements)
3. [Installation](#installation)
4. [Quick-start](#quickstart)
5. [Using Ermon](#using-ermon)
6. [Uninstall](#uninstall)
7. [Contact](#contact)

---

### Requirements
- Is your PC working?
- It obeys you?
- Is Java installed (almost sure about this)? 

If all answers were "Yes" (I'm worried about the second one), you are ready to use **Ermon**. In case you -surprisingly- don't have Java installed, [click here](https://www.java.com/es/download/) and follow the instructions. Done!

[Back to user index](#user-section-index)

### Installation
**Ermon** does not need to be installed. Just download the [executable](https://github.com/amcajal/ermon/tree/master/executable), (PUT A DOWNLOAD LINK IN GITHUB TO_DO) and double click on it, like any other desktop icon.

[Back to user index](#user-section-index)

### Quickstart
1. Double click on Ermon icon. Main window will appear.
2. Press "Play" button.
3. Ermon is now running! It will notify about the events to perform.

*NOTE: Linux users should execute "$> java -jar Ermon.jar"  Be sure to [enable Nimbus look and feel](https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html)!*  

[Back to user index](#user-section-index)

### Using Ermon

*Once you double-clicked in the application icon, and the main window appeared...*
![ermon_main_window.png](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png)

* #### Press Play Button ![play.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to start the clocks:
The "Next Event" clock will count remaining seconds to the start of the next event, while "Worked Time" clock will count the seconds that the application is scheduling and deploying these events. You can see a summary of the next event or events in the "Description" field.

![play_1.png](https://github.com/amcajal/ermon/blob/master/images/play_1.jpg)

When the "Next Event" clock reachs 0, a pop-up will appear with the information of the exercise or event you shall perform ("Next Event" clock color will change to blue too). 

![play_2.png](https://github.com/amcajal/ermon/blob/master/images/play_2.jpg)
![play_3.png](https://github.com/amcajal/ermon/blob/master/images/play_3.jpg)

There are 2 types of events: Periodical ones, and Single Execution ones. Periodical ones repeats constantly, while Single Execution ones will be launched at a certain time of the day (you can track it with the "System Time" clock). For example, "Refresh your eyes" can be a Periodical Event, because you shall perform it every 20 minutes, while "Take your medicine" its a Single Execution one, because you shall perform it at 12:30 each day.

Dont worry about the Single Execution events: the application will warn you about them no matter if the clocks are running or paused.

* #### Press Pause Button ![pause.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to pause the clocks:
The "Next Event" clock will be paused, keeping its value. "Worked Time" will pause or not, depends on the configuration applied (explained later).

![pause_1.png](https://github.com/amcajal/ermon/blob/master/images/pause_1.jpg)

Single Execution events will be deployed normally, even with the clocks paused. Just press Play Button when you want them back to work.

* #### Press Stop Button ![stop.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to stop the clocks:
All clocks will stop, and its values will be erasted. Application will return to its initial state. In the Text Area you will see how many time the application has been working, in case its value is usefull for you.

![stop_1.png](https://github.com/amcajal/ermon/blob/master/images/stop_1.jpg)


*While the clocks are running...*

* #### Press See Button ![see.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to check information about the next events to be deployed:
The pop-up with the information of the events will appear, allowing you to check what are the next events to perform. The pop-up has two tabs, one for Periodical Execution events information, and another for Single Execution events information. Check whatever you want!

![see_1.png](https://github.com/amcajal/ermon/blob/master/images/see_1.jpg)

* #### Press Force Button ![force.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to force an event to start, or ignore the current one.
You need an event to start inmediately? Press Force button, and it will start right now!
You need to end an event inmediately? Press Force button, and the event in progress will end right now!

![force_1.png](https://github.com/amcajal/ermon/blob/master/images/force_1.jpg)

Use this button to control directly the flux of events. Note that only Periodical Execution events can be affected by this. Single Execution events cannot be forced or ignored (they have a certain starting time).

* #### Press Add Button ![add.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to include a new event to the actual list of events being scheduled.
You forgot to add an event to the list of currently scheduled, or need to include a new one in order to not forgot it (for example, "Call HHRR at 15:00")? Press Add button, create it, and add it with no problems. Creation Window will be explained later.

*While the clocks are stopped...*

* #### Press Configuration Button ![configuration.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to expand the configuration section.
Here you can configure several aspects of Ermon.

![config_1.png](https://github.com/amcajal/ermon/blob/master/images/config_1.jpg)

*In the configuration section...*

* #### Change the basic options in the left section.
By selecting or deselecting the options you can choose if the pop-ups shall appear with sound or in silence; if the pop-ups shall appear in foreground or in background, and if "Worked Time" shall be paused when Pause button is pressed.

Press Apply Button to make the changes effective, or press Reset to return all options to its initial values. You will see a confirmation message in blue.

![config_2.png](https://github.com/amcajal/ermon/blob/master/images/config_2.jpg)


* #### Load, create or modify events with the options of the right section.
Here you can do several operation:
- Load the default set of events, already included in the application.
- Load a set of events previously created by the user. Browse in the system to the file with the information, and its done!
- Create a set of custom events from zero, from a template (using the default events for that purpose), or modify a set of previously created events. All of this operations will lead to a Creation Window.

A message of confirmation will appear, either in blue (all went fine) or in red (something failed).

![config_3.png](https://github.com/amcajal/ermon/blob/master/images/config_3.jpg)

*In the creation window...*

![creation_1.png](https://github.com/amcajal/ermon/blob/master/images/creation_1.jpg)

* #### Add the data of the event in the left section.
Select the title, if the event is a Periodical one -choosing "Repeat every" and then establishing the period- or a Single Execution one -choosing "Single Execution at" and establishing the time of the day-, the duration of the event, and its description.

When you are finished, press Add Event button. A confirmation message will appear, indicating you if everything went ok, or something failed. The created event will appear in the right section.

![creation_2.png](https://github.com/amcajal/ermon/blob/master/images/creation_2.jpg)

* #### Modify or delete the created events with the buttons of the right section.
Using the combo box of the footer, select the created events to delete them, or to modify them (its values will be loaded in the left section to directly modify them).  

Finally, press Save button to save the events in a text file. You can browse in the system the folder where the file will be saved. Or, press Reset All to start from zero.

![creation_3.png](https://github.com/amcajal/ermon/blob/master/images/creation_3.jpg)

*In any moment...*

* #### Press Habits Button ![habits.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to check information about current loaded events, default set of events, or custom events.
Select in the combo box the required information, and then press Show button.

![habits_1.png](https://github.com/amcajal/ermon/blob/master/images/habits_1.jpg)

* #### Press About Button ![about.jpg](https://github.com/amcajal/ermon/blob/master/images/ermon_main_window.png) to check miscellaneous information about the application and its environment.
Select in the combo box the required information, and then press the Show button.

![habits_2.png](https://github.com/amcajal/ermon/blob/master/images/habits_2.jpg)


[Back to user index](#user-section-index)

### Uninstall
**Ermon** does not need to be installed. Thus, to "uninstall" it, simply delete the program from your PC (drag and drop into the Recycle Bin, or secondary clock on the Ermon executable and select "Delete")

[Back to user index](#user-section-index)

---

### Developer Section Index

1. [License](#license)
2. [Project structure](#project-structure)
3. [Motivation](#motivation)
4. [Methodologies, paradigms and principles](#methodology-paradigm-and-principles)
5. [Software requirements](#software-requirements)
6. [Hardware requirements](#hardware-considerations)
7. [Technologies](#technologies)
8. [Architecture](#architecture)
9. [Design](#design)
10. [Tools](#tools)
11. [External resources](#external-resources)
12. [Issues](#issues)
13. [Contact](#contact)

---

### Project structure:

**Ermon** project is structured as follows:

- **Master branch**: main page of **Ermon**. It contains:
	- **Executable**: Ermon JAR, ready to be launched.
	- **Source**: folder with the source code and related files (MIDI files, Swing Forms and so on). It can be loaded directly into NetBeans, for example.
	- **Examples**: folder containing example files to be used in the application (custom sets of events), like the "Pomodoro" set of events.
	- **Images**: folder containing images to be used in the README.
	- **LICENSE**: license applied to this software.
	- **README**: You can read it below.
	- [**Issues Page**](https://github.com/amcajal/ermon/issues): List of bugs, enhancements requests, TODOs and so on.
	
- **API branch**: it hosts the HTML of **Ermon's** API -generated using Javadoc from NetBeans IDE, and modified later manually to add certain features- allowing the access to it as a web page. 

[Back to developer index](#developer-section-index)

### Motivation
Computers have become one of the main tools of the XXI Century, being present in a great number of professional fields, and in the daily life too.

However, a continued and prolonged use of computers, done in a wrong way, carries a series of health problems, like back pains and dry eyes, that can lead to a considerable decrease in the life quality.

These problems can be reduced or even avoided through **Ergonomy**, defined as the adaptation of the individual to the work place and its tools. Besides a good equipment, good postures and a suitable desktop, a very efficient and simple way to avoid these pains is perform small exercises or activities that counter the effects of a prolonged computer use.

In order to make the user able to focus in other things, these healthy habits can be controlled, scheduled and deployed automatically through a desktop application, in charge of warn as a "trainer" or "monitor", about the exercises to perform, as well as its duration and period.

While there are some applications dedicated to this purpose, they usually are a) complex, and may not be used intuitively and comfortable; b) limited, without customization options, neither user adaptation capabilities and c) proprietary or commercial, not being accessible for everyone.

Motivation then is clear: develop an alternative to these tools, making it simple, both in user and computer side, highly customizable and open source (totally free and available for the community). Also, this process can be performed while testing -or improving- significant aspects of the software engineering, obtaining knowledge and experience in several related fields and technologies.

**Ermon** (acronym of ERgonomic MONitor) is presented as this alternative. A simple application, that helps the user to perform activities to combat the adverse effects of a prolonged use of the computer, easy to use, and with customization capabilities (for example, to choose the set of exercises to be scheduled).

[Back to developer index](#developer-section-index)

### Methodology, Paradigm and Principles

The development of **Ermon** has been driven following a well defined "philosophy", whose pillars are:

- **Clean Code**: defined in several ways, and well documented both in the [Clean Coders web page](https://cleancoders.com/), and specially in the book "Clean Code: a handbook of agile software craftsmanship" by Robert C. Martin, one of its main contributors. Clean Code refers to the seeking of excellence in all the aspects of the programming process: meaningful comments, meaningful variable names, good coding style, maintainable structure... Clean Code principles has been used in general in all steps of the software development cycle of **Ermon**.
- **[Modularity](https://en.wikipedia.org/wiki/Modularity)**: applied to the software engineering. "Divide and conquer" or "Defeat in detail", as said in military, is basically the strategy of "break" a problem in small pieces, and solve this pieces individually. **Ermon** development has been focused on this concept: the software is based on basic modules, easy to implement, maintain, trace, enhance and connect. More complex features are the result of unions between these basic modules. Following this, **Ermon** development has been strongly inspired by the [UNIX philosophy](https://en.wikipedia.org/wiki/Unix_philosophy).
- **[Traceability](https://en.wikipedia.org/wiki/Requirements_traceability)**: following the advantages that modularity provides, **Ermon** keeps a full traceability between the software life cycle phases, improving the overall performance of operations like error tracking or  functionality enhancement. Another reason -personal reason from the developer- for full traceability is to liken **Ermon** software processes to the ones related to [life-critical systems](https://en.wikipedia.org/wiki/Life-critical_system) (aerospace, defence, healthcare).

All previous concepts can be unified and connected under the [V-Model](https://en.wikipedia.org/wiki/V-Model_%28software_development%29) paradigm, which is the one followed to develop **Ermon**. Clean Code principles and modularity are paradigm-independent, but V-Model allows a full traceability between the requirements, design, implementations and tests. V-Model characteristics allows to apply both [Top-Down and Bottom-Up](https://en.wikipedia.org/wiki/Top-down_and_bottom-up_design) perspectives when needed (at first stages -prototypes- and last phases -verification-).

![v_model](https://github.com/amcajal/ermon/blob/master/images/v_model.png)

*Developers Notes*: several other paradigms, methodologies, principles and philosophies where considered for this project. Most relevant ones where the [Agile Manifesto](http://agilemanifesto.org/), [Scrum](https://en.wikipedia.org/wiki/Scrum_%28software_development%29), [Extreme Programming](https://en.wikipedia.org/wiki/Extreme_programming), and specially [TDD](https://en.wikipedia.org/wiki/Test-driven_development).

[Back to developer index](#developer-section-index)

### Software requirements

***Note***: [Software requirements](https://en.wikipedia.org/wiki/Software_requirements) is a huge field in the Software Engineering. It involves a lot of concepts, whose explanation will increase the extension of this section out of bounds. So, here will be listed only the most relevant ones -those who defined the most important aspects of **Ermon**- in a less-proffesional but more-friendly way. This means that several requirements will be omitted -the ones related to the graphic design, for example-, and a couple of bad practices, like mixing requirement types, will take place here.

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


Whenever possible, each one of these requirements shall be traced to a design unit, then traced to an implementation unit, and then traced to a test unit.

[Back to developer index](#developer-section-index)


### Hardware requirements
**Ermon** is a desktop application and is conceived as a pure software project, so no hardware considerations or requirements has been taken/established.

[Back to developer index](#developer-section-index)

### Technology

Once the [software](#software-requirements) and [hardware](#hardware-requirements) requirements have been established, it shall be possible to choose the core technologies which are the ground for **Ermon**.

Technologies have been selected following two main principles:
- All functionality shall be possible to implement. That means that all requirements shall be met.
- Technology shall be open-source, or at least, free, with no need for commercial licenses.

Secondary considerations are the existence of documentation, the expertise and knowledge already possessed in certain fields, the possibility to connect the technologies to create a well structured ecosystem, and so on.

So, using these "guidelines", from all the possibilities, the following technologies have been selected:

- [Java](https://en.wikipedia.org/wiki/Java_%28programming_language%29): general-purpose, concurrent, class-based, object oriented computer programming language. Java can run on all platforms that support its Java Virtual Machine (JVM), regardless of the computer architecture, achieving a high level of portability. Most of related Java technologies are released under the GNU General Public License. Is one of the most popular languages in use. With this characteristics, meeting all requirements -multi-platform, portability-, methodologies -modularity- and functionality -pop-ups, threads- its completely possible. Therefore, all source code is in Java.
- [MIDI](https://en.wikipedia.org/wiki/MIDI): technical standard that describes a protocol, digital interface and connectors and allows a wide variety of electronic musical instruments, computers and other related devices to connect and communicate with one another. The Standard MIDI File (SMF) is a file format that provides a standardized way for sequences to be saved, transported, and opened in other systems. The compact size of these files has led to their widespread use in computers, mobile phone ringtones, web page authoring and greeting cards. Compatible with Java, MIDI files are easy to create and manipulate, as well as free, so sound effects can be achieved with no problems.
- [PNG](https://en.wikipedia.org/wiki/Portable_Network_Graphics): Portable Network Graphics is a raster graphics file format that supports lossless data compression. PNG supports palette-based images (with palettes of 24-bit RGB or 32-bit RGBA colours), grayscale images (with or without alpha channel), and full-colour non-palette-based RGB[A] images (with or without alpha channel). PNG images, compatible with Java, are easy to create and manipulate, and its characteristics -resolution, size, transparent layers- allows a perfect match with the "artistic" layer of the application.
- [Plain text](https://en.wikipedia.org/wiki/Plain_text): data that represent only characters of readable material but not its graphical representation nor other objects (images, etc). It may also include a limited number of characters that control simple arrangement of text, such as line breaks or tabulation characters. The encoding has traditionally been either ASCII, sometimes EBCDIC. Is a pure sequence of character codes. Plain text files are the most basic form of human-readable data storage. Keeping a minimal control over the information -file exist, file has the correct structure, no strange characters-, any operation involving write or read of data can be achieved with no problem.

*Developers Notes*: Most relevant technologies considered for **Ermon** development where Python as core programming language, MP3 for sound playing and XML for data storage -configuration, custom events-.

[Back to developer index](#developer-section-index)

### Architecture

*NOTE: Check the [API](TO_DO) for a full description of the code -packages, classes, methods-.*

**Ermon** application is compound of the following modules:
- **GUI module**, responsible of the graphic user interface, and thus, the communication between the program logic and the user commands. 
- **SRC (source) module**, responsible of the program logic, like data handling, mathematical operations and instructions performance.
- **MEDIA module**, compound of miscellaneous -multimedia- files used both for the GUI module and the SRC module, in order to achieve the necessary functionality.

The connexion between this modules are represented in the figure below:
![module_conection](https://github.com/amcajal/ermon/blob/master/images/ermon_architecture.png)

Basically, user uses the GUI components (windows and its buttons, text areas, pop-ups) to communicate with the SRC module, that will perform the internal operations of the application (like update timers and check events status). Certain of these operations (playing a sound or show textual information) requires external files that, due to their nature, can be grouped together under the MEDIA module.

This architecture is implemented in the project in a very straightforward manner, establishing a package for each one of them. Then, the project as:
- **GUI package**: containing the Swing components -all the windows that can be created in **Ermon**-, and then, the code behind the pushing of buttons, opening-closing of windows and so on.
- **SRC package**: containing the Java source code for the core functionality (main classes and their methods).
- **MEDIA package**: containing the plain text, MIDI and JPG files used in the application (for play sounds, show textual information and add icons to several buttons).

This architecture (that can be understood as a modified or customized version of the typical "three-tier architecture", where the data tier responsibilities are divided between the SRC and MEDIA modules) allows a very easy maintenance of the application from the developer side -components with similar behaviours are grouped under the same module/package, so error tacking and functionality enhancement is simplified-, and a very easy use from the user side.

For example: user wants to start the timers, so he press the "Play Button" (globally recognized thanks to the "Play" logo, under MEDIA package). This simple action is received in the MainWindow (GUI package) that, besides update the graphical aspect of the interface giving feedback of what is happening, triggers the operations of the EventClock, GenericClock, CongifLoader classes and more (SRC package), performing the core operations -update timers, check which events will be next, keep track of the application status-.

[Back to developer index](#developer-section-index)

### Design

*Developers note: Design and Implementation are separated by a blurred thin line. In this case, both concepts are presented together, in order to reduce the extension of the document and provide real examples that easies the understanding of it.* 

*Of course, check the [API](TO_DO) for a full description of the code -packages, classes, methods-.*

Following the "three layer" architecture, each module is designed with the objective of ease the implementation, making use of existing solutions whenever possible. When custom ones are needed, they shall be as simple as possible.

With this in mind, each module is designed as follows:

**GUI module**: the user interface functionality is achieved using [Swing components](https://docs.oracle.com/javase/7/docs/api/javax/swing/package-summary.html). Swing is a graphic library that includes widgets to create graphic user interfaces with the most common components like buttons, tables and text areas. Included in Netbeans, the creation of interfaces using this components is easy and most of the code can be generated automatically, reducing developing time and errors. The core elements are the multi-thread capability of the library (very important in order to control several elements concurrently, like the different timers and its text) and the [Event listeners](https://docs.oracle.com/javase/tutorial/uiswing/events/intro.html), that are constantly waiting for user actions (for example, the push of a button). In this way, any user action can be registered and processed as needed. Usually, a user action will be attached to a logical operation, thus connecting both elements.
Use of Swing library allows a quick creation of GUIs, aesthetically as wanted, and with the required code to control the app. For example, application status control can be easily implemented with three single buttons (play, stop and pause), with minimal code, and totally understandable for the user.
![state_diagram](https://github.com/amcajal/ermon/blob/master/images/ermon_state_diagram.png)

**MEDIA module**: acts as a "database" or "internal storage". A simple project package without code -except the one needed for the API documentation (an addition in this project)- where the multimedia files used in the application -MIDI files, JPEG logos, plain text files- are stored together. In this way, both SRC and GUI modules can access easily to them, avoiding problems derived from the external storage in different OS (absolute and relative paths, permissions, accidental user operations).

**SOURCE module**: all required logic operations of the application can be achieved with the following elements:
- "Event": represents the activity (physical or not) to be performed in order to maintain healthy while using the computer, like "walk five minutes" or "rub your eyes". It shall contain the necessary information both to communicate with the user and be controlled by the application. This information includes the title of the event, its description, duration and so on. This element can be easily implemented as a Java class, whose UML diagram is show below (TO_DO).
- "Clock": element that control operations based on the time (how many seconds left, what time is it). Clock shall measure seconds, minutes and hours, and depends on these values, certain operations shall be triggered. There shall be three types of clocks, as requirements establishes -System Clock, Worked Time clock and Event clock-. Diagrams of the clocks are as follows:

![generic_clock](https://github.com/amcajal/ermon/blob/master/images/generic_clock.png)

![event_clock](https://github.com/amcajal/ermon/blob/master/images/event_clock.png)

The implementation of the Clocks can be easily achieved using [Swing Workers](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/worker.html). Swing Workers perform GUI tasks in background threads, allowing several operations simultaneously without blocking each other (for example, press a button while a text are is updated). So each clock can work individually from the others, each one updating its state, but still able to communicate between them. This allows a graphic feedback, and an easier implementation and management.
- "Supports": elements that performs operations required to communicate the clocks between them, and keep the system working. These support elements shall be able to:
	- Load and play MIDI files when necessary.
	- Store the user configuration and apply it to the system. 
	- Perform reads and writes of text files in the most safe and clean way possible. This is very important because the storage of any application data is performed in plain text, so the format of the file shall be checked before any other operation.

All of the previous elements can be implemented easily as Java classes, using the core functionalities of the language.


[Back to developer index](#developer-section-index)

### Tools
The following list comprises all tools used to develop **Ermon**, according to the software requirements, technological, architectural and design choices, and software life cycle considerations.

- [NetBeans](https://netbeans.org/) as IDE, one of the best for Java development. A compiler-code highlight editor-debugger-Swing utilities-Javadoc generator and much more, all in one.
- [Notepad ++](https://notepad-plus-plus.org/),simply and powerful text editor, useful for a wide range of operations, from text comparisons to HTML API editor.
- [Markdown Editor On-line](https://jbt.github.io/markdown-editor) as core editor for create this very README, in a clean nice way.
- [Midi On-line Sequencer](https://onlinesequencer.net) as on-line tool for MIDI music and basic sound composition.
- [Paint Shop Pro](http://www.paintshoppro.com/en/) as advanced graphic editor for logotype and icon creation, and other "artistic" operations.
- [Draw.io](https://www.draw.io/) as blocks, flowchart and UML diagram editor.

Beside the previously ones, the following "tools" (definition can vary) has been used in one or more steps of **Ermon** development:
- Several [Windows OSs](https://www.microsoft.com/es-es/windows) and several [Linux OSs](https://www.linux.com/what-is-linux), in order to check the behaviour of the jar in different systems.
- Several web browsers like [Google Chrome](https://www.google.es/chrome/browser/desktop/) and [Mozilla Firefox](https://www.mozilla.org/es-ES/firefox/new/), in order to check the API and GitHub appearance in different browsers.

[Back to developer index](#developer-section-index)

### External resources
The following web pages has been used during **Ermon** development as useful -or even essential- references:

- [Stack Overflow](http://stackoverflow.com/) for technical questions and bug fixes. Lots of problems and computational challenges found during the design of **Ermon** has been solved using the answers of this magnificent web.

- [W3Schools](http://www.w3schools.com/) for technical questions and tutorials, used to customize the Javadoc HTML. Perfect place to learn basics of web development.

- [Oracle Java 7 API](http://docs.oracle.com/javase/7/docs/api/) for technical questions and general information about Java programming language (core component of **Ermon**).

- [Oracle Java Code Conventions](http://www.oracle.com/technetwork/java/javase/documentation/codeconventions-139411.html) for technical questions about Java coding styles and guidelines.

- [97 things each programmer should know](http://programmer.97things.oreilly.com/wiki/index.php/97_Things_Every_Programmer_Should_Know) for superb advices, tips and lessons about the art of develop software, and more generally, the computer science.

- [Wikipedia](https://www.wikipedia.org/) for general information about any related topic: Pomodoro method, lists of software development methodologies, human-machine interaction and so on. 

Related to Ergonomy science, there are some of the resources used for both learn about the science, and create the default set of events of **Ermon**. Note that these links provide a simple approach to ergonomic questions, and thus, deeper researches can be done.

- [Microsoft Healthy Computer Guide](http://www.microsoft.com/hardware/en-us/support/healthy-computing-guide)

- [McKinley Health Center](http://www.mckinley.illinois.edu/Handouts/posture_study_habits/posture_study_habits.htm)

- [Human factors and ergonomics](https://en.wikipedia.org/wiki/Human_factors_and_ergonomics)

- [Environmental Health and Safety](http://www.ehs.pitt.edu/workplace/10steps.html)

- [Ergonomics, university of California](http://ergo.berkeley.edu/services/computer_use.php)

- [Work breaks, exercises and stretches](http://web.stanford.edu/dept/EHS/prod/general/ergo/microbreaks.html)

- [Carpal tunnel syndrome exercises for the wrist and forearm](http://www.safecomputingtips.com/ct-exercises/)

- [About desk exercises](http://www.onestopergonomics.com/pages/desk-exercises-ergonomic-breaks)

- [6 refreshing eye exercises](http://www.rebuildyourvision.com/blog/vision-conditions/computer-vision-syndrome/6-refreshing-eye-exercises-for-tired-computer-users/)

Same can be applied to the Pomodoro-set-of-events. If interested in this technique, check the [official web page](http://pomodorotechnique.com/).

[Back to developer index](#developer-section-index)

### Issues
For bug tracking, enhancements/features or change requests, check the [Issues page](https://github.com/amcajal/ermon/issues) of the project.

For professional inquiries, check the [Contact](#contact) section.

[Back to developer index](#developer-section-index)

---

### License
Alberto Martin Cajal is the original author of **Ermon** project.
**Ermon** project is released under GNU GPL version 3.0 license. Check 'LICENSE' file for a full version of it, or visit the official [GNU web page](https://www.gnu.org/licenses/gpl-3.0.html).

[Back to user index](#user-section-index)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
[Back to developer index](#developer-section-index)

### Contact
Alberto Martin Cajal at:
 
- Gmail: amartin.glimpse23@gmail.com (amartin DOT glimpse23 AT gmail DOT com)
- [Blogspot](http://glimpse-23.blogspot.com.es/)
- [LinkedIn](https://es.linkedin.com/in/alberto-martin-cajal-b0a63379)
- Twitter: @amartin_g23

[Back to user index](#user-section-index)
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
[Back to developer index](#developer-section-index)
