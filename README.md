# 🎵 Concert Setlist Tracker

## 🎯 Intro:
A Java-based program for managing concert setlists. This program helps track song order, timing, and playback status during a simulated concert performance.

## 🛠️ Tech Stack:
* Java
* Scanner for user input
* Command line interface
* Linked list data structure

## 💫 Features:
* Song management:
    * Add songs to any position
    * Remove songs from setlist
    * Auto-update start times
    * Track performance progress

* Concert simulation:
    * Real-time song tracking
    * Performance status updates
    * Automatic song transitions
    * Duration management

## 🗂️ Project Files:
* `Setlist.java` - Main program with user interface
* `Song.java` - Song data structure
* `ListInterface.java` - List ADT interface
* `LList.java` - Linked list implementation

## 🚀 Running the Project:
1. Compile all files:
```bash
javac ConcertSetlist/*.java
```
2. Run the program:
```bash
java ConcertSetlist.Setlist
```
3. Follow prompts to:
    - Add songs by position and ID
    - Remove songs as needed
    - Enter timestamps to simulate concert

## 🖼️ Sample Output:
```bash
Songs in database:
0 Hype Boy 3
1 Ditto 3
2 OMG 3
...

Enter position in setlist to add
(>=1, invalid position to exit): 1
Enter ID of song to add: 0
Setlist:
1 Hype Boy 3 0

Starting concert at time = 0 minutes!
Enter next timestamp (in minutes): 2
Hype Boy playing
```